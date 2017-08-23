/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.lpsp.wechat.common.remote.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 描述: 消息表 MMS_MESSAGE 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年05月19日
 */
@Table(name = "MMS_MESSAGE")
public class Message implements Serializable {
    /**
     * 唯一标识
     */
    @Id
    @Column(name = "ID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String id;

    /**
     * 标题
     */
    @Column(name = "MM_TITLE")
    private String title;

    /**
     * 摘要
     */
    @Column(name = "MM_SUMMARY")
    private String summary;

    /**
     * 推送方
     */
    @Column(name = "MM_PUSHER")
    private String pusher;

    /**
     * 接收方
     */
    @Column(name = "MM_RECEIVER")
    private String receiver;

    /**
     * 接收方名单
     */
    @Column(name = "MM_RECEIVE_NAME")
    private String receiveName;

    /**
     * 消息格式类型（1:文本消息；2:图文消息；3:网页消息）
     */
    @Column(name = "MM_FORMAT_TYPE")
    private String formatType;

    /**
     * 是否已删除（1:已发送  2:已删除）
     */
    @Column(name = "MM_STATUS")
    private String status;

    /**
     * 原文地址
     */
    @Column(name = "MM_SOURCE_URL")
    private String sourceUrl;

    /**
     * 消息地址
     */
    @Column(name = "MM_MESSAGE_URL")
    private String messageUrl;

    /**
     * 图片地址
     */
    @Column(name = "MM_IMAGE_URL")
    private String imageUrl;

    /**
     * 推送时间
     */
    @Column(name = "MM_PUSH_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date pushTime;

    /**
     * 推送渠道(1:客户端  2:微信  3:APP)
     */
    @Column(name = "MM_PUSH_CHANNEL")
    private String pushChannel;

    /**
     * 推送方式（0：手动发送；1：自动发送）
     */
    @Column(name = "MM_PUSH_MODE")
    private String pushMode;

    /**
     * 消息类型（ 1:系统消息  2:活动消息  3:工商政务通知）
     */
    @Column(name = "MM_TYPE")
    private String type;

    /**
     * 消息子类型
     */
    @Column(name = "MM_SUB_TYPE")
    private String subType;

    /**
     * 调用方标识
     */
    @Column(name = "MM_CUST_ID")
    private String custId;

    /**
     * 内容
     */
    @Column(name = "MM_CONTENT")
    private String content;

    /**
     * 附加内容
     */
    @Column(name = "MM_ADDITION")
    private String addition;

    /**
     * 是否广播消息
     */
    @Column(name = "MM_IS_BROADCAST")
    private String isBroadcast;

    /**
     * 关联企业个数
     */
    @Column(name = "MM_ENT_COUNT")
    private Integer entCount;

    private static final long serialVersionUID = 1L;

    /**
     * 获取唯一标识
     *
     * @return ID - 唯一标识
     */
    public String getId() {
        return id;
    }

    /**
     * 设置唯一标识
     *
     * @param id 唯一标识
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取标题
     *
     * @return MM_TITLE - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取摘要
     *
     * @return MM_SUMMARY - 摘要
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 设置摘要
     *
     * @param summary 摘要
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * 获取推送方
     *
     * @return MM_PUSHER - 推送方
     */
    public String getPusher() {
        return pusher;
    }

    /**
     * 设置推送方
     *
     * @param pusher 推送方
     */
    public void setPusher(String pusher) {
        this.pusher = pusher;
    }

    /**
     * 获取接收方
     *
     * @return MM_RECEIVER - 接收方
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * 设置接收方
     *
     * @param receiver 接收方
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * 获取接收方名单
     *
     * @return MM_RECEIVE_NAME - 接收方名单
     */
    public String getReceiveName() {
        return receiveName;
    }

    /**
     * 设置接收方名单
     *
     * @param receiveName 接收方名单
     */
    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    /**
     * 获取消息格式类型（1:文本消息；2:图文消息；3:网页消息）
     *
     * @return MM_FORMAT_TYPE - 消息格式类型（1:文本消息；2:图文消息；3:网页消息）
     */
    public String getFormatType() {
        return formatType;
    }

    /**
     * 设置消息格式类型（1:文本消息；2:图文消息；3:网页消息）
     *
     * @param formatType 消息格式类型（1:文本消息；2:图文消息；3:网页消息）
     */
    public void setFormatType(String formatType) {
        this.formatType = formatType;
    }

    /**
     * 获取是否已删除（1:已发送  2:已删除）
     *
     * @return MM_STATUS - 是否已删除（1:已发送  2:已删除）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置是否已删除（1:已发送  2:已删除）
     *
     * @param status 是否已删除（1:已发送  2:已删除）
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取原文地址
     *
     * @return MM_SOURCE_URL - 原文地址
     */
    public String getSourceUrl() {
        return sourceUrl;
    }

    /**
     * 设置原文地址
     *
     * @param sourceUrl 原文地址
     */
    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    /**
     * 获取消息地址
     *
     * @return MM_MESSAGE_URL - 消息地址
     */
    public String getMessageUrl() {
        return messageUrl;
    }

    /**
     * 设置消息地址
     *
     * @param messageUrl 消息地址
     */
    public void setMessageUrl(String messageUrl) {
        this.messageUrl = messageUrl;
    }

    /**
     * 获取图片地址
     *
     * @return MM_IMAGE_URL - 图片地址
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 设置图片地址
     *
     * @param imageUrl 图片地址
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * 获取推送时间
     *
     * @return MM_PUSH_TIME - 推送时间
     */
    public Date getPushTime() {
        return pushTime;
    }

    /**
     * 设置推送时间
     *
     * @param pushTime 推送时间
     */
    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    /**
     * 获取推送渠道(1:客户端  2:微信  3:APP)
     *
     * @return MM_PUSH_CHANNEL - 推送渠道(1:客户端  2:微信  3:APP)
     */
    public String getPushChannel() {
        return pushChannel;
    }

    /**
     * 设置推送渠道(1:客户端  2:微信  3:APP)
     *
     * @param pushChannel 推送渠道(1:客户端  2:微信  3:APP)
     */
    public void setPushChannel(String pushChannel) {
        this.pushChannel = pushChannel;
    }

    /**
     * 获取推送方式（0：手动发送；1：自动发送）
     *
     * @return MM_PUSH_MODE - 推送方式（0：手动发送；1：自动发送）
     */
    public String getPushMode() {
        return pushMode;
    }

    /**
     * 设置推送方式（0：手动发送；1：自动发送）
     *
     * @param pushMode 推送方式（0：手动发送；1：自动发送）
     */
    public void setPushMode(String pushMode) {
        this.pushMode = pushMode;
    }

    /**
     * 获取消息类型（ 1:系统消息  2:活动消息  3:工商政务通知）
     *
     * @return MM_TYPE - 消息类型（ 1:系统消息  2:活动消息  3:工商政务通知）
     */
    public String getType() {
        return type;
    }

    /**
     * 设置消息类型（ 1:系统消息  2:活动消息  3:工商政务通知）
     *
     * @param type 消息类型（ 1:系统消息  2:活动消息  3:工商政务通知）
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取消息子类型
     *
     * @return MM_SUB_TYPE - 消息子类型
     */
    public String getSubType() {
        return subType;
    }

    /**
     * 设置消息子类型
     *
     * @param subType 消息子类型
     */
    public void setSubType(String subType) {
        this.subType = subType;
    }

    /**
     * 获取调用方标识
     *
     * @return MM_CUST_ID - 调用方标识
     */
    public String getCustId() {
        return custId;
    }

    /**
     * 设置调用方标识
     *
     * @param custId 调用方标识
     */
    public void setCustId(String custId) {
        this.custId = custId;
    }

    /**
     * 获取内容
     *
     * @return MM_CONTENT - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取附加内容
     *
     * @return MM_ADDITION - 附加内容
     */
    public String getAddition() {
        return addition;
    }

    /**
     * 设置附加内容
     *
     * @param addition 附加内容
     */
    public void setAddition(String addition) {
        this.addition = addition;
    }

    public Integer getEntCount() {
        return entCount;
    }

    public void setEntCount(Integer entCount) {
        this.entCount = entCount;
    }

    public String getIsBroadcast() {
        return isBroadcast;
    }

    public void setIsBroadcast(String isBroadcast) {
        this.isBroadcast = isBroadcast;
    }
}