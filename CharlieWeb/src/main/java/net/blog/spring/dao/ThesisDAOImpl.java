package net.blog.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.blog.spring.model.Thesis;

public class ThesisDAOImpl implements ThesisDAO {

	private static final Logger logger = LoggerFactory.getLogger(ThesisDAOImpl.class);
	 
    private SessionFactory sessionFactory;
    

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	@Override
	public void addThesis(Thesis c) {
		// TODO 自動產生的方法 Stub
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(c);
        logger.info("Thesis saved successfully, Thesis Details="+c);
	}

	@Override
	public void updateThesis(Thesis c) {
		// TODO 自動產生的方法 Stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
	    logger.info("Thesis updated successfully, Thesis Details="+c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Thesis> listThesiss() {
		// TODO 自動產生的方法 Stub
		Session session = this.sessionFactory.getCurrentSession(); 
		List<Thesis> ThesissList = session.createQuery("from Thesis").list();
        for(Thesis c : ThesissList){
            logger.info("Thesis List::"+c);
        }
        return ThesissList;
	}

	@Override
	public Thesis getThesisByName(String name) {
		// TODO 自動產生的方法 Stub
		Session session = this.sessionFactory.getCurrentSession();
		Thesis c = (Thesis) session.load(Thesis.class, name);
        logger.info("Thesis loaded successfully, Thesis details="+c);
        return c;    
	}

	@Override
	public void removeThesis(String name) {
		// TODO 自動產生的方法 Stub
		Session session = this.sessionFactory.getCurrentSession();
		Thesis c = (Thesis) session.load(Thesis.class, name);
        if(null != c){
            session.delete(c);
        }
        logger.info("Thesis deleted successfully, Thesis details="+c);
	}
}