/**
 * @author pranshu.shrivastava
 * @date Dec 25, 2019
 */
package com.inmobi.gitprofiler.dao;

import org.springframework.data.repository.CrudRepository;

import com.inmobi.gitprofiler.model.GithubProfile;

/**
 * 
 * @author pranshu.shrivastava
 *
 */
public interface GithubProfileRepository extends CrudRepository<GithubProfile, Integer> {

}
