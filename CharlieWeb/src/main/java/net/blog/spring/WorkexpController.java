package net.blog.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.blog.spring.model.Workexp;
import net.blog.spring.service.WorkexpService;
 
@Controller
public class WorkexpController {
     
    private WorkexpService workexpService;
     
    @Autowired(required=true)
    @Qualifier(value="workexpService")
    public void setWorkexpService(WorkexpService ws){
        this.workexpService = ws;
    }
     
    @RequestMapping(value = "/workexps", method = RequestMethod.GET)
    public String listWorkexps(Model model) {
        model.addAttribute("workexp", new Workexp());
        model.addAttribute("listWorkexps", this.workexpService.listWorkexps());
        return "workexp";
    }
     
    //For add and update WorkExp both
    @RequestMapping(value= "/workexp/add", method = RequestMethod.POST)
    public String addWorkexp(@ModelAttribute("workexp") Workexp w){
         
        if(w.getId() == 0){
            //new WorkExp, add it
            this.workexpService.addWorkexp(w);
        }else{
            //existing WorkExp, call update
            this.workexpService.updateWorkexp(w);
        }
         
        return "redirect:/workexps";
         
    }
     
    @RequestMapping("/remove/{id}")
    public String removeWorkexp(@PathVariable("id") int id){
         
        this.workexpService.removeWorkexp(id);
        return "redirect:/workexps";
    }
  
    @RequestMapping("/edit/{id}")
    public String editWorkexp(@PathVariable("id") int id, Model model){
        model.addAttribute("workexp", this.workexpService.getWorkexpById(id));
        model.addAttribute("listWorkexps", this.workexpService.listWorkexps());
        return "workexp";
    }
     
    public ModelAndView img(HttpServletRequest request,HttpServletResponse response){
    	  System.out.println("-----resources-------");
    	  return new ModelAndView("/resources");
    }
}