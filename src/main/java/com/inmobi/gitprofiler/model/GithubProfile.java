package com.inmobi.gitprofiler.model;

import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * @author pranshu.shrivastava
 *
 */
@Entity
public class GithubProfile implements Comparator<GithubProfile> {
	
	@Id
	@GeneratedValue
	private int id;

	private String handle;

	private String name;

	private String email;

	private String location;

	private String blog;

	private String company;

	private long followers;

	private long following;
	
	public GithubProfile() {}

	public GithubProfile(String handle, String name, String email) {
		this.handle = handle;
		this.name = name;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	public long getFollowers() {
		return followers;
	}

	public void setFollowers(long followers) {
		this.followers = followers;
	}

	public long getFollowing() {
		return following;
	}

	public void setFollowing(long following) {
		this.following = following;
	}
	
	@Override
	public int compare(GithubProfile o1, GithubProfile o2) {
		return o1.id - o2.id;
	}

	@Override
	public String toString() {
		return "GitHandle: " + handle + ", Email: " + email + ", Name: " + name + ", Location: " + location + ", Company: "
				+ company + ", Followers: " + followers + ", Following: " + following;
	}

	

}
