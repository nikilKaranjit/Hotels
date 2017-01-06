/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.admin.service.impl;

import com.project.admin.dao.CheckinDAO;
import com.project.admin.entity.Checkin;
import com.project.admin.service.CheckinService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NIKIL
 */
@Service(value="CheckinService")
public class CheckinServiceImpl implements CheckinService {

    @Autowired
    private CheckinDAO checkinDAO;
    
    @Override
    public List<Checkin> getALL() throws SQLException {
        return checkinDAO.getALL();
    }

    @Override
    public int checkout(int checkinId) throws SQLException {
        return checkinDAO.checkout(checkinId);
    }
    
}
