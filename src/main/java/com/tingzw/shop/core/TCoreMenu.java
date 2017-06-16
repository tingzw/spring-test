package com.tingzw.shop.core;

/**
 * @author tingzw
 * @date 2017-06-16 11:22
 **/
public class TCoreMenu extends TCoreBaseEntity {

    private String name;//菜单名称

    private String url;//菜单地址

    private String number;//菜单编号（用于显示时排序）

    private String isLeaf;//是否为叶子节点

    private Long level;//菜单层级

    private Integer status;//状态((1:启用 2:禁用))

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
