package net.blog.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.blog.spring.model.Corp;

public class CorpDAOImpl implements CorpDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CorpDAOImpl.class);
	 
    private SessionFactory sessionFactory;
    

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	@Override
	public void addCorp(Corp c) {
		// TODO 自動產生的方法 Stub
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(c);
        logger.info("Corp saved successfully, Corp Details="+c);
	}

	@Override
	public void updateCorp(Corp c) {
		// TODO 自動產生的方法 Stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
	    logger.info("Corp updated successfully, Corp Details="+c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Corp> listCorps() {
		// TODO 自動產生的方法 Stub
		Session session = this.sessionFactory.getCurrentSession(); 
		List<Corp> CorpsList = session.createQuery("from Corp").list();
        for(Corp c : CorpsList){
            logger.info("Corp List::"+c);
        }
        return CorpsList;
	}

	@Override
	public Corp getCorpBySname(String sname) {
		// TODO 自動產生的方法 Stub
		Session session = this.sessionFactory.getCurrentSession();
		Corp c = (Corp) session.load(Corp.class, sname);
        logger.info("Corp loaded successfully, Corp details="+c);
        return c;    
	}

	@Override
	public void removeCorp(String sname) {
		// TODO 自動產生的方法 Stub
		Session session = this.sessionFactory.getCurrentSession();
		Corp c = (Corp) session.load(Corp.class, sname);
        if(null != c){
            session.delete(c);
        }
        logger.info("Corp deleted successfully, Corp details="+c);
	}

}
