package com.bishu.bookservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
@EnableResourceServer
public class OAuth2BooksResourceServer extends ResourceServerConfigurerAdapter 
{
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
        	
        	.antMatcher("/books/**").authorizeRequests()
        	.antMatchers("/books/**")
        	.access("#oauth2.hasScope('read') or hasRole('ROLE_USER')")
        	.antMatchers("/").permitAll();
	}	  
	  
}