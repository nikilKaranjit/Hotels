/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.admin.service.impl;

import com.project.admin.dao.CheckoutDAO;
import com.project.admin.entity.Checkout;
import com.project.admin.service.CheckoutService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author NIKIL
 */
@Repository(value="CheckoutService")
public class CheckoutServiceImpl implements CheckoutService {
@Autowired
private CheckoutDAO checkoutDAO;
    @Override
    public List<Checkout> getALL() throws SQLException {
        return checkoutDAO.getALL();
    }
    
}
