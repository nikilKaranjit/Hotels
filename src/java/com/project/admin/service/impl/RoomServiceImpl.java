/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.admin.service.impl;

import com.project.admin.dao.RoomDAO;
import com.project.admin.entity.Room;
import com.project.admin.service.RoomService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nikil
 */
@Service(value = "RoomService")
public class RoomServiceImpl implements RoomService {

    @Autowired 
    private RoomDAO roomDAO;
    
    @Override
    public List<Room> getAll() throws SQLException {
        return roomDAO.getALL();
    }

    @Override
    public int insert(Room r) throws SQLException {
        return roomDAO.insert(r);
    }

    @Override
    public int update(Room r) throws SQLException {
        return roomDAO.update(r);
    }

    @Override
    public int delete(int ro_id) throws SQLException {
      return roomDAO.delete(ro_id);
    }

    @Override
    public Room getById(int ro_id) throws SQLException {
        return roomDAO.getById(ro_id);
    }
    
}
