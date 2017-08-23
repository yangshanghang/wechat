package com.icinfo.lpsp.wechat.base.message;

import com.icinfo.lpsp.wechat.wxsdk.material.bean.News;
import com.icinfo.lpsp.wechat.wxsdk.material.bean.NewsMaterials;
import com.icinfo.lpsp.wechat.wxsdk.message.bean.Item;
import com.icinfo.lpsp.wechat.wxsdk.message.bean.NewsMessage;
import com.icinfo.lpsp.wechat.wxsdk.message.resolver.BaseResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import java.util.List;

/**
 * 消息工具类
 * Created by yushunwei on 2017-04-12.
 */
public class MessageUtils {

    private static Logger logger = LoggerFactory.getLogger(MessageUtils.class);

    /**
     * 根据图文素材生成图文消息
     *
     * @param newsMaterials 图文素材
     * @return 图文消息
     * @throws Exception 异常
     */
    public static NewsMessage generateNewsMessageByNewsMaterials(NewsMaterials newsMaterials) throws Exception {
        // 1.组装图文回复消息
        NewsMessage newsMessage = new NewsMessage();
        newsMessage.setMsgType(BaseResolver.MESSAGE_NEWS);
        newsMessage.setArticleCount(newsMaterials.getNews_item().size());

        // 2.生成图文消息项
        List<Item> articles = new ArrayList<>();
        for (News news : newsMaterials.getNews_item()) {
            Item item = new Item();
            item.setTitle(news.getTitle());
            item.setDescription(news.getDigest());
            item.setUrl(news.getUrl());
            item.setPicUrl(news.getThumb_url());
            articles.add(item);
        }
        newsMessage.setArticles(articles);

        // 3.返回
        return newsMessage;
    }
}
