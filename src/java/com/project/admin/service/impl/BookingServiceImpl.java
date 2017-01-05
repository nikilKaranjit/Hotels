/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.admin.service.impl;

import com.project.admin.dao.BookingDAO;
import com.project.admin.entity.Booking;
import com.project.admin.service.BookingService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NIKIL
 */
@Service(value="BookingService")
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDAO bookingDAO;
    
    @Override
    public List<Booking> getALL() throws SQLException {
        return bookingDAO.getALL();
    }

    @Override
    public int insert(Booking b) throws SQLException {
        return bookingDAO.insert(b);
    }

    @Override
    public int update(Booking b) throws SQLException {
        return bookingDAO.update(b);
    }

    @Override
    public int delete(int bId) throws SQLException {
       return bookingDAO.delete(bId);
    }

    @Override
    public Booking getById(int bId) throws SQLException {
        return bookingDAO.getById(bId);
    }

    @Override
    public int checkin(int bId) throws SQLException {
        return bookingDAO.checkin(bId);
    }

 

    @Override
    public int insertClient(Booking b) throws SQLException {
        return bookingDAO.insertClient(b);
    }

    @Override
    public List<Booking> getByUser(String username) throws SQLException {
        return bookingDAO.getByUser(username);
    }

    @Override
    public List<Booking> getLast() throws SQLException {
        return bookingDAO.getLast();
    }

}
