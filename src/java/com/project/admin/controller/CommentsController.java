/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.admin.controller;

import com.project.admin.entity.Comments;
import com.project.admin.entity.Customer;
import com.project.admin.entity.User;
import com.project.admin.service.CommentsService;
import com.project.admin.service.CustomerService;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NIKIL
 */
@Controller
@RequestMapping(value="/admin/comments")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;
    @Autowired
    private CustomerService customerService;
    

        @RequestMapping(method = RequestMethod.GET)
     public String index (ModelMap map) throws SQLException{
     map.addAttribute("Comments",commentsService.getALL());
     return "admin/comments/index";
     }
         @RequestMapping(value="/add",method=RequestMethod.GET)
      public ModelAndView add(HttpServletRequest request) throws SQLException{
      ModelAndView mv= new ModelAndView("/admin/comments/add");
      String  c_id=null;
        if(request.getParameter("c_id")!=null && !request.getParameter("c_id").equals("") )
        {
            c_id= request.getParameter("c_id");
        } 
      mv.addObject("Comments", new Comments());
      mv.addObject("Customer", customerService.getALL());
       return mv;
      }
      
      @RequestMapping(value = "/delete/{commentsId}",method = RequestMethod.GET)
    public String delete(@PathVariable("commentsId") int commentsId)throws SQLException
    {
        System.out.println(commentsId);
        commentsService.delete(commentsId);
        return  "redirect:/admin/comments";
    }
     
    @RequestMapping(value="/save",method=RequestMethod.POST)
    public String save(@ModelAttribute ("Comments") Comments comment, BindingResult result) throws SQLException{
        System.out.println("chcek"+comment.getCustomer());
        Customer customer=customerService.getById(comment.getCustomer().getC_id());
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
    return "redirect:/admin/comments";
    }
}
