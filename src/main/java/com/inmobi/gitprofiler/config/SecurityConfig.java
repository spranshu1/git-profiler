package com.inmobi.gitprofiler.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/**
 * 
 * @author pranshu.shrivastava
 *
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
         .authorizeRequests()
         	.anyRequest()
         		.authenticated()
         .and()
         	.oauth2Login()
         .and()
         	.logout().logoutSuccessUrl("/login")
         	.invalidateHttpSession(true)
         	.deleteCookies("JSESSIONID")
         	.permitAll()
         	;
    }
}