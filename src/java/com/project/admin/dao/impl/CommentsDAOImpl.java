/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.admin.dao.impl;

import com.project.admin.constant.SQLConstant;
import com.project.admin.dao.CommentsDAO;
import com.project.admin.entity.Comments;
import com.project.admin.entity.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author NIKIL
 */
@Repository(value = "CommentsDAO")
public class CommentsDAOImpl implements CommentsDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Comments> getALL() throws SQLException {
        return jdbcTemplate.query(SQLConstant.COMMENTS_GETALL, new RowMapper<Comments>() {

            @Override
            public Comments mapRow(ResultSet rs, int i) throws SQLException {
                return mapData(rs);
            }
        });
    }

    @Override
    public int insert(Comments comm) throws SQLException {
            
     System.out.println("check:"+ comm.getCustomer().getC_id());
        return jdbcTemplate.update(SQLConstant.COMMENTS_INSERT, new Object[]{comm.getCommentsId(),comm.getCustomer().getC_id(),comm.getCustomer().getFirstName(),comm.getCustomer().getLastName(), comm.getCustomer().getUsername(),comm.getMessage()});
    }

    private Comments mapData(ResultSet rs) throws SQLException {
        Comments comments = new Comments();
        comments.setCommentsId(rs.getInt("comments_id"));
        Customer customer = new Customer();
        customer.setC_id(rs.getInt("c_id"));
        customer.setFirstName(rs.getString("first_name"));
        customer.setLastName(rs.getString("last_name"));
        customer.setUsername(rs.getString("username"));
        comments.setCustomer(customer);
        comments.setMessage(rs.getString("message"));
        return comments;
    }

    @Override
    public int update(Comments comm) throws SQLException {
        
        
        return jdbcTemplate.update(SQLConstant.COMMENTS_UPDATE, new Object[]{comm.getMessage(), comm.getCustomer().getC_id(),comm.getCustomer().getFirstName(),comm.getCustomer().getLastName(), comm.getCommentsId()});
    }

    @Override
    public int delete(int commentsId) throws SQLException {
        System.out.println(commentsId);
        return jdbcTemplate.update(SQLConstant.COMMENTS_DELETE, new Object[]{commentsId});
    }

    @Override
    public Comments getById(int commentsId) throws SQLException {
        return (Comments) jdbcTemplate.query(SQLConstant.COMMENTS_GETBYID, new Object[]{commentsId}, new ResultSetExtractor<Comments>() {

            @Override
            public Comments extractData(ResultSet rs) throws SQLException, DataAccessException {
                Comments comments = null;
                if (rs.next()) {
                    comments = new Comments();
                    comments.setCommentsId(rs.getInt("comments_id"));
                    Customer customer = new Customer();
                    customer.setC_id(rs.getInt("c_id"));
                    customer.setFirstName(rs.getString("first_name"));
                    customer.setLastName(rs.getString("last_name"));
                    comments.setCustomer(customer);
                    comments.setMessage(rs.getString("message"));

                }
                return comments;
            }
        });
    }

}
