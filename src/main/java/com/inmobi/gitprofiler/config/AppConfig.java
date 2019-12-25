/**
 *
 * @author pranshu.shrivastava
 * @date Dec 25, 2019
 */
package com.inmobi.gitprofiler.config;

import java.io.IOException;

import org.kohsuke.github.GitHub;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	/**
	 * Gets connection to github
	 * @return {@link GitHub} the github object
	 * @throws IOException the exception
	 */
	@Bean
	public GitHub getGitConnection() throws IOException {
		return GitHub.connectUsingPassword("spranshu1", "20Twenty7*?");
	}
}
