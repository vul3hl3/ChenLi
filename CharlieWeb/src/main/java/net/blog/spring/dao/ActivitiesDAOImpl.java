package net.blog.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.blog.spring.model.Activities;

public class ActivitiesDAOImpl implements ActivitiesDAO {

	private static final Logger logger = LoggerFactory.getLogger(ActivitiesDAOImpl.class);
	 
    private SessionFactory sessionFactory;
    

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	@Override
	public void addActivities(Activities c) {
		// TODO 自動產生的方法 Stub
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(c);
        logger.info("Activities saved successfully, Activities Details="+c);
	}

	@Override
	public void updateActivities(Activities c) {
		// TODO 自動產生的方法 Stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
	    logger.info("Activities updated successfully, Activities Details="+c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Activities> listActivitiess() {
		// TODO 自動產生的方法 Stub
		Session session = this.sessionFactory.getCurrentSession(); 
		List<Activities> ActivitiessList = session.createQuery("from Activities").list();
        for(Activities c : ActivitiessList){
            logger.info("Activities List::"+c);
        }
        return ActivitiessList;
	}

	@Override
	public Activities getActivitiesByName(String name) {
		// TODO 自動產生的方法 Stub
		Session session = this.sessionFactory.getCurrentSession();
		Activities c = (Activities) session.load(Activities.class, name);
        logger.info("Activities loaded successfully, Activities details="+c);
        return c;    
	}

	@Override
	public void removeActivities(String name) {
		// TODO 自動產生的方法 Stub
		Session session = this.sessionFactory.getCurrentSession();
		Activities c = (Activities) session.load(Activities.class, name);
        if(null != c){
            session.delete(c);
        }
        logger.info("Activities deleted successfully, Activities details="+c);
	}

}
