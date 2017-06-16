package com.tingzw.shop.product;

import com.tingzw.shop.core.TCoreBaseEntity;

/**
 * 商品分类
 *
 * @author tingzw
 * @date 2017-06-16 14:57
 **/
public class TProductCategory extends TCoreBaseEntity {
    private Long id;//主键
    private String name;//名称
    private Integer priority;//顺序
    private String imagepath;//图片路径
    private String keywords;//关键字
    private String description;//描述
    private Long parentid;//父菜单ID

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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }
}
