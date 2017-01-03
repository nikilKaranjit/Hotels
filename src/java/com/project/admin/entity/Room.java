/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.admin.entity;


/**
 *
 * @author Nikil
 */
public class Room {
    private int ro_id;
    private String roomType;
    private String roomDescription;
    private int roomNumber;
    private int roomPrice;
    private String image;

    public Room() {
    }

    public Room(int ro_id, String roomType, String roomDescription, int roomNumber, int roomPrice, String image) {
        this.ro_id = ro_id;
        this.roomType = roomType;
        this.roomDescription = roomDescription;
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
        this.image = image;
    }

    public int getRo_id() {
        return ro_id;
    }

    public void setRo_id(int ro_id) {
        this.ro_id = ro_id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Room{" + "ro_id=" + ro_id + ", roomType=" + roomType + ", roomDescription=" + roomDescription + ", roomNumber=" + roomNumber + ", roomPrice=" + roomPrice + ", image=" + image + '}';
    }

    

   
    
}
