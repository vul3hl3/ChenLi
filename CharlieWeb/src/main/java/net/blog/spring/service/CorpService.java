package net.blog.spring.service;

import java.util.List;

import net.blog.spring.model.Corp;

public interface CorpService {
	 public void addCorp(Corp c);
	    public void updateCorp(Corp c);
	    public List<Corp> listCorps();
	    public Corp getCorpBySname(String sname);
	    public void removeCorp(String sname);
}
