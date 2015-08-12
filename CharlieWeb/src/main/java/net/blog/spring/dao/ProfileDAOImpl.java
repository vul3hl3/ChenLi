package net.blog.spring.dao;

import java.util.List;

import net.blog.spring.model.Profile;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfileDAOImpl implements ProfileDAO {

	private static final Logger logger = LoggerFactory.getLogger(ProfileDAOImpl.class);
	 
    private SessionFactory sessionFactory;
    

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	@Override
	public void addProfile(Profile p) {
		// TODO 自動產生的方法 Stub
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Profile saved successfully, Profile Details="+p);
	}

	@Override
	public void updateProfile(Profile p) {
		// TODO 自動產生的方法 Stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
	    logger.info("Profile updated successfully, Profile Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profile> listProfiles() {
		// TODO 自動產生的方法 Stub
		Session session = this.sessionFactory.getCurrentSession(); 
		List<Profile> ProfilesList = session.createQuery("from Profile").list();
        for(Profile p : ProfilesList){
            logger.info("Profile List::"+p);
        }
        return ProfilesList;
	}

	@Override
	public Profile getProfileById(String id) {
		// TODO 自動產生的方法 Stub
		Session session = this.sessionFactory.getCurrentSession();
		Profile p = (Profile) session.load(Profile.class, id);
        logger.info("Profile loaded successfully, Profile details="+p);
        return p;    
	}

	@Override
	public void removeProfile(String sname) {
		// TODO 自動產生的方法 Stub
		Session session = this.sessionFactory.getCurrentSession();
		Profile p = (Profile) session.load(Profile.class, sname);
        if(null != p){
            session.delete(p);
        }
        logger.info("Profile deleted successfully, Profile details="+p);
	}

}
