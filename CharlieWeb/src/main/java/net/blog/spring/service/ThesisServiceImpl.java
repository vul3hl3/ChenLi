package net.blog.spring.service;

import java.util.List;

import net.blog.spring.dao.ThesisDAO;
import net.blog.spring.model.Thesis;

import org.springframework.transaction.annotation.Transactional;

public class ThesisServiceImpl implements ThesisService {

    private ThesisDAO thesisDAO;
 
    public void setThesisDAO(ThesisDAO ThesisDAO) {
        this.thesisDAO = ThesisDAO;
    }
 
    @Override
    @Transactional
    public void addThesis(Thesis c) {
        this.thesisDAO.addThesis(c);
    }
 
    @Override
    @Transactional
    public void updateThesis(Thesis c) {
        this.thesisDAO.updateThesis(c);
    }
 
    @Override
    @Transactional
    public List<Thesis> listThesiss() {
        return this.thesisDAO.listThesiss();
    }
 
    @Override
    @Transactional
    public Thesis getThesisByName(String name) {
        return this.thesisDAO.getThesisByName(name);
    }
 
    @Override
    @Transactional
    public void removeThesis(String name) {
        this.thesisDAO.removeThesis(name);
    }



}
