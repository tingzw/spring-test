package com.tingzw.shop.core;

/**
 * 系统权限与角色关联信息
 *
 * @author tingzw
 * @date 2017-06-16 11:20
 **/
public class TRolePermission {
    private Long id;//主键
    private Long roleid; // 角色ID
    private Long permissionid;// 权限ID

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

    public Long getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Long permissionid) {
        this.permissionid = permissionid;
    }
}
