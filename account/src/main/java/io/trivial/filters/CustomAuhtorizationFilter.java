package io.trivial.filters;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.trivial.constants.SecurityConstant;
import io.trivial.service.JwtToken;

@Component
public class CustomAuhtorizationFilter extends OncePerRequestFilter {
	
	private final JwtToken jwtToken;

	@Autowired
    public CustomAuhtorizationFilter(JwtToken jwtToken) {
        this.jwtToken = jwtToken;
    }

	@Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) 
    		throws ServletException, IOException {
        if (request.getMethod().equalsIgnoreCase(SecurityConstant.HTTP_METHOD_OPTIONS)) {
            response.setStatus(HttpStatus.OK.value());
        } else {
            String authHeader = request.getHeader(SecurityConstant.USER_TOKEN_KEY);
            if (authHeader == null || !authHeader.startsWith(SecurityConstant.TOKEN_PREFIX)) {
                filterChain.doFilter(request, response);
                return;
            }
            String token = authHeader.substring(SecurityConstant.TOKEN_PREFIX.length());
            String email = jwtToken.getSubject(token);
            boolean isTokenValid = jwtToken.isTokenValid(email, token);
            boolean isAuthenticationIsNull = SecurityContextHolder.getContext().getAuthentication() == null;
            if(isTokenValid && isAuthenticationIsNull) {
            	List<GrantedAuthority> authorities = jwtToken.getAuthorities(token);
                Authentication authentication = jwtToken.getAuthentication(email, authorities, request);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                SecurityContextHolder.clearContext();
            }
        }
        filterChain.doFilter(request, response);
    }
}
