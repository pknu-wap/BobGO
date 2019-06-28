package com.example.myapplication;

public class User {
    String userID;
    String userPassword;
    String userName;
    String userAge;
    String userUniversity;

    public User(String userID, String userPassword, String userName, String userAge, String userUniversity) {
        this.userID = userID;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userAge = userAge;
        this.userUniversity = userUniversity;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public String getUserUniversity() {
        return userUniversity;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public void setUserUniversity(String userUniversity) {
        this.userUniversity = userUniversity;
    }
}
