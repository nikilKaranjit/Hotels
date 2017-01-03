/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.admin.controller;

import com.project.admin.entity.Room;

import com.project.admin.service.RoomService;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author Nikil
 */
@Controller
@RequestMapping(value = "/admin/room")

public class Roomcontroller {

    @Autowired
    private RoomService roomService;

     @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody ModelMap saveRoom(@PathVariable("id") int id) throws SQLException {
        ModelMap map = new ModelMap();
        map.addAttribute("roomById", roomService.getById(id));
        return map;
    }
  
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap map) throws SQLException {
        map.addAttribute("Room", roomService.getAll());
        return "admin/room/index";
    }

    @RequestMapping(value = "/addroom", method = RequestMethod.GET)
    public String addRoom() throws SQLException {
        return "admin/room/addroom";
    }

    @RequestMapping(value = "/editroom/{ro_id}", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView edit(@PathVariable("ro_id") int ro_id) throws SQLException {
        ModelAndView mv = new ModelAndView("admin/room/editroom");
        mv.addObject("Room", roomService.getById(ro_id));
        return mv;
    }

    @RequestMapping(value = "/deleteroom/{ro_id}", method = RequestMethod.GET)
    public String delete(@PathVariable("ro_id") int ro_id) throws SQLException {
        roomService.delete(ro_id);
        return "redirect:/admin/room";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam("roomType") String roomType, @RequestParam(value = "id", required = false) String idParam,
            @RequestParam("roomDescription") String roomDescription, @RequestParam("roomNumber") int roomNumber, @RequestParam("roomPrice") int roomPrice,
            @RequestParam("file" ) MultipartFile multipartFile, HttpServletRequest req) throws SQLException, IOException {

        Room room = null;
        if (StringUtils.hasLength(idParam)) {
            room = roomService.getById(Integer.parseInt(idParam));
        } else {
            room = new Room();
        }

        room.setRoomType(roomType);
        room.setRoomDescription(roomDescription);
        room.setRoomNumber(roomNumber);
        room.setRoomPrice(roomPrice);

        System.out.println(room.getRo_id());
        if (room.getRo_id() == 0) {

            room = saveOrUpdateImage(multipartFile, room);
            roomService.insert(room);
        } else {
            room = saveOrUpdateImage(multipartFile, room);
            roomService.update(room);
        }
        return "redirect:/admin/room";
    }

    private Room saveOrUpdateImage(MultipartFile multipartFile, Room room) {
        try {
            // You can change the directory.
            File roomImageDirectory = new File("D:\\Hotels\\web\\WEB-INF\\assets\\uploadedImages");
            if (!roomImageDirectory.exists()) {
                roomImageDirectory.mkdirs();
            }
            String[] fileNameToken = multipartFile.getOriginalFilename().split("\\.");
            // You can change file name to be saved.
            String newFileName = "room-" + room.getRoomNumber() + "." + fileNameToken[fileNameToken.length - 1];
            File roomImage = new File(roomImageDirectory, "/" + newFileName);
            roomImage.createNewFile();
            multipartFile.transferTo(roomImage);
            room.setImage(newFileName);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return room;
    }

}
