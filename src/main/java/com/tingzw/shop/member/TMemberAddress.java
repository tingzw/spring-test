package com.tingzw.shop.member;

import com.tingzw.shop.core.TCoreBaseEntity;

/**
 * 会员收货地址
 *
 * @author tingzw
 * @date 2017-06-16 17:22
 **/
public class TMemberAddress extends TCoreBaseEntity {
    private Long id;//主键
    private Long memberId;// 会员
    private String username;//姓名
    private Integer gender;// 性别
    private String address;// 详细地址
    private String postcode;// 邮编
    private String tel;//收货人手机
    private String areacode;// 电话区号
    private String phone;// 电话部分
    private String extnumber;//分机号
    private Integer is_default;// 是否是默认地址
    private String province;//省份名称
    private String city;// 城市名称
    private String country;//县级名称

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getExtnumber() {
        return extnumber;
    }

    public void setExtnumber(String extnumber) {
        this.extnumber = extnumber;
    }

    public Integer getIs_default() {
        return is_default;
    }

    public void setIs_default(Integer is_default) {
        this.is_default = is_default;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
