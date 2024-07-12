package com.example.registrationlogin;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;

    User(int id, String username, String email, String password )
    {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password=password;
    }
    //getters
    public int getId()
    {
        return this.id;
    }
    public String getUsername()
    {
        return this.username;
    }
    public String getEmail()
    {
        return this.email;
    }
    public String getPassword()
    {
        return  this.password;
    }

    //setters
    public void setId(int id) {this.id = id;}
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }




}