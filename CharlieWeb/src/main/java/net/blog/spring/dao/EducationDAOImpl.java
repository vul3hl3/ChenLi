package net.blog.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.blog.spring.model.Education;

public class EducationDAOImpl implements EducationDAO {

	private static final Logger logger = LoggerFactory.getLogger(EducationDAOImpl.class);
	 
    private SessionFactory sessionFactory;
    

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	@Override
	public void addEducation(Education c) {
		// TODO 自動產生的方法 Stub
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(c);
        logger.info("Education saved successfully, Education Details="+c);
	}

	@Override
	public void updateEducation(Education c) {
		// TODO 自動產生的方法 Stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
	    logger.info("Education updated successfully, Education Details="+c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Education> listEducations() {
		// TODO 自動產生的方法 Stub
		Session session = this.sessionFactory.getCurrentSession(); 
		List<Education> EducationsList = session.createQuery("from Education").list();
        for(Education c : EducationsList){
            logger.info("Education List::"+c);
        }
        return EducationsList;
	}

	@Override
	public Education getEducationByName(String name) {
		// TODO 自動產生的方法 Stub
		Session session = this.sessionFactory.getCurrentSession();
		Education c = (Education) session.load(Education.class, name);
        logger.info("Education loaded successfully, Education details="+c);
        return c;    
	}

	@Override
	public void removeEducation(String name) {
		// TODO 自動產生的方法 Stub
		Session session = this.sessionFactory.getCurrentSession();
		Education c = (Education) session.load(Education.class, name);
        if(null != c){
            session.delete(c);
        }
        logger.info("Education deleted successfully, Education details="+c);
	}

}
