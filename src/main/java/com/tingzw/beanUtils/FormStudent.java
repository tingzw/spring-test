package com.tingzw.beanUtils;

import java.util.Date;

/**
 * @author tingzw
 * @date 2017-03-03 15:35
 **/
public class FormStudent {
    private Integer id;
    private String name;
    private Date credate;
    private String menus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCredate() {
        return credate;
    }

    public void setCredate(Date credate) {
        this.credate = credate;
    }

    public String getMenus() {
        return menus;
    }

    public void setMenus(String menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "FormStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credate=" + credate +
                ", menus='" + menus + '\'' +
                '}';
    }
}
