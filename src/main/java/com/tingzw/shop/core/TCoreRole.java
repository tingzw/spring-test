package com.tingzw.shop.core;

/**
 * 角色信息
 *
 * @author tingzw
 * @date 2017-06-16 10:31
 **/
public class TCoreRole extends TCoreBaseEntity {
    private Long id;//主键
    private String status;// 状态 PublicStatusEnum
    private String roleCode; // 角色编码：例如：admin
    private String roleName; // 角色名称
    private String remark;// 描述

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
