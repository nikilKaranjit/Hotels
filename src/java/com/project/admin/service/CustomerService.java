/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.admin.service;

import com.project.admin.entity.Customer;
import com.project.admin.entity.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nikil
 */
public interface CustomerService {
    List<Customer> getALL() throws SQLException;
    int insert (Customer c) throws SQLException;
    int update (Customer c) throws SQLException;
    int delete (int c_id) throws SQLException;
    Customer getById (int c_id) throws SQLException; 
    public Customer authenticate(String username,String password);
     Customer getByUsername(String username)throws SQLException;
       List <Customer> getLast() throws SQLException;
    
}
