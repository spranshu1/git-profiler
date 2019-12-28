
package com.inmobi.gitprofiler.service;

import java.util.List;

import com.inmobi.gitprofiler.model.GithubProfile;

/**
 * 
 * @author pranshu.shrivastava
 *
 */
public interface ProfileHistoryService {
	
	List<GithubProfile> getSearchHistory();
	
	GithubProfile getProfileHistory(int profileId);
	
	void saveOrUpdate(GithubProfile profile);
	
	void saveOrUpdate(List<GithubProfile> profiles);
	
	void delete(int profileId);

}
