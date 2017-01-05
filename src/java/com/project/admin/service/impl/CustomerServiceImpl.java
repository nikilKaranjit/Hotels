/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.admin.service.impl;

import com.project.admin.dao.CustomerDAO;
import com.project.admin.entity.Customer;
import com.project.admin.service.CustomerService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nikil
 */
@Service(value = "CustomerService")
public class CustomerServiceImpl implements CustomerService{
    @Autowired
     private CustomerDAO customerDAO;
    @Override
    public List<Customer> getALL() throws SQLException {
        return customerDAO.getALL();
    }

    @Override
    public int insert(Customer c) throws SQLException {
       return customerDAO.insert(c);
    }

    @Override
    public int update(Customer c) throws SQLException {
       return customerDAO.update(c);
    }

    @Override
    public int delete(int c_id) throws SQLException {
        return customerDAO.delete(c_id);
    }

    @Override
    public Customer getById(int c_id) throws SQLException {
      return customerDAO.getById(c_id);
    }

    @Override
    public Customer authenticate(String username, String password) {
         return customerDAO.authenticate(username, password);
    }

    @Override
    public Customer getByUsername(String username) throws SQLException {
        return customerDAO.getByUsername(username);
    }

    @Override
    public List<Customer> getLast() throws SQLException {
        return customerDAO.getLast();
    }
    
}
