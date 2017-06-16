package com.tingzw.shop.product;

/**
 * 商品品牌扩展信息
 *
 * @author tingzw
 * @date 2017-06-16 14:31
 **/
public class TProductBrandExt {

    private Long brandid;//主键
    private String description;//详细信息

    public Long getBrandid() {
        return brandid;
    }

    public void setBrandid(Long brandid) {
        this.brandid = brandid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
