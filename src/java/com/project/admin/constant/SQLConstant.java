/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.admin.constant;

/**
 *
 * @author Nikil
 */
public class SQLConstant {

    public final static String USER_GETALL = " SELECT * FROM " + TableConstant.TABLE_USER;
    public final static String USER_INSERT = " INSERT INTO " + TableConstant.TABLE_USER
            + " (first_name,last_name,email,username,password,r_id) VALUES ( ? , ? , ? , ? , ? , ? ) ";
    public final static String USER_DELETE = " DELETE FROM " + TableConstant.TABLE_USER + " WHERE u_id= ?";
    public final static String USER_GETById = " SELECT * from " + TableConstant.TABLE_USER + " WHERE u_id=? ";
    public final static String USER_UPDATE = " UPDATE " + TableConstant.TABLE_USER + " SET   first_name=?,last_name=?,email=?,username=?,password=?,r_id=? WHERE u_id=? ";
    public final static String USER_AUTHENTICATE = " SELECT * FROM " + TableConstant.TABLE_USER + " WHERE username=? AND password=? ";

//Room
    public final static String ROOM_GETALL = " SELECT * FROM " + TableConstant.TABLE_ROOM;
    public final static String ROOM_INSERT = " INSERT INTO " + TableConstant.TABLE_ROOM + " (ro_id,room_type,room_description,room_number,room_price,image)  VALUES (? ,? , ? , ? ,? ,?) ";
    public final static String ROOM_UPDATE = " UPDATE " + TableConstant.TABLE_ROOM + " SET room_type=?,room_description=?,room_number=?,room_price=? ,image=?  WHERE ro_id = ? ";
    public final static String ROOM_DELETE = " DELETE FROM " + TableConstant.TABLE_ROOM + " WHERE ro_id=?";
    public final static String ROOM_GETBYID = " SELECT * FROM " + TableConstant.TABLE_ROOM + " WHERE ro_id=?";

  //Customer
    public final static String CUSTOMER_GETALL = " SELECT * FROM " + TableConstant.TABLE_CUSTOMER;
    public final static String CUSTOMER_INSERT = " INSERT INTO " + TableConstant.TABLE_CUSTOMER
            + "(c_id,firstname,lastname,email,contact_no,username,password)"
            + " VALUES (?,?,?,?,?,?,?) ";
    public final static String CUSTOMER_UPDATE = " UPDATE " + TableConstant.TABLE_CUSTOMER + " SET firstname=?,lastname=?,email=?,contact_no=?,username=?,password=? WHERE c_id=? ";
    public final static String CUSTOMER_DELETE = " DELETE  FROM " + TableConstant.TABLE_CUSTOMER + " WHERE c_id=?";
    public final static String CUSTOMER_GETBYID = " SELECT * FROM " + TableConstant.TABLE_CUSTOMER + " WHERE c_id = ? ";
    public final static String CUSTOMER_AUTHENTICATE = " SELECT * FROM " + TableConstant.TABLE_CUSTOMER + " WHERE username=? AND password=? ";
    public final static String CUSTOMER_GETBYUSER = " SELECT * FROM " + TableConstant.TABLE_CUSTOMER + " WHERE username=?  ";
    public final static String CUSTOMER_GETLAST= " SELECT * FROM " + TableConstant.TABLE_CUSTOMER + " ORDER BY c_id DESC LIMIT  5 ";

    
    //Booking
    public final static String BOOKING_GETALL = " SELECT * FROM " + TableConstant.TABLE_BOOKING + " b join " + TableConstant.TABLE_ROOM + " r on b.ro_id = r.ro_id join " + TableConstant.TABLE_CUSTOMER + " c on c.c_id=b.c_id ";
    public final static String BOOKING_INSERT = " INSERT INTO " + TableConstant.TABLE_BOOKING
            + "(first_name,last_name,ro_id,room_number,room_price,room_type,checkin_date,total_nights,checkout_date,total_price,c_id,pdf,status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?) ";
    public final static String BOOKING_UPDATE = " UPDATE " + TableConstant.TABLE_BOOKING + "  SET first_name=?,last_name=?,"
            + "checkin_date=?,total_nights=?,total_price=?,checkout_date=?,status=? WHERE b_id=? ";
    public final static String BOOKING_DELETE = " DELETE FROM " + TableConstant.TABLE_BOOKING + " WHERE b_id=? ";
    public final static String BOOKING_GETBYID = " SELECT * FROM " + TableConstant.TABLE_BOOKING + " b join "
            + TableConstant.TABLE_ROOM + " r on b.ro_id=r.ro_id join " + TableConstant.TABLE_CUSTOMER + " c on c.c_id = b.c_id  WHERE b_id=? ";
    public final static String BOOKING_CHECKIN = " INSERT INTO " + TableConstant.TABLE_CHECKIN + "(b_id,first_name,last_name,room_price,room_number,checkin_date,checkout_date,total_price ,total_nights) SELECT b_id,first_name,last_name,room_price,room_number, checkin_date, checkout_date,total_price ,total_nights From " + TableConstant.TABLE_BOOKING + " where b_id=? ";
    public final static String BOOKING_INSERTCLIENT = " INSERT INTO " + TableConstant.TABLE_BOOKING
            + "(first_name,last_name,ro_id,room_number,room_price,room_type,checkin_date,total_nights,checkout_date,total_price,c_id,username,pdf,status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
    public final static String BOOKING_GETBYUSER= " SELECT * FROM  " + TableConstant.TABLE_BOOKING + " WHERE username = ? " ;
    public final static String BOOKING_GETLAST= " SELECT * FROM " + TableConstant.TABLE_BOOKING + " ORDER BY b_id DESC LIMIT  5 ";
    
    
    
     //comments
    public final static String COMMENTS_GETALL = " SELECT * FROM " + TableConstant.TABLE_COMMENTS + " c join " + TableConstant.TABLE_CUSTOMER + " cu on c.c_id = cu.c_id ";
    public final static String COMMENTS_INSERT = " INSERT INTO " + TableConstant.TABLE_COMMENTS + " ( comments_id,c_id,first_name,last_name,username,message) VALUES (?,?,?,?,?,?) ";
    public final static String COMMENTS_UPDATE = " UPDATE " + TableConstant.TABLE_COMMENTS + " SET message=? , customer=? WHERE comments_id=? ";
    public final static String COMMENTS_DELETE = " DELETE FROM " + TableConstant.TABLE_COMMENTS + " WHERE comments_id = ? ";
    public final static String COMMENTS_GETBYID = " SELECT * FROM " + TableConstant.TABLE_COMMENTS + " c join " + TableConstant.TABLE_CUSTOMER + " cu on c.c_id = cu.c_id WHERE comments_id=? ";
    
//CheckIn
    public final static String CHECKIN_GETALL =  " SELECT * FROM  " + TableConstant.TABLE_CHECKIN;
    public final static String CHECKIN_CHECKOUT= " INSERT INTO  " + TableConstant.TABLE_CHECKOUT + "(checkin_id,first_name,last_name,room_price,room_number,checkin_date,checkout_date,total_price ,total_nights) SELECT checkin_id,first_name,last_name,room_price,room_number, checkin_date, checkout_date,total_price ,total_nights From " + TableConstant.TABLE_CHECKIN + " where checkin_id=? " ;

}
