/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.admin.service;

import com.project.admin.entity.Comments;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author NIKIL
 */
public interface CommentsService {
    List<Comments> getALL() throws SQLException;
    int insert (Comments comm) throws SQLException;
    int update (Comments comm) throws SQLException;
    int delete (int commentsId) throws SQLException;
    Comments getById (int commentsId) throws SQLException;
    
}
