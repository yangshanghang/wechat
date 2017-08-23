package com.icinfo.lpsp.wechat.base.material;

import com.icinfo.lpsp.wechat.common.constant.ConfigConstant;
import com.icinfo.lpsp.wechat.wxsdk.material.MaterialManager;
import com.icinfo.lpsp.wechat.wxsdk.material.bean.NewsMaterials;
import com.icinfo.lpsp.wechat.wxsdk.token.TokenManager;
import com.icinfo.lpsp.wechat.wxsdk.token.bean.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 素材工具类
 * Created by yushunwei on 2017-04-12.
 */
public class MaterialUtils {

    private static Logger logger = LoggerFactory.getLogger(MaterialUtils.class);

    /**
     * 根据素材ID获取图文素材
     *
     * @param mediaId 素材ID
     * @return 图文素材
     * @throws Exception 异常信息
     */
    public static NewsMaterials getNewsMaterialsByMediaId(String mediaId) throws Exception {
        // 1.获取Token
        Token token = TokenManager.getToken(ConfigConstant.APP_ID_LIANLIAN, ConfigConstant.APP_SECRET_LIANLIAN);

        if (!token.isSuccess()) {
            logger.error("获取AccessToken失败：{}", token.getErrcode() + ":" + token.getErrmsg());
            return null;
        }

        NewsMaterials newsMaterials = MaterialManager.getForeverNewsMaterial(mediaId, token.getAccess_token());

        // 2.获取失败，直接返回文本错误提示信息
        if (newsMaterials == null) {
            logger.error("获取素材为空或者失败！");
            return null;
        }

        // 3.获取素材结果判断
        if (!newsMaterials.isSuccess()) {
            logger.error("获取素材失败：{}", newsMaterials.getErrcode() + ":" + newsMaterials.getErrmsg());
            return null;
        }

        return newsMaterials;
    }

    /**
     * 校验图文素材有效性
     * @param newsMaterials 素材
     * @param preSeconds 提前量，单位：秒
     * @return true：有效；false：无效
     */
    public static boolean checkNewsMaterials(NewsMaterials newsMaterials,int preSeconds) {
        return System.currentTimeMillis() <= (newsMaterials.getExpires_in() - preSeconds * 1000);
    }

    /**
     * 设置图文素材生效时间
     * @param newsMaterials 素材
     * @param validSeconds 有效时长，单位：秒
     */
    public static void setNewsMaterialsExpires(NewsMaterials newsMaterials,int validSeconds ){
        newsMaterials.setExpires_in(System.currentTimeMillis() + validSeconds * 1000);
    }
}
