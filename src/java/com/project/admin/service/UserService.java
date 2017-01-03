/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.admin.service;

import com.project.admin.entity.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nikil
 */
public interface UserService {
     List<User> getALL() throws SQLException;
    int insert (User u) throws SQLException;
    int update (User u) throws SQLException;
    int delete (int u_id) throws SQLException;
    User getById (int u_id) throws SQLException;
    public User authenticate(String username,String password);
}
