package com.example.thymeleaftour.mycontroller;


import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

    private Long userId;
    private String userName;

    // getters and setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


}
