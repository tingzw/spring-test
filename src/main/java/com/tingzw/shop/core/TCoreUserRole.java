package com.tingzw.shop.core;

/**
 * 系统用户角色表
 *
 * @author tingzw
 * @date 2017-06-16 11:39
 **/
public class TCoreUserRole {

    private Long id;//主键
    private Long userid;// 用户ID
    private Long roleid;// 角色ID

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}
