/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.admin.dao;

import com.project.admin.entity.Checkout;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author NIKIL
 */
public interface CheckoutDAO {
     List<Checkout> getALL() throws SQLException;
}
