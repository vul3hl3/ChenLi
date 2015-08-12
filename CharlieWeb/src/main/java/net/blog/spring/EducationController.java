package net.blog.spring;

import net.blog.spring.model.Education;
import net.blog.spring.service.EducationService;

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
public class EducationController {

    private EducationService educationService;
    private static final Logger logger = LoggerFactory.getLogger(EducationController.class);
    @Autowired(required=true)
    @Qualifier(value="educationService")
    public void setEducationService(EducationService cs){
        this.educationService = cs;
    }
     
    @RequestMapping(value = "/educations", method = RequestMethod.GET)
    public String listEducations(Model model) {
        model.addAttribute("education", new Education());
        model.addAttribute("listEducations", this.educationService.listEducations());
        return "education";
    }
     
    //For add and update Education both
    @RequestMapping(value= "/education/add", method = RequestMethod.POST)
    public String addEducation(@ModelAttribute("education") Education c){
        if(c.getCreated() == null){
            //new Education, add it
        	logger.info("no createdTime");
            this.educationService.addEducation(c);
        }else{
            //existing Education, call update
            this.educationService.updateEducation(c);
        }
         
        return "redirect:/educations";
         
    }
     
    @RequestMapping("/education/remove/{name}")
    public String removeEducation(@PathVariable("name") String name){
         
        this.educationService.removeEducation(name);
        return "redirect:/educations";
    }
  
    @RequestMapping("/education/edit/{name}")
    public String editEducation(@PathVariable("name") String name, Model model){
        model.addAttribute("education", this.educationService.getEducationByName(name));
        model.addAttribute("listEducations", this.educationService.listEducations());
        return "education";
    }

}
