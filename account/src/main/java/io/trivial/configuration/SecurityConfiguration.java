package io.trivial.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import io.trivial.filters.CustomAuhtorizationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private final UserDetailsService userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final CustomAuhtorizationFilter customAuhtorizationFilter;
	 
	@Autowired
	public SecurityConfiguration (UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder, 
			CustomAuhtorizationFilter customAuhtorizationFilter) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userDetailsService = userDetailsService;
		this.customAuhtorizationFilter = customAuhtorizationFilter;
	}
	
    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(this.bCryptPasswordEncoder);
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
		System.out.println("Method -> configure(HttpSecurity http)");
        http
        	.csrf().disable()
        	.cors()
        .and()
        	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        	.authorizeRequests()
        	.antMatchers("**")  // TODO(issue #233): figure out how to limit to just login and register
        	.permitAll()
        	.anyRequest()
        	.authenticated()
        .and()
        	.addFilterBefore(this.customAuhtorizationFilter, UsernamePasswordAuthenticationFilter.class);     
    }
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
