/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller;

import com.project.admin.entity.Customer;
import com.project.admin.service.CustomerService;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NIKIL
 */
@Controller
@RequestMapping("/sign")
public class SignupController {
    @Autowired
    private CustomerService customerService;
    
    @RequestMapping(value="/add",method=RequestMethod.GET)
      public ModelAndView add() throws SQLException{
      ModelAndView mv= new ModelAndView("/views/signup/add");
      mv.addObject("Customer", new Customer());
       return mv;
      }
      @RequestMapping(value="/save",method=RequestMethod.POST)
     public String save(@ModelAttribute ("Customer")Customer customer) throws SQLException{
      try   
          {
            if(customer.getC_id()==0){
             customerService.insert(customer);
            }
            else
            { 
             customerService.update(customer);
             }
        } catch (SQLException ex) {
           
        }
    return "redirect:/room/room";
    }
}
