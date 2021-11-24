package io.trivial.service.impl;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static java.util.Arrays.stream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.JWTVerifier;

import io.trivial.constants.SecurityConstant;
import io.trivial.models.entites.User;
import io.trivial.service.JwtToken;

@Component
public class JwtTokenImpl implements JwtToken {

//    @Value("${jwt.secret}")
    private static final String SECRET = "i8y8f7tsdjn37866745276&^&*U(H";

    @Override
    public String[] generateJwtTokens(User user) {
        String[] claims = getClaimsFromUser(user);
        String accessToken = JWT.create()
        		.withIssuer(SecurityConstant.TRIVIAL)
        		.withIssuedAt(new Date())
        		.withSubject(user.getEmail())
        		.withArrayClaim(SecurityConstant.AUTHORITIES, claims)
        		.withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 100))
        		.sign(HMAC512(SECRET.getBytes()));
		String refreshToken = JWT.create()
				.withIssuer(SecurityConstant.TRIVIAL)
				.withSubject(user.getEmail())
				.withExpiresAt(new Date(System.currentTimeMillis() + 30 * 60 * 100))
				.sign(HMAC512(SECRET.getBytes()));
		String[] tokens = new String[2];
		tokens[0] = accessToken;
		tokens[1] = refreshToken;
		return tokens;
    }
    
    @Override
    public String getSubject(String token) {
        JWTVerifier verifier = getJWTVerifier();
        return verifier.verify(token).getSubject();
    }
    
    @Override
    public List<GrantedAuthority> getAuthorities(String token) {
        String[] claims = getClaimsFromToken(token);
        return stream(claims).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public Authentication getAuthentication(String username, List<GrantedAuthority> authorities, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken userPasswordAuthToken = new
                UsernamePasswordAuthenticationToken(username, null, authorities);
        userPasswordAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        return userPasswordAuthToken;
    }

    @Override
    public boolean isTokenValid(String email, String token) {
        JWTVerifier verifier = getJWTVerifier();
        return StringUtils.isNotEmpty(email) && !isTokenExpired(verifier, token);
    }
    
    private String[] getClaimsFromUser(User user) {
        List<String> userAuthorities = new ArrayList<>();
        for (GrantedAuthority grantedAuthority : user.getAuthorities()){
        	userAuthorities.add(grantedAuthority.getAuthority());
        }
        return userAuthorities.toArray(new String[0]);
    }

    private boolean isTokenExpired(JWTVerifier verifier, String token) {
        Date expiration = verifier.verify(token).getExpiresAt();
        return expiration.before(new Date());
    }

    private String[] getClaimsFromToken(String token) {
        JWTVerifier verifier = getJWTVerifier();
        return verifier.verify(token).getClaim(SecurityConstant.AUTHORITIES).asArray(String.class);
    }

    private JWTVerifier getJWTVerifier() {
        JWTVerifier verifier;
        try {
            Algorithm algorithm = HMAC512(SECRET);
            verifier = JWT.require(algorithm).withIssuer(SecurityConstant.TRIVIAL).build();
        }catch (JWTVerificationException exception) {
            throw new JWTVerificationException("TOKEN_CANNOT_BE_VERIFIED");
        }
        return verifier;
    }
}