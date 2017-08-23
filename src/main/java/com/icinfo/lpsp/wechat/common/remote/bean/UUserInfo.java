package com.icinfo.lpsp.wechat.common.remote.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * 联连用户信息
 */
public class UUserInfo {
    //证书类型
    private String certType;
    //城市编码
    private String city;
    //微信唯一标识
    private String openId;
    //企业名称
    private String companyName;
    //联系地址
    private String contractAddress;
    //手机号
    private String phoneNum;
    //密码
    private String password;
    //密码长度
    private String pwdStrength;
    //省份编码
    private String province;
    //标识
    private String identity;
    //找回密码手机号
    private String pwdRecoverPhoneNum;
    //找回密码邮件地址
    private String pwdRecoverEmail;
    //验证码
    private String pushCheckCode;
    //用户唯一标识
    private String userUniqueId;
    //唯一标识
    private String id;
    //身份证号
    private String certNum;
    //部门
    private String department;
    //创建时间
    @JsonIgnore
    private Date createDate;
    //性别
    private String sex;
    //编号
    private String recommendNo;
    //绑定时间
    @JsonIgnore
    private String bindDate;
    //手机号
    private String mobilePhoneNum;
    //企业地址
    private String companyAddress;
    //地区编码
    private String district;
    //名字
    private String name;
    //状态
    private String status;
    //登录名
    private String username;

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPwdStrength() {
        return pwdStrength;
    }

    public void setPwdStrength(String pwdStrength) {
        this.pwdStrength = pwdStrength;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPwdRecoverPhoneNum() {
        return pwdRecoverPhoneNum;
    }

    public void setPwdRecoverPhoneNum(String pwdRecoverPhoneNum) {
        this.pwdRecoverPhoneNum = pwdRecoverPhoneNum;
    }

    public String getPwdRecoverEmail() {
        return pwdRecoverEmail;
    }

    public void setPwdRecoverEmail(String pwdRecoverEmail) {
        this.pwdRecoverEmail = pwdRecoverEmail;
    }

    public String getPushCheckCode() {
        return pushCheckCode;
    }

    public void setPushCheckCode(String pushCheckCode) {
        this.pushCheckCode = pushCheckCode;
    }

    public String getUserUniqueId() {
        return userUniqueId;
    }

    public void setUserUniqueId(String userUniqueId) {
        this.userUniqueId = userUniqueId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCertNum() {
        return certNum;
    }

    public void setCertNum(String certNum) {
        this.certNum = certNum;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRecommendNo() {
        return recommendNo;
    }

    public void setRecommendNo(String recommendNo) {
        this.recommendNo = recommendNo;
    }

    public String getBindDate() {
        return bindDate;
    }

    public void setBindDate(String bindDate) {
        this.bindDate = bindDate;
    }

    public String getMobilePhoneNum() {
        return mobilePhoneNum;
    }

    public void setMobilePhoneNum(String mobilePhoneNum) {
        this.mobilePhoneNum = mobilePhoneNum;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
