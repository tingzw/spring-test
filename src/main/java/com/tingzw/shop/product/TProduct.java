package com.tingzw.shop.product;

import com.tingzw.shop.core.TCoreBaseEntity;

import java.util.Date;

/**
 * 商品信息
 *
 * @author tingzw
 * @date 2017-06-16 14:31
 **/
public class TProduct extends TCoreBaseEntity {
    private Long id;//主键
    private String name;//商品名称
    private Double marketPrice;//市场价
    private Double salePrice;//销售价
    private Double costPrice;//成本价
    private Long viewCount;//浏览次数
    private Long favoriteCount;//收藏次数
    private Integer saleCount;//销售量
    private Integer stockCount;//库存
    private Integer alertInventory;//警戒库存
    private Date expireTime;//到期时间
    private Integer status;//状态(1:初始状态 2:上线 3:审核失败 4:下线)
    private Double weight;//重量(kg)
    private Integer is_delivery_fee;//免运费 0收运费 1免运费

    private Long categoryId;//分类ID
    private String categoryName;//分类名称

    private Long brandId;//品牌ID
    private String brandName;//品牌名称


}
