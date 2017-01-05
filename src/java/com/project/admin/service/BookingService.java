/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.admin.service;

import com.project.admin.entity.Booking;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author NIKIL
 */
public interface BookingService {
    List<Booking> getALL() throws SQLException;
    int insert (Booking b) throws SQLException;
    int insertClient (Booking b) throws SQLException;
    int update (Booking b) throws SQLException;
    int delete (int bId) throws SQLException;
    Booking getById (int bId) throws SQLException; 
    int checkin(int bId) throws SQLException;
    List<Booking> getByUser(String username)throws SQLException;
    List <Booking> getLast(int bId) throws SQLException;
    
  
    
    
}
