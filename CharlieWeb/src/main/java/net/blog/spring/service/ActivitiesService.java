package net.blog.spring.service;

import java.util.List;

import net.blog.spring.model.Activities;

public interface ActivitiesService {
	 public void addActivities(Activities c);
	    public void updateActivities(Activities c);
	    public List<Activities> listActivitiess();
	    public Activities getActivitiesByName(String name);
	    public void removeActivities(String name);

}
