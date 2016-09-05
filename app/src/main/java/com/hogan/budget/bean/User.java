package com.hogan.budget.bean;

import java.util.Date;

/**
 * Created by Hogan on 9/5/2016.
 * 用户实体
 */
public class User {

    private String uid;
    private String username;
    private String password;
    private Date lastLoginDate;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
}
