package com.tingzw.shop.express;

import com.tingzw.shop.core.TCoreBaseEntity;

/**
 * 物流公司
 *
 * @author tingzw
 * @date 2017-06-16 17:53
 **/
public class TExpressCompany extends TCoreBaseEntity {
    private Long id;//主键
    private String name;//名称
    private String webUrl;//网址
    private String logoPath;// LOGO
    private String priority;// 排序

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

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
