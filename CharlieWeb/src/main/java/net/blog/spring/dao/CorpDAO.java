package net.blog.spring.dao;

import java.util.List;

import net.blog.spring.model.Corp;

public interface CorpDAO {

    public void addCorp(Corp c);
    public void updateCorp(Corp c);
    public List<Corp> listCorps();
    public Corp getCorpBySname(String sname);
    public void removeCorp(String sname);
}
