/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller;

import com.project.admin.service.CustomerService;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NIKIL
 */
@Controller
@RequestMapping(value="/customer")
public class Customercontroller {
    @Autowired
     private CustomerService customerService;
    
     @RequestMapping(value = "/customerdetail/{username}", method = RequestMethod.GET)
    public ModelAndView userdetail(@PathVariable("username") String username) throws SQLException {
        ModelAndView mv = new ModelAndView("views/customer/index");
        mv.addObject("Customer", customerService.getByUsername(username));
        return mv;
    }
}
