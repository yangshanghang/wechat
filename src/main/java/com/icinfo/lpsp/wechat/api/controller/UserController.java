package com.icinfo.lpsp.wechat.api.controller;

import com.icinfo.lpsp.wechat.common.constant.ConfigConstant;
import com.icinfo.lpsp.wechat.common.remote.response.ApiResponse;
import com.icinfo.lpsp.wechat.common.util.StringUtils;
import com.icinfo.lpsp.wechat.wxsdk.user.UserManager;
import com.icinfo.lpsp.wechat.wxsdk.user.bean.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户API控制器
 */
@Controller("apiUserController")
@RequestMapping("/api/user/")
public class UserController {

    /**
     * 获取 获取用户列表
     *
     * @param next_openid 第一个拉取的OPENID
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ApiResponse get(@RequestParam(value = "next_openid", required = false) String next_openid) throws Exception {
        //1.获取用户列表
        Users usersApiResponse = UserManager.getUserList(ConfigConstant.APP_ID_LIANLIAN, ConfigConstant.APP_SECRET_LIANLIAN, next_openid);

        //2.如果获取成功,用户列表数据
        if (usersApiResponse.isSuccess()) {
            return new ApiResponse(usersApiResponse);
        }

        //3.返回错误消息
        return new ApiResponse(ApiResponse.FAIL_CODE, "用户列表获取失败！", StringUtils.assemblyString(usersApiResponse.getErrcode(), "：", usersApiResponse.getErrmsg()));
    }
}
