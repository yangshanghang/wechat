package com.icinfo.lpsp.wechat.base.resolver;

import com.icinfo.lpsp.wechat.common.constant.BizConstant;
import com.icinfo.lpsp.wechat.base.material.MaterialUtils;
import com.icinfo.lpsp.wechat.base.message.MessageUtils;
import com.icinfo.lpsp.wechat.wxsdk.base.BaseMessage;
import com.icinfo.lpsp.wechat.wxsdk.common.utils.XMLUtils;
import com.icinfo.lpsp.wechat.wxsdk.material.bean.NewsMaterials;
import com.icinfo.lpsp.wechat.wxsdk.message.bean.*;
import com.icinfo.lpsp.wechat.wxsdk.message.resolver.TextMessageResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;

/**
 * 文本消息解析器
 * Created by yushunwei on 2016/8/14.
 */
public class LpspTextMessageResolver extends TextMessageResolver {

    private static Logger logger = LoggerFactory.getLogger(LpspTextMessageResolver.class);

    /**
     * 文本消息处理，回复文本消息
     *
     * @param message 需要处理的原始消息
     * @return 回复的文本消息
     * @throws Exception
     */
    @Override
    public String resolve(HashMap<String, Object> message) throws Exception {
        // 获取消息文本内容
        String content = this.getContent(message);

        // 输入“法人证书”，回复法人数字证书图文消息，
        if (BizConstant.FRZS_TEXT_RECEIVE.equals(content)) {
            // 1.获取法人证书图文素材
            NewsMaterials newsMaterials = MaterialUtils.getNewsMaterialsByMediaId(BizConstant.FRZS_MEDIA_ID);
            if (newsMaterials == null) {
                return createTextMessage(message, BizConstant.RESOLVE_FAIL_MSG);
            }

            // 2.转换图文素材为图文消息
            NewsMessage frzsNewsMessage = MessageUtils.generateNewsMessageByNewsMaterials(newsMaterials);
            setBaseMessage(frzsNewsMessage, message);
            return XMLUtils.parseXml(frzsNewsMessage);
        } else if (BizConstant.XZZS_TEXT_RECEIVE.equals(content)) {
            //输入“下载证书”，回复下载证书图文消息
            //1.获取下载证书图文素材
            NewsMaterials newsMaterials = MaterialUtils.getNewsMaterialsByMediaId(BizConstant.XZZS_MEDIA_ID);
            if (newsMaterials == null) {
                return createTextMessage(message, BizConstant.RESOLVE_FAIL_MSG);
            }
            // 2.转换图文素材为图文消息
            NewsMessage xzzsNewsMessage = MessageUtils.generateNewsMessageByNewsMaterials(newsMaterials);
            setBaseMessage(xzzsNewsMessage, message);
            return XMLUtils.parseXml(xzzsNewsMessage);
        }

        // 其他类型文本消息转发客服
        return createTransferCustomerServiceMessage(message);
    }

    /**
     * 产生转发客服消息
     *
     * @return 转发客服消息内容
     * @throws Exception
     */
    private String createTransferCustomerServiceMessage(HashMap<String, Object> message) throws Exception {
        BaseMessage respMessage = createBaseMessage(message);
        respMessage.setMsgType(TRANSFER_CUSTOMER_SERVICE);
        return XMLUtils.parseXml(respMessage);
    }

    /**
     * 回复图片消息格式测试
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            ImageMessage imageMessage = new ImageMessage();
            imageMessage.setToUserName("FromUserName".toString());
            imageMessage.setFromUserName("ToUserName".toString());
            imageMessage.setCreateTime(new Date().getTime());
            imageMessage.setMsgType(MESSAGE_IMAGE);
            Image image = new Image();
            image.setMediaId(BizConstant.FRZS_MEDIA_ID);
            imageMessage.setImage(image);
            System.out.println(XMLUtils.parseXml(imageMessage));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 回复图文消息格式测试
     * @param args
     */
//    public static void main(String[] args) {
//        try {
//            // 3.组装图文回复消息
//            NewsMessage newsMessage = new NewsMessage();
//            newsMessage.setToUserName("FromUserName".toString());
//            newsMessage.setFromUserName("ToUserName".toString());
//            newsMessage.setCreateTime(new Date().getTime());
//            newsMessage.setMsgType(MESSAGE_NEWS);
//            newsMessage.setArticleCount(1);
//
//            List<Item> articles = new ArrayList<>();
//            Item item = new Item();
//            item.setTitle("图说“浙江省法人数字证书”");
//            item.setDescription("浙江省法人数字证书，身份认证、数据加密、电子签章，一证在手，办事随心");
//            item.setUrl("http://mp.weixin.qq.com/s?__biz=MzA5Nzk4MDE1MA==&mid=100000124&idx=1&sn=e96089c7e1351f86413e5e4bc325adc1&chksm=1099dae527ee53f320647f33c7f1b5ff164433a86466fbc13f1df24a230fc67ba07d5abfaa54#rd");
//            item.setPicUrl("http://mmbiz.qpic.cn/mmbiz_jpg/yIR3hhzckjtQlCy8KTvBgpLmn4EgZXV2Eb81gw10QW2SAR65siazsgR7xXZtCiaIT31FcsWs8yrqROzvby55mibYw/0?wx_fmt=jpeg");
//            articles.add(item);
//            // 4.生成法人证书图文消息项
//            newsMessage.setArticles(articles);
//            System.out.println(XMLUtils.parseXml(newsMessage));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}