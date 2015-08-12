package net.blog.spring;

import net.blog.spring.model.Profile;
import net.blog.spring.service.ProfileService;
import net.blog.spring.model.Workexp;
import net.blog.spring.service.WorkexpService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfileController {

    private ProfileService profileService;
    private WorkexpService workexpService;
    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
    @Autowired(required=true)
    @Qualifier(value="profileService")
    public void setProfileService(ProfileService ps){
        this.profileService = ps;
    }
     
    @Autowired(required=true)
    @Qualifier(value="workexpService")
    public void setWorkexpService(WorkexpService ws){
        this.workexpService = ws;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayIndex(Model model) {
        model.addAttribute("profile", new Profile());
        model.addAttribute("listProfiles", this.profileService.listProfiles());
        model.addAttribute("workexp", new Workexp());
        model.addAttribute("listWorkexps", this.workexpService.listWorkexps());
        return "index";
    }
    
    @RequestMapping(value = "/profiles", method = RequestMethod.GET)
    public String listProfiles(Model model) {
        model.addAttribute("profile", new Profile());
        model.addAttribute("listProfiles", this.profileService.listProfiles());
        return "profile";
    }
     
    //For add and update WorkExp both
    @RequestMapping(value= "/profile/add", method = RequestMethod.POST)
    public String addProfile(@ModelAttribute("profile") Profile p){
        if(p.getCreated() == null){
            //new Profile, add it
        	logger.info("no createdTime");
            this.profileService.addProfile(p);
        }else{
            //existing Profile, call update
            this.profileService.updateProfile(p);
        }
         
        return "redirect:/profiles";
         
    }
     
    @RequestMapping("/profile/remove/{id}")
    public String removeProfile(@PathVariable("id") String id){
         
        this.profileService.removeProfile(id);
        return "redirect:/profiles";
    }
  
    @RequestMapping("/profile/edit/{id}")
    public String editProfile(@PathVariable("id") String id, Model model){
        model.addAttribute("profile", this.profileService.getProfileById(id));
        model.addAttribute("listProfiles", this.profileService.listProfiles());
        return "profile";
    }
}
