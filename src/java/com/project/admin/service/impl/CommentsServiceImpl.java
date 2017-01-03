/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.admin.service.impl;

import com.project.admin.dao.CommentsDAO;
import com.project.admin.entity.Comments;
import com.project.admin.service.CommentsService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author NIKIL
 */
@Repository(value="CommentsService")
public class CommentsServiceImpl implements CommentsService {
    
    @Autowired
    private CommentsDAO commentsDAO;

    @Override
    public List<Comments> getALL() throws SQLException {
        return commentsDAO.getALL();
    }

    @Override
    public int insert(Comments comm) throws SQLException {
        return commentsDAO.insert(comm);
    }

    @Override
    public int update(Comments comm) throws SQLException {
        return commentsDAO.update(comm);
    }

    @Override
    public int delete(int commentsId) throws SQLException {
        return commentsDAO.delete(commentsId);
    }

    @Override
    public Comments getById(int commentsId) throws SQLException {
        return commentsDAO.getById(commentsId);
    }
    
}
