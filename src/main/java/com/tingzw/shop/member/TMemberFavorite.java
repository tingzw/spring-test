package com.tingzw.shop.member;

/**
 * 会员商品收藏夹
 *
 * @author tingzw
 * @date 2017-06-16 17:30
 **/
public class TMemberFavorite {

    private Long memberId;//会员编号
    private Long productId;//商品编号

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
