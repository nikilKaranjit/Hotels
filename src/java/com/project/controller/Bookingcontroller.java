/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.controller;

import com.itextpdf.text.DocumentException;
import com.project.admin.entity.Booking;
import com.project.admin.entity.Customer;
import com.project.admin.entity.Room;
import com.project.admin.service.BookingService;
import com.project.admin.service.CustomerService;
import com.project.admin.service.RoomService;
import com.project.util.BookingPdf;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping(value="/booking")
public class Bookingcontroller {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private RoomService roomService;
    
     

     @RequestMapping(value = "/userdetail/{username}", method = RequestMethod.GET)
    public ModelAndView userdetail(@PathVariable("username") String username) throws SQLException {
        ModelAndView mv = new ModelAndView("views/booking/index");
        mv.addObject("Booking", bookingService.getByUser(username));
        return mv;
    }
    
     @RequestMapping(value = "/delete/{bId}", method = RequestMethod.GET)
    public String delete(@PathVariable("bId") int bId) throws SQLException {
        bookingService.delete(bId);
        return "redirect:/dashboard/dashboard";
    }
  @RequestMapping(value = "/add/{ro_id}", method = RequestMethod.GET)
    public ModelAndView add(HttpServletRequest request,@PathVariable ("ro_id") int roomId) throws SQLException {
        ModelAndView mv;
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        System.out.println("username: "+username);
        if(username!=null)
        {
        mv = new ModelAndView("views/booking/add");
        String c_id = null;
        String ro_id = null;
        if (request.getParameter("c_id") != null && !request.getParameter("c_id").equals("")) 
        {
            c_id = request.getParameter("c_id");
        }
        if (request.getParameter("ro_id") != null && !request.getParameter("ro_id").equals("")) 
        {
            ro_id = request.getParameter("ro_id");
        }
        mv.addObject("Booking", new Booking());
        mv.addObject("Customer", customerService.getALL());
        mv.addObject("Room", roomService.getAll());
        Room room= roomService.getById(roomId);
        mv.addObject("roomDetails", room);
        }
        else
        {
            mv = new ModelAndView("views/login/login");
        }
        
        return mv;
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Booking") Booking booking, BindingResult result ,HttpServletRequest request) throws SQLException, ParseException, DocumentException, IOException {
        
        Customer customer=customerService.getByUsername(booking.getCustomer().getUsername());
        Room room = roomService.getById(booking.getRoom().getRo_id());
        long totalNights = (booking.getCheckoutDate().getTime() - booking.getCheckinDate().getTime()) / (24 * 60 * 60 * 1000);
        System.out.println(totalNights);
        booking.setTotalNights((int) totalNights);
        int totalPrice = (booking.getTotalNights() *  booking.getRoom().getRoomPrice());
        booking.setTotalPrice(totalPrice);
        System.out.println(totalPrice);
        System.out.println("check" + booking);
        
        try 
        {
            booking.setCustomer(customer);
            booking.setRoom(room);
            if (booking.getbId() == 0) 
                
        { 
        booking.setPdf(BookingPdf.generateBookingPDF(booking));
        System.out.println("test");
        bookingService.insertClient(booking);
        } 
        else 
        {
        bookingService.update(booking);
        }
        } 
        catch (SQLException ex) {
        }
        return "views/dashboard/dashboard";
    }
   
       

    
}