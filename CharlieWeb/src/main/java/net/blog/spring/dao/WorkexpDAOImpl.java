package net.blog.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
 
import  net.blog.spring.model.Workexp;
 
@Repository
public class WorkexpDAOImpl implements WorkexpDAO {
     
    private static final Logger logger = LoggerFactory.getLogger(WorkexpDAOImpl.class);
 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Override
    public void addWorkexp(Workexp w) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(w);
        logger.info("WorkExp saved successfully, WorkExp Details="+w);
    }
 
    @Override
    public void updateWorkexp(Workexp w) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(w);
        logger.info("WorkExp updated successfully, WorkExp Details="+w);
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Workexp> listWorkexps() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Workexp> WorkexpsList = session.createQuery("from Workexp").list();
        for(Workexp w : WorkexpsList){
            logger.info("Workexp List::"+w);
        }
        return WorkexpsList;
    }
 
    @Override
    public Workexp getWorkexpById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Workexp w = (Workexp) session.load(Workexp.class, new Integer(id));
        logger.info("WorkExp loaded successfully, WorkExp details="+w);
        return w;
    }
 
    @Override
    public void removeWorkexp(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Workexp w = (Workexp) session.load(Workexp.class, new Integer(id));
        if(null != w){
            session.delete(w);
        }
        logger.info("WorkExp deleted successfully, WorkExp details="+w);
    }
 
}