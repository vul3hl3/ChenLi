package net.blog.spring;

import net.blog.spring.model.Thesis;
import net.blog.spring.service.ThesisService;

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
public class ThesisController {

    private ThesisService thesisService;
    private static final Logger logger = LoggerFactory.getLogger(ThesisController.class);
    @Autowired(required=true)
    @Qualifier(value="thesisService")
    public void setThesisService(ThesisService cs){
        this.thesisService = cs;
    }
     
    @RequestMapping(value = "/thesiss", method = RequestMethod.GET)
    public String listThesiss(Model model) {
    	logger.info("enter listThesiss");
        model.addAttribute("thesis", new Thesis());
        model.addAttribute("listThesiss", this.thesisService.listThesiss());
        return "thesis";
    }
     
    //For add and update Thesis both
    @RequestMapping(value= "/thesis/add", method = RequestMethod.POST)
    public String addThesis(@ModelAttribute("thesis") Thesis c){
        if(c.getCreated() == null){
            //new Thesis, add it
        	logger.info("no createdTime");
            this.thesisService.addThesis(c);
        }else{
            //existing Thesis, call update
            this.thesisService.updateThesis(c);
        }
         
        return "redirect:/thesiss";
         
    }
     
    @RequestMapping("/thesis/remove/{name}")
    public String removeThesis(@PathVariable("name") String name){
         
        this.thesisService.removeThesis(name);
        return "redirect:/thesiss";
    }
  
    @RequestMapping("/thesis/edit/{name}")
    public String editThesis(@PathVariable("name") String name, Model model){
        model.addAttribute("thesis", this.thesisService.getThesisByName(name));
        model.addAttribute("listThesiss", this.thesisService.listThesiss());
        return "thesis";
    }


}
