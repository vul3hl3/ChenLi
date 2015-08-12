package net.blog.spring.service;

import java.util.List;

import net.blog.spring.model.Workexp;
import net.blog.spring.dao.WorkexpDAO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WorkexpServiceImpl implements WorkexpService {
     
    private WorkexpDAO workexpDAO;
 
    public void setWorkexpDAO(WorkexpDAO WorkExpDAO) {
        this.workexpDAO = WorkExpDAO;
    }
 
    @Override
    @Transactional
    public void addWorkexp(Workexp w) {
        this.workexpDAO.addWorkexp(w);
    }
 
    @Override
    @Transactional
    public void updateWorkexp(Workexp w) {
        this.workexpDAO.updateWorkexp(w);
    }
 
    @Override
    @Transactional
    public List<Workexp> listWorkexps() {
        return this.workexpDAO.listWorkexps();
    }
 
    @Override
    @Transactional
    public Workexp getWorkexpById(int id) {
        return this.workexpDAO.getWorkexpById(id);
    }
 
    @Override
    @Transactional
    public void removeWorkexp(int id) {
        this.workexpDAO.removeWorkexp(id);
    }
 
}
