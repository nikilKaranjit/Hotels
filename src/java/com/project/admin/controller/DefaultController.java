/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.admin.controller;

import com.project.admin.entity.User;
import com.project.admin.service.BookingService;
import com.project.admin.service.UserService;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NIKIL
 */
@Controller

public class DefaultController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookingService bookingService;
    
    @RequestMapping( value = "/admin",method=RequestMethod.GET)
    public String login(ModelMap map){
        System.out.println("Hello");
        
        return "admin/default/login";
    }
    
    
    
    @RequestMapping(method=RequestMethod.POST,value="checking")
    public String filter(HttpServletRequest req,HttpServletResponse res){
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        User user = userService.authenticate(username,password);
        if(user==null){
            return "admin/default/login";
        }
        else {
                HttpSession session = req.getSession();
                session.setAttribute("username",username);
             if (user.getR_id()==1){
              return "admin/dashboard/dashboard";
             }
             else{
             
           return "admin/dashboard/dashboarduser";
             }
                
    }
        
    }
   
   
}
