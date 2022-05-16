package com.bishu.issuerservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class OAuth2IssuerResourceServer extends ResourceServerConfigurerAdapter 
{
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
        	
        	.antMatcher("/issuer/**").authorizeRequests()
        	.antMatchers("/issuer/**")
        	.access("#oauth2.hasScope('read') or hasRole('ROLE_USER')")
        	.antMatchers("/").permitAll();
	}
}
