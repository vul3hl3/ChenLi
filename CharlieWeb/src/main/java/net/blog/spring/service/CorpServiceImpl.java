package net.blog.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.blog.spring.dao.CorpDAO;
import net.blog.spring.model.Corp;

@Service
public class CorpServiceImpl implements CorpService {

    private CorpDAO corpDAO;
 
    public void setCorpDAO(CorpDAO CorpDAO) {
        this.corpDAO = CorpDAO;
    }
 
    @Override
    @Transactional
    public void addCorp(Corp c) {
        this.corpDAO.addCorp(c);
    }
 
    @Override
    @Transactional
    public void updateCorp(Corp c) {
        this.corpDAO.updateCorp(c);
    }
 
    @Override
    @Transactional
    public List<Corp> listCorps() {
        return this.corpDAO.listCorps();
    }
 
    @Override
    @Transactional
    public Corp getCorpBySname(String sname) {
        return this.corpDAO.getCorpBySname(sname);
    }
 
    @Override
    @Transactional
    public void removeCorp(String sname) {
        this.corpDAO.removeCorp(sname);
    }
}
