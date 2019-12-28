package com.inmobi.gitprofiler.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Component;

/**
 * 
 * @author pranshu.shrivastava
 *
 */
@Component
public class AuthUtil {
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthUtil.class);
	
	@Autowired
	private OAuth2AuthorizedClientService clientService;

	/**
	 * Gets the auth token of logged in client
	 * @return
	 */
	public String getToken() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		final OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
		
		final OAuth2AuthorizedClient client = clientService
										.loadAuthorizedClient(oauthToken.getAuthorizedClientRegistrationId(), oauthToken.getName());
		final String token = client.getAccessToken().getTokenValue();
		
		LOG.info("Auth Token : {}",token);
		return token;
	}

}
