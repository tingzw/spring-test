package com.tingzw.shop.product;

import com.tingzw.shop.core.TCoreBaseEntity;

/**
 * 商品品牌
 *
 * @author tingzw
 * @date 2017-06-16 14:31
 **/
public class TProductBrand extends TCoreBaseEntity {
    private Long id;//主键
    private String name;//名称
    private String alias;//别名
    private String logopath;//LOGO
    private Integer priority;//排序
    private Integer status;//状态(1:有效 2:无效)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getLogopath() {
        return logopath;
    }

    public void setLogopath(String logopath) {
        this.logopath = logopath;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
