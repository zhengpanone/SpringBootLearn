package com.zp.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private int uid;
    private String userName;
    private String passWord;
    private int salary;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public User(int uid, String userName, String passWord, int salary) {
        this.uid = uid;
        this.userName = userName;
        this.passWord = passWord;
        this.salary = salary;
    }

    public User() {
        super();
    }
}
