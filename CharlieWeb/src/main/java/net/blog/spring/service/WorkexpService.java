package net.blog.spring.service;

import java.util.List;

import net.blog.spring.model.Workexp;

public interface WorkexpService {
	 public void addWorkexp(Workexp w);
	    public void updateWorkexp(Workexp w);
	    public List<Workexp> listWorkexps();
	    public Workexp getWorkexpById(int id);
	    public void removeWorkexp(int id);
}
