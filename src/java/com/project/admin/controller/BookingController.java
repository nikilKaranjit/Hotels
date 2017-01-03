/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.admin.controller;

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
@RequestMapping(value = "/admin/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private RoomService roomService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap map) throws SQLException {
        map.addAttribute("Booking", bookingService.getALL());
        return "admin/booking/index";
    }
 

    

    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add(HttpServletRequest request) throws SQLException {
        ModelAndView mv = new ModelAndView("/admin/booking/add");
        String c_id = null;
        String ro_id = null;
        if (request.getParameter("c_id") != null && !request.getParameter("c_id").equals("")) {
            c_id = request.getParameter("c_id");
        }
        if (request.getParameter("ro_id") != null && !request.getParameter("ro_id").equals("")) {
            ro_id = request.getParameter("ro_id");
        }
        mv.addObject("Booking", new Booking());
        mv.addObject("Customer", customerService.getALL());
        mv.addObject("Room", roomService.getAll());
        
        
        return mv;
    }

    @RequestMapping(value = "/edit/{bId}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("bId") int bId) throws SQLException {
        ModelAndView mv = new ModelAndView("admin/booking/edit");
        mv.addObject("Booking", bookingService.getById(bId));
        return mv;
    }
     @RequestMapping(value = "/checkin/{bId}", method = RequestMethod.GET)
    public ModelAndView checkin(@PathVariable("bId") int bId) throws SQLException {
        ModelAndView mv = new ModelAndView("admin/checkin/index");
        mv.addObject("booking", bookingService.checkin(bId));
        return mv;
    }
      
    
    

    @RequestMapping(value = "/delete/{bId}", method = RequestMethod.GET)
    public String delete(@PathVariable("bId") int bId) throws SQLException {
        bookingService.delete(bId);
        return "redirect:/admin/booking";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Booking") Booking booking, BindingResult result, HttpServletRequest request) throws SQLException, ParseException, DocumentException, IOException {
        Customer customer = customerService.getById(booking.getCustomer().getC_id());
        Room room = roomService.getById(booking.getRoom().getRo_id());
        long totalNights = (booking.getCheckoutDate().getTime() - booking.getCheckinDate().getTime()) / (24 * 60 * 60 * 1000);
        System.out.println(totalNights);
        booking.setTotalNights((int) totalNights);
        int totalPrice = (booking.getTotalNights() *  booking.getRoom().getRoomPrice());
        booking.setTotalPrice(totalPrice);
        System.out.println(totalPrice);

        System.out.println("check" + booking);
        try {
            booking.setCustomer(customer);
            booking.setRoom(room);
            if (booking.getbId() == 0) {
                
                  booking.setPdf(BookingPdf.generateBookingPDF(booking));
                bookingService.insert(booking);

            } else {
                bookingService.update(booking);
            }
        } catch (SQLException ex) {
        }
        return "redirect:/admin/booking";
    }

   
}
