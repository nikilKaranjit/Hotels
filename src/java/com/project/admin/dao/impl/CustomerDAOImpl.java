/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.admin.dao.impl;

import com.project.admin.constant.SQLConstant;
import com.project.admin.dao.CustomerDAO;
import com.project.admin.entity.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nikil
 */
@Repository(value = "CustomerDAO")
public class CustomerDAOImpl implements CustomerDAO {
    
    @Autowired
     private JdbcTemplate jdbcTemplate;
    

    @Override
    public List<Customer> getALL() throws SQLException {
       return jdbcTemplate.query(SQLConstant.CUSTOMER_GETALL, new RowMapper<Customer>() {

           @Override
           public Customer mapRow(ResultSet rs, int i) throws SQLException {
               return mapData(rs);
           }
       });
    }

    @Override
    public int insert(Customer c) throws SQLException {
       return jdbcTemplate.update(SQLConstant.CUSTOMER_INSERT,new Object[]{c.getC_id(),c.getFirstName(),c.getLastName(),c.getEmail(),c.getContactNo(),c.getUsername(),c.getPassword()});
   
       }
    
      private Customer mapData(ResultSet rs) throws SQLException{
      Customer c= new Customer();
      c.setC_id(rs.getInt("c_id"));
      c.setFirstName(rs.getString("firstname"));
      c.setLastName(rs.getString("lastname"));
      c.setEmail(rs.getString("email"));
      c.setContactNo(rs.getInt("contact_no"));
      c.setUsername(rs.getString("username"));
      c.setPassword(rs.getString("password"));
      return c;
    
    }
    

    @Override
    public int update(Customer c) throws SQLException {
        return jdbcTemplate.update(SQLConstant.CUSTOMER_UPDATE, new Object[]{c.getFirstName(),c.getLastName(),c.getEmail(),c.getContactNo(),c.getUsername(),c.getPassword(),c.getC_id()});
       
   }

    @Override
    public int delete(int c_id) throws SQLException {
        return jdbcTemplate.update(SQLConstant.CUSTOMER_DELETE, new Object[]{c_id});
    }

    @Override
    public Customer getById(int c_id) throws SQLException {
      return (Customer) jdbcTemplate.query(SQLConstant.CUSTOMER_GETBYID, new Object[]{c_id} ,new ResultSetExtractor<Customer>() {

          @Override
          public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {
             Customer c= null;
             if(rs.next()){
             c = new Customer();
             c.setC_id(rs.getInt("c_id"));
             c.setFirstName(rs.getString("firstname"));
             c.setLastName(rs.getString("lastname"));
             c.setEmail(rs.getString("email"));
             c.setContactNo(rs.getInt("contact_no"));
             c.setUsername(rs.getString("username"));
             c.setPassword(rs.getString("password"));
             
             }
             return c;
          }
      });
    }

    @Override
    public Customer authenticate(String username, String password) {
        return (Customer) jdbcTemplate.query(SQLConstant.CUSTOMER_AUTHENTICATE, new Object[]{username,password},new ResultSetExtractor<Customer>() {

            @Override
            public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {
                Customer c= null;
             if(rs.next()){
             c = new Customer();
             c.setC_id(rs.getInt("c_id"));
             c.setFirstName(rs.getString("firstname"));
             c.setLastName(rs.getString("lastname"));
             c.setEmail(rs.getString("email"));
             c.setContactNo(rs.getInt("contact_no"));
             c.setUsername(rs.getString("username"));
             c.setPassword(rs.getString("password"));
             
             }
             return c;
            }
        });
    }

    @Override
    public Customer getByUsername(String username) throws SQLException {
        return jdbcTemplate.query(SQLConstant.CUSTOMER_GETBYUSER, new Object[]{username},new ResultSetExtractor<Customer>() {

            @Override
            public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {
                Customer c= null;
             if(rs.next()){
             c = new Customer();
             c.setC_id(rs.getInt("c_id"));
             c.setFirstName(rs.getString("firstname"));
             c.setLastName(rs.getString("lastname"));
             c.setEmail(rs.getString("email"));
             c.setContactNo(rs.getInt("contact_no"));
             c.setUsername(rs.getString("username"));
             c.setPassword(rs.getString("password"));
             
             }
             return c;
               
            }
        });
    }
    }
    
 
