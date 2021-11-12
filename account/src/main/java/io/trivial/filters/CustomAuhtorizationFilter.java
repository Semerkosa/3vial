package io.trivial.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomAuhtorizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if (request.getServletPath().equals("/login") || request.getServletPath().equals("/user/token/refresh/**")) {
			filterChain.doFilter(request, response);
		} else {
			String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
			if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
				try {
					String token = authorizationHeader.substring("Bearer ".length());
					Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
					JWTVerifier verifier = JWT.require(algorithm).build();
					DecodedJWT decodedJWT = verifier.verify(token);
					String email = decodedJWT.getSubject();
					String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
					List<SimpleGrantedAuthority> authorities = Arrays.stream(roles)
							.map(r -> new SimpleGrantedAuthority(r)).collect(Collectors.toList());
					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
							email, null, authorities);
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
					filterChain.doFilter(request, response);
				} catch (Exception e) {
					response.setHeader("error", e.getMessage());
					response.setStatus(HttpStatus.FORBIDDEN.value());
//					response.sendError(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.name());
					Map<String, String> error = new HashMap<>();
					error.put("error-message", e.getMessage());
					response.setContentType(MediaType.APPLICATION_JSON_VALUE);
					new ObjectMapper().writeValue(response.getOutputStream(), error);
					filterChain.doFilter(request, response);
				}
			}
//			else {
//				System.out.println("The token is missing or is not correct!");
//				response.setHeader("error", "The token is missing or is not correct!");
//				response.setStatus(HttpStatus.FORBIDDEN.value());
//				Map<String, String> error = new HashMap<>();
//				error.put("error-message", "The token is missing or is not correct!");
//				response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//				new ObjectMapper().writeValue(response.getOutputStream(), error);
//				filterChain.doFilter(request, response);
//			}
			
		}

	}

}
