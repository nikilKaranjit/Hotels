/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller;

import com.project.admin.entity.Comments;
import com.project.admin.entity.Customer;
import com.project.admin.service.CommentsService;
import com.project.admin.service.CustomerService;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NIKIL
 */
@Controller
@RequestMapping(value="/about")
public class Commentcontroller {
     
     @Autowired
     private CommentsService commentsService;
     @Autowired
     private  CustomerService customerService;
    
     @RequestMapping(method=RequestMethod.GET)
    public String index(){
    return "views/aboutus/index";
    }
     @RequestMapping(value="/add",method=RequestMethod.GET)
      public ModelAndView add(HttpServletRequest request) throws SQLException{
      ModelAndView mv= new ModelAndView("/views/aboutus/add");
      String  c_id=null;
        if(request.getParameter("c_id")!=null && !request.getParameter("c_id").equals("") )
        {
            c_id= request.getParameter("c_id");
        } 
      mv.addObject("Comments", new Comments());
      mv.addObject("Customer", customerService.getALL());
       return mv;
      }
      @RequestMapping(value="/save",method=RequestMethod.POST)
    public String save(@ModelAttribute ("Comments") Comments comment, BindingResult result) throws SQLException{
        
          System.out.println();
        System.out.println("chcek"+comment.getCustomer());
        Customer customer=customerService.getByUsername(comment.getCustomer().getUsername());
        try  
          {  
              comment.setCustomer(customer);
           if(comment.getCommentsId()==0){
            commentsService.insert(comment);
            
           
            
            }
            else
           { 
            commentsService.update(comment);
           }
        } catch (SQLException ex) {
           
        }
    return "redirect:/about";
    }
  
    
}
