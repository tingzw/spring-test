package com.tingzw.shop.product;

/**
 * 栏目品牌
 *
 * @author tingzw
 * @date 2017-06-16 15:06
 **/
public class TProductCategoryBrand {
    private Long brandId;//品牌ID
    private Long categoryId;//栏目ID

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
