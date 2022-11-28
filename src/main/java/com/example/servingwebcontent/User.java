package com.example.servingwebcontent;
 
public class User {
     
    private int id;
    private String userId;
    private String password;
    private String name;

    private String auth;
 
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAuth() {return auth; }

    public void setAuth(String auth) { this.auth = auth; }
}