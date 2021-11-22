package io.trivial.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import io.trivial.models.entites.User;

public interface JwtToken {

	/**
	 * Returns user token and refresh token in this order.
	 */
	String[] generateJwtTokens(User user);
	
	String getSubject(String token);
	
	boolean isTokenValid(String email, String token);
	
	List<GrantedAuthority> getAuthorities(String token);
	
	Authentication getAuthentication(String username, List<GrantedAuthority> authorities, HttpServletRequest request);

}
