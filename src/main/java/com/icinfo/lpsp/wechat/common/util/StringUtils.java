package com.icinfo.lpsp.wechat.common.util;

import org.apache.commons.lang3.StringEscapeUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 *
 * Created by wangxiao on 2016/9/18.
 */
public class StringUtils extends com.icinfo.framework.tools.utils.StringUtils {

    /**
     * 数组转成字符串
     *
     * @param arrObject  数组对象
     * @param separator  分隔符
     * @return
     */
    public static String arrayToString(Object[] arrObject, String separator) {
        // 默认为","号
        if (separator == null || separator.equals(""))
            separator = ",";

        String returnStrValue = "";

        if (arrObject != null) {
            for (Object object : arrObject) {
                if (returnStrValue.equals("")) {
                    returnStrValue = String.valueOf(object);
                } else {
                    returnStrValue = returnStrValue + separator
                            + String.valueOf(object);
                }
            }
        }
        return returnStrValue;
    }

    /**
     * 换行符删除处理
     * @param s 原文
     * @return 处理结果
     */
    public static String escapeLineFlag(String s) {
        int i = 0;
        while ((i = s.indexOf("\r")) != -1) {
            s = s.substring(0, i) + s.substring(i + 1);
        }
        while ((i = s.indexOf("\n")) != -1) {
            s = s.substring(0, i) + s.substring(i + 1);
        }
        return s;
    }

    /**
     * 描述: 替换所有空格（包含换行）
     *
     * @param str
     * @return
     * @auther 胡义振
     * @date 2014-9-23
     */
    public static String replaceAllBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s|\u3000|\t|\r\n|\r|\n|\n\r");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    /**
     * 将转义的 html 实体转为字符串.
     *
     * @param str
     * @return
     */
    public static String unescapeHtml(String str) {
        return StringEscapeUtils.unescapeHtml4(str);
    }
}
