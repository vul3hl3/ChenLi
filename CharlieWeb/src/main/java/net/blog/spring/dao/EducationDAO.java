package net.blog.spring.dao;

import java.util.List;

import net.blog.spring.model.Education;

public interface EducationDAO {
    public void addEducation(Education c);
    public void updateEducation(Education c);
    public List<Education> listEducations();
    public Education getEducationByName(String name);
    public void removeEducation(String name);
}
