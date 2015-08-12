package net.blog.spring;

import net.blog.spring.model.Corp;
import net.blog.spring.service.CorpService;

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
public class CorpController {

    private CorpService corpService;
    private static final Logger logger = LoggerFactory.getLogger(CorpController.class);
    @Autowired(required=true)
    @Qualifier(value="corpService")
    public void setCorpService(CorpService cs){
        this.corpService = cs;
    }
     
    @RequestMapping(value = "/corps", method = RequestMethod.GET)
    public String listCorps(Model model) {
        model.addAttribute("corp", new Corp());
        model.addAttribute("listCorps", this.corpService.listCorps());
        return "corp";
    }
     
    //For add and update WorkExp both
    @RequestMapping(value= "/corp/add", method = RequestMethod.POST)
    public String addCorp(@ModelAttribute("corp") Corp c){
        if(c.getCreated() == null){
            //new Corp, add it
        	logger.info("no createdTime");
            this.corpService.addCorp(c);
        }else{
            //existing Corp, call update
            this.corpService.updateCorp(c);
        }
         
        return "redirect:/corps";
         
    }
     
    @RequestMapping("/corp/remove/{sname}")
    public String removeCorp(@PathVariable("sname") String sname){
         
        this.corpService.removeCorp(sname);
        return "redirect:/corps";
    }
  
    @RequestMapping("/corp/edit/{sname}")
    public String editCorp(@PathVariable("sname") String sname, Model model){
        model.addAttribute("corp", this.corpService.getCorpBySname(sname));
        model.addAttribute("listCorps", this.corpService.listCorps());
        return "corp";
    }
     
}
