/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller;

import com.project.admin.service.RoomService;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NIKIL
 */
@Controller
@RequestMapping(value="/room")
public class RoomController {
    @Autowired
    private RoomService roomService;
    
     @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody ModelMap saveRoom(@PathVariable("id") int id) throws SQLException {
        ModelMap map = new ModelMap();
        map.addAttribute("roomById", roomService.getById(id));
        return map;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap map, HttpServletRequest request) throws SQLException{
        map.addAttribute("Room", roomService.getAll());
        return "views/room/room";
        
   }
     
}
