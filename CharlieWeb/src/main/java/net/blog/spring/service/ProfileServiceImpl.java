package net.blog.spring.service;

import java.util.List;

import net.blog.spring.dao.ProfileDAO;
import net.blog.spring.model.Profile;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfileServiceImpl implements ProfileService {

    private ProfileDAO profileDAO;
 
    public void setProfileDAO(ProfileDAO ProfileDAO) {
        this.profileDAO = ProfileDAO;
    }
 
    @Override
    @Transactional
    public void addProfile(Profile p) {
        this.profileDAO.addProfile(p);
    }
 
    @Override
    @Transactional
    public void updateProfile(Profile p) {
        this.profileDAO.updateProfile(p);
    }
 
    @Override
    @Transactional
    public List<Profile> listProfiles() {
        return this.profileDAO.listProfiles();
    }
 
    @Override
    @Transactional
    public Profile getProfileById(String id) {
        return this.profileDAO.getProfileById(id);
    }
 
    @Override
    @Transactional
    public void removeProfile(String id) {
        this.profileDAO.removeProfile(id);
    }
}
