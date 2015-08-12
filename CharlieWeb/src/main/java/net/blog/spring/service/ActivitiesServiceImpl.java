package net.blog.spring.service;

import java.util.List;

import net.blog.spring.dao.ActivitiesDAO;
import net.blog.spring.model.Activities;

import org.springframework.transaction.annotation.Transactional;

public class ActivitiesServiceImpl implements ActivitiesService {

    private ActivitiesDAO activitiesDAO;
 
    public void setActivitiesDAO(ActivitiesDAO ActivitiesDAO) {
        this.activitiesDAO = ActivitiesDAO;
    }
 
    @Override
    @Transactional
    public void addActivities(Activities c) {
        this.activitiesDAO.addActivities(c);
    }
 
    @Override
    @Transactional
    public void updateActivities(Activities c) {
        this.activitiesDAO.updateActivities(c);
    }
 
    @Override
    @Transactional
    public List<Activities> listActivitiess() {
        return this.activitiesDAO.listActivitiess();
    }
 
    @Override
    @Transactional
    public Activities getActivitiesByName(String name) {
        return this.activitiesDAO.getActivitiesByName(name);
    }
 
    @Override
    @Transactional
    public void removeActivities(String name) {
        this.activitiesDAO.removeActivities(name);
    }

}
