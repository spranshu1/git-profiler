package com.inmobi.gitprofiler.config;

import java.io.IOException;

import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.inmobi.gitprofiler.util.AuthUtil;

/**
 * 
 * @author pranshu.shrivastava
 *
 */
@Configuration
public class GithubConfig {
	
	@Autowired
	private AuthUtil authUtil;

	
	/**
	 * Gets connection to github
	 * @return {@link GitHub} the github object
	 * @throws IOException the exception
	 */
	@Bean
	@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public GitHub getGitConnection() throws IOException {
		
		return GitHub.connectUsingOAuth(authUtil.getToken());
		
	}
}
