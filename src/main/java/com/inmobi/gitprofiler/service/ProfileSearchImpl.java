/**
 *
 * @author pranshu.shrivastava
 * @date Dec 25, 2019
 */
package com.inmobi.gitprofiler.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.PagedIterator;
import org.kohsuke.github.PagedSearchIterable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.inmobi.gitprofiler.model.GithubProfile;

@Service
public class ProfileSearchImpl implements ProfileSearchService {

	private static final Logger LOG = LoggerFactory.getLogger(ProfileSearchImpl.class);

	@Autowired
	private GitHub gitHub;

	/**
	 * Gets the user profile by handle name
	 */
	@Override
	public GithubProfile getProfile(String gitHandle) throws IOException {
		GithubProfile userProfile = null;
		if (StringUtils.isEmpty(gitHandle)) {
			LOG.info("Empty search query");
		} else {

			final GHUser ghUser = gitHub.getUser(gitHandle);
			if (ghUser != null) {
				userProfile = new GithubProfile(ghUser.getLogin(), ghUser.getName(), ghUser.getEmail());
				userProfile.setBlog(ghUser.getBlog());
				userProfile.setCompany(ghUser.getCompany());
				userProfile.setFollowers(ghUser.getFollowersCount());
				userProfile.setFollowing(ghUser.getFollowingCount());
			}
		}
		return userProfile;
	}

	/**
	 * Gets list of user profiles with matching handle names
	 */
	@Override
	public List<GithubProfile> getProfiles(String gitHandle) throws IOException {
		final List<GithubProfile> profiles = new ArrayList<>();
		if (StringUtils.isEmpty(gitHandle)) {
			LOG.debug("Empty search query");
		} else {
			final PagedSearchIterable<GHUser> allUsers = gitHub.searchUsers()
														.q(gitHandle)
														.in("login")
														.list()
														.withPageSize(10);
			PagedIterator<GHUser> userIterator = allUsers.iterator();
			// Currently only 10 records, can be modified to implement proper pagination
			for (GHUser user : userIterator.nextPage()) {
				GithubProfile userProfile = new GithubProfile(user.getLogin(), user.getName(), user.getEmail());
				userProfile.setBlog(user.getBlog());
				userProfile.setCompany(user.getCompany());
				userProfile.setFollowers(user.getFollowersCount());
				userProfile.setFollowing(user.getFollowingCount());

				profiles.add(userProfile);
			}
		}
		if(LOG.isDebugEnabled())
			LOG.debug("Profiles found with handle {} -> {}", gitHandle, profiles);
		return profiles;
	}

}
