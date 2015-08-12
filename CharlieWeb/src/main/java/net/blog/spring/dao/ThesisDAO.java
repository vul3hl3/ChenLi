package net.blog.spring.dao;

import java.util.List;

import net.blog.spring.model.Thesis;

public interface ThesisDAO {
    public void addThesis(Thesis c);
    public void updateThesis(Thesis c);
    public List<Thesis> listThesiss();
    public Thesis getThesisByName(String name);
    public void removeThesis(String name);
}
