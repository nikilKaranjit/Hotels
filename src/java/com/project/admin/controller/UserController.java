/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.admin.controller;

import com.project.admin.entity.User;
import com.project.admin.service.UserService;
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
@RequestMapping(value = "/admin/users")
public class UserController {
    @Autowired
    private UserService userService;
     
     @RequestMapping(method = RequestMethod.GET)
      public String index (ModelMap map) throws SQLException{
          map.addAttribute("User",userService.getALL());
          return "admin/users/index";
           }
      
      @RequestMapping(value="/adduser",method=RequestMethod.GET)
      public ModelAndView adduser() throws SQLException{
      ModelAndView mv= new ModelAndView("/admin/users/adduser");
      mv.addObject("User", new User());
       return mv;
      }
        
      @RequestMapping(value = "/edituser/{u_id}", method = RequestMethod.GET)
      public ModelAndView edit(@PathVariable("u_id") int u_id) throws SQLException{
        ModelAndView mv = new ModelAndView("admin/users/edituser");
        mv.addObject("User", userService.getById(u_id));
        return mv;
    }
         @RequestMapping(value = "/delete/{u_id}",method = RequestMethod.GET)
    public String delete(@PathVariable("u_id") int u_id)throws SQLException
    {
        userService.delete(u_id);
        return  "redirect:/admin/users";
    }
     
      
      
      
        @RequestMapping(value="/save",method=RequestMethod.POST)
    public String save(@ModelAttribute ("User")User user) throws SQLException{
      try  
          {
           if(user.getU_id()==0){
            userService.insert(user);
            }
            else
           { 
            userService.update(user);
           }
        } catch (SQLException ex) {
           
        }
    return "redirect:/admin/users";
    }
     
    
}

