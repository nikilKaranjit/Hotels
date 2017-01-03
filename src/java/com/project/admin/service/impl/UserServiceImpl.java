/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.admin.service.impl;

import com.project.admin.dao.UserDAO;
import com.project.admin.entity.User;
import com.project.admin.service.UserService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nikil
 */
@Service(value="UserService")
public class UserServiceImpl implements UserService {
  
    @Autowired
    private UserDAO userDAO;
     
    @Override
    public List<User> getALL() throws SQLException {
        return userDAO.getALL();
    }

    @Override
    public int insert(User u) throws SQLException {
        return userDAO.insert(u);
    }

    @Override
    public int update(User u) throws SQLException {
        return userDAO.update(u);
    }

    @Override
    public int delete(int u_id) throws SQLException {
        return userDAO.delete(u_id);
    }

    @Override
    public User getById(int u_id) throws SQLException {
        return userDAO.getById(u_id);
    }

    @Override
    public User authenticate(String username, String password) {
        return userDAO.authenticate(username, password);
    }
    
}
