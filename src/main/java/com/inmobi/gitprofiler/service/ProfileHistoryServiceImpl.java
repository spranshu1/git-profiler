/**
 * @author pranshu.shrivastava
 * @date Dec 25, 2019
 */
package com.inmobi.gitprofiler.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inmobi.gitprofiler.dao.GithubProfileRepository;
import com.inmobi.gitprofiler.model.GithubProfile;

public class ProfileHistoryServiceImpl implements ProfileHistoryService {
	
	@Autowired
	private GithubProfileRepository profileRepository;

	@Override
	public List<GithubProfile> getSearchHistory() {
		List<GithubProfile> profiles = new ArrayList<>();
		profileRepository.findAll().forEach(profile -> profiles.add(profile));
		return profiles;
	}

	@Override
	public GithubProfile getProfileHistory(int profileId) {
		return profileRepository.findById(profileId).get();
	}

	@Override
	public void delete(int profileId) {
		profileRepository.deleteById(profileId);
	}

}
