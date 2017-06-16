package com.tingzw.shop.product;

/**
 * 商品图片
 *
 * @author tingzw
 * @date 2017-06-16 15:20
 **/
public class TProductPicture {

    private Long productId;//产品ID
    private Integer priority;//排列顺序
    private String picturePath;//小图
    private String bigPicturePath;//大图

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getBigPicturePath() {
        return bigPicturePath;
    }

    public void setBigPicturePath(String bigPicturePath) {
        this.bigPicturePath = bigPicturePath;
    }
}
