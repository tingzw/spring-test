package com.tingzw.shop.core;

import java.util.Date;

/**
 * 系统管理用户信息
 *
 * @author tingzw
 * @date 2017-06-16 10:01
 **/
public class TCoreUser {
    private Long id;//主键
    private String username;//登录名[100]
    private String password;//密码[64]
    private String email;//电子邮箱[100]
    private String salt;//密码加盐[32]
    private int status;//状态(1:正常 2:禁用)
    private int type;//用户类型(1:超级管理员 2:普通管理员)
    private String registerip;//注册IP[64]
    private Date last_login_time;//最后登录时间
    private String last_login_ip;//最后登录IP[64]
    private Date credate;//创建时间
    private Date editdate;//修改时间
    private int logincount;//登录次数


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getRegisterip() {
        return registerip;
    }

    public void setRegisterip(String registerip) {
        this.registerip = registerip;
    }

    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }

    public String getLast_login_ip() {
        return last_login_ip;
    }

    public void setLast_login_ip(String last_login_ip) {
        this.last_login_ip = last_login_ip;
    }

    public Date getCredate() {
        return credate;
    }

    public void setCredate(Date credate) {
        this.credate = credate;
    }

    public Date getEditdate() {
        return editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
    }

    public int getLogincount() {
        return logincount;
    }

    public void setLogincount(int logincount) {
        this.logincount = logincount;
    }
}

