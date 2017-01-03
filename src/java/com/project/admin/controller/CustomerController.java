/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.admin.controller;


import com.project.admin.entity.Customer;
import com.project.admin.service.CustomerService;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author Nikil
 */
@Controller
@RequestMapping(value="/admin/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerservice;
    
    
     @RequestMapping(method = RequestMethod.GET)
     public String index (ModelMap map) throws SQLException{
     map.addAttribute("Customer",customerservice.getALL());
     return "admin/customer/index";
     }
     
      @RequestMapping(value="/add",method=RequestMethod.GET)
      public ModelAndView add() throws SQLException{
      ModelAndView mv= new ModelAndView("/admin/customer/add");
      mv.addObject("Customer", new Customer());
       return mv;
      }
       @RequestMapping(value = "/edit/{c_id}", method = RequestMethod.GET)
        public ModelAndView edit(@PathVariable("c_id") int c_id) throws SQLException{
        ModelAndView mv = new ModelAndView("admin/customer/edit");
        mv.addObject("Customer", customerservice.getById(c_id));
        return mv;
    }
         @RequestMapping(value = "/delete/{c_id}",method = RequestMethod.GET)
    public String delete(@PathVariable("c_id") int c_id)throws SQLException
    {
        customerservice.delete(c_id);
        return  "redirect:/admin/customer";
    }
     
      
     @RequestMapping(value="/save",method=RequestMethod.POST)
     public String save(@ModelAttribute ("Customer")Customer customer) throws SQLException{
      try   
          {
            if(customer.getC_id()==0){
             customerservice.insert(customer);
            }
            else
            { 
             customerservice.update(customer);
             }
        } catch (SQLException ex) {
           
        }
    return "redirect:/admin/customer";
    }
     
     
    
    
}
