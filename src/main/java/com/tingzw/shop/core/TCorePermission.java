package com.tingzw.shop.core;

/**
 * 系统权限信息
 *
 * @author tingzw
 * @date 2017-06-16 10:01
 **/
public class TCorePermission extends TCoreBaseEntity {

    private Long id;//主键
    private Long menuid;//菜单ID
    private String name; // 权限名称
    private String code; // 权限标识
    private String remark;//备注

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMenuid() {
        return menuid;
    }

    public void setMenuid(Long menuid) {
        this.menuid = menuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

