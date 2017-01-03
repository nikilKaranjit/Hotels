/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.admin.dao;

import com.project.admin.entity.Room;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nikil
 */
public interface RoomDAO {
    
      List<Room> getALL() throws SQLException;
    int insert (Room r) throws SQLException;
    int update (Room r) throws SQLException;
    int delete (int ro_id) throws SQLException;
    Room getById (int ro_id) throws SQLException;   
 
}
