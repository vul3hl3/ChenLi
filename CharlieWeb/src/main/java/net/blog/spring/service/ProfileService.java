package net.blog.spring.service;

import java.util.List;

import net.blog.spring.model.Profile;

public interface ProfileService {
	 public void addProfile(Profile p);
	    public void updateProfile(Profile p);
	    public List<Profile> listProfiles();
	    public Profile getProfileById(String id);
	    public void removeProfile(String id);
}
