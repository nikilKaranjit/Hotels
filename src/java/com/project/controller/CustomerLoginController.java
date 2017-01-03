/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller;

import com.project.admin.entity.Customer;
import com.project.admin.service.CustomerService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author NIKIL
 */
@Controller
@RequestMapping(value="/login")
public class CustomerLoginController {
    @Autowired
    private CustomerService customerService;
    @RequestMapping(method=RequestMethod.GET)
    public String login(ModelMap map){
        System.out.println("Hello");
        return "views/login/login";
    }
     @RequestMapping(method=RequestMethod.POST,value="checking")
    public String filter(HttpServletRequest req,HttpServletResponse res){
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        Customer customer =customerService.authenticate(username,password);
        if(customer==null){
            return "?check=failed";
        }
        else {
            
            HttpSession session = req.getSession();
             session.setAttribute("username", username);
            return "views/dashboard/dashboard";
                
    }
    
       
    }
}
