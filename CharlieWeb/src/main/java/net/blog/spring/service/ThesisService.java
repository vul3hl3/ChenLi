package net.blog.spring.service;

import java.util.List;

import net.blog.spring.model.Thesis;

public interface ThesisService {
	 public void addThesis(Thesis c);
	    public void updateThesis(Thesis c);
	    public List<Thesis> listThesiss();
	    public Thesis getThesisByName(String name);
	    public void removeThesis(String name);

}
