/**
 * @author pranshu.shrivastava
 * @date Dec 25, 2019
 */
package com.inmobi.gitprofiler.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmobi.gitprofiler.dao.GithubProfileRepository;
import com.inmobi.gitprofiler.model.GithubProfile;

@Service
public class ProfileHistoryServiceImpl implements ProfileHistoryService {
	
	@Autowired
	private GithubProfileRepository profileRepository;

	@Override
	public List<GithubProfile> getSearchHistory() {
		List<GithubProfile> profiles = new ArrayList<>();
		profileRepository.findAll().forEach(profile -> profiles.add(profile));
		//Reverse order list to show last search on top
		Collections.reverse(profiles);
		return profiles;
	}

	@Override
	public GithubProfile getProfileHistory(int profileId) {
		return profileRepository.findById(profileId).get();
	}
	
	@Override
	public void saveOrUpdate(GithubProfile profile) {
		profileRepository.save(profile);
    }
	
	@Override
	public void saveOrUpdate(List<GithubProfile> profiles) {
		if(profiles != null && !profiles.isEmpty()) {
			for(GithubProfile profile : profiles) {
				saveOrUpdate(profile);
			}
		}
		
	}

	@Override
	public void delete(int profileId) {
		profileRepository.deleteById(profileId);
	}

}
