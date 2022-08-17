package com.example.fooddelivery.db.user;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {

    @PrimaryKey(autoGenerate = true)
    int id;

    String userName;

    String userRole;



    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] image;

    public User(
            String userName,
            String userRole,
            byte[] imageByte
    ) {

        this.userName = userName;
        this.userRole = userRole;
        this.image = imageByte;
    }

    public User() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}

