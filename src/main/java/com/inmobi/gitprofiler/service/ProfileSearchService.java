package com.inmobi.gitprofiler.service;

import java.io.IOException;
import java.util.List;

import com.inmobi.gitprofiler.model.GithubProfile;
/**
 *
 * @author pranshu.shrivastava
 *
 */
public interface ProfileSearchService {

    GithubProfile getProfile(String gitHandle) throws IOException;
    
    List<GithubProfile> getProfiles(String gitHandle) throws IOException;

}
