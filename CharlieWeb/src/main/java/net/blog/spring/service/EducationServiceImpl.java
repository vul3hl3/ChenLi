package net.blog.spring.service;

import java.util.List;

import net.blog.spring.dao.EducationDAO;
import net.blog.spring.model.Education;

import org.springframework.transaction.annotation.Transactional;

public class EducationServiceImpl implements EducationService {

    private EducationDAO educationDAO;
 
    public void setEducationDAO(EducationDAO EducationDAO) {
        this.educationDAO = EducationDAO;
    }
 
    @Override
    @Transactional
    public void addEducation(Education c) {
        this.educationDAO.addEducation(c);
    }
 
    @Override
    @Transactional
    public void updateEducation(Education c) {
        this.educationDAO.updateEducation(c);
    }
 
    @Override
    @Transactional
    public List<Education> listEducations() {
        return this.educationDAO.listEducations();
    }
 
    @Override
    @Transactional
    public Education getEducationByName(String name) {
        return this.educationDAO.getEducationByName(name);
    }
 
    @Override
    @Transactional
    public void removeEducation(String name) {
        this.educationDAO.removeEducation(name);
    }


}
