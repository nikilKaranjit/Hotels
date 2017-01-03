    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.admin.entity;

import java.sql.Date;


//import java.util.Date;

/**
 *
 * @author NIKIL
 */
public class Booking {

    
    private int bId;
    private String firstName;
    private String lastName;
    private Room room;
    private Date checkinDate;
    private int totalNights;
    private Date checkoutDate;
    private int totalPrice;
    private Customer customer;
    private boolean status;
    private String pdf;

    public Booking() {
    }

    public Booking(int bId, String firstName, String lastName, Room room, Date checkinDate, int totalNights, Date checkoutDate, int totalPrice, Customer customer, boolean status, String pdf) {
        this.bId = bId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.room = room;
        this.checkinDate = checkinDate;
        this.totalNights = totalNights;
        this.checkoutDate = checkoutDate;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.status = status;
        this.pdf = pdf;
    }

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public int getTotalNights() {
        return totalNights;
    }

    public void setTotalNights(int totalNights) {
        this.totalNights = totalNights;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    @Override
    public String toString() {
        return "Booking{" + "bId=" + bId + ", firstName=" + firstName + ", lastName=" + lastName + ", room=" + room + ", checkinDate=" + checkinDate + ", totalNights=" + totalNights + ", checkoutDate=" + checkoutDate + ", totalPrice=" + totalPrice + ", customer=" + customer + ", status=" + status + ", pdf=" + pdf + '}';
    }

    

   

    
    
}
