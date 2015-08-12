package net.blog.spring;

import net.blog.spring.model.Activities;
import net.blog.spring.service.ActivitiesService;

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
public class ActivitiesController {

    private ActivitiesService activitiesService;
    private static final Logger logger = LoggerFactory.getLogger(ActivitiesController.class);
    @Autowired(required=true)
    @Qualifier(value="activitiesService")
    public void setActivitiesService(ActivitiesService cs){
        this.activitiesService = cs;
    }
     
    @RequestMapping(value = "/activitiess", method = RequestMethod.GET)
    public String listActivitiess(Model model) {
        model.addAttribute("activities", new Activities());
        model.addAttribute("listActivitiess", this.activitiesService.listActivitiess());
        return "activities";
    }
     
    //For add and update Activities both
    @RequestMapping(value= "/activities/add", method = RequestMethod.POST)
    public String addActivities(@ModelAttribute("activities") Activities c){
        if(c.getCreated() == null){
            //new Activities, add it
        	logger.info("no createdTime");
            this.activitiesService.addActivities(c);
        }else{
            //existing Activities, call update
            this.activitiesService.updateActivities(c);
        }
         
        return "redirect:/activitiess";
         
    }
     
    @RequestMapping("/activities/remove/{name}")
    public String removeActivities(@PathVariable("name") String name){
         
        this.activitiesService.removeActivities(name);
        return "redirect:/activitiess";
    }
  
    @RequestMapping("/activities/edit/{name}")
    public String editActivities(@PathVariable("name") String name, Model model){
        model.addAttribute("activities", this.activitiesService.getActivitiesByName(name));
        model.addAttribute("listActivitiess", this.activitiesService.listActivitiess());
        return "activities";
    }
     

}
