package com.icinfo.lpsp.wechat.manage.controller.wechat;

import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.lpsp.wechat.common.remote.api.MmsAPI;
import com.icinfo.lpsp.wechat.common.remote.response.MmsApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * 微信端消息控制器
 * Created by yushunwei on 2017-05-18.
 */
@Controller("wechatMessageController")
@RequestMapping("/wechat/message")
public class MessageController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    /**
     * 进入消息列表页面
     *
     * @param phone 手机号
     * @param model 模型
     * @return 消息列表页面
     * @throws Exception
     */
    @RequestMapping(value = "/page/{phone}", method = RequestMethod.GET)
    public String MessageList(@PathVariable("phone") String phone, Model model) throws Exception {
        try {
            // 1.获取消息列表数据
            MmsApiResponse mmsApiResponse = MmsAPI.getMessages(phone, 0, 10);
            // 2.设置消息信息
            model.addAttribute("messagesList", mmsApiResponse.getData().getList());
            // 3.设置是否有下一页
            model.addAttribute("hasNextPage", mmsApiResponse.getData().getHasNextPage());
        }catch (Exception e){
            logger.error("获取消息列表失败", e);
        }
        return "wechat/message/message";
    }

    /**
     * 获取消息列表
     *
     * @param phone    手机号
     * @param pageNum  分页页码
     * @param pageSize 分页大小
     * @return 消息列表
     * @throws Exception
     */
    @RequestMapping(value = "/getlist", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public AjaxResult getMessageList(@RequestParam(name = "phone", required = true) String phone,
                                     @RequestParam(name = "pageNum", required = true) int pageNum,
                                     @RequestParam(name = "pageSize", required = true) int pageSize) throws Exception {
        try {
            // 1.根据手机号分页获取消息列表
            MmsApiResponse mmsApiResponse = MmsAPI.getMessages(phone, pageNum, pageSize);
            // 2.判断请求是否获取成功，成功传递消息列表
            if (mmsApiResponse.isSuccess()) {
                return AjaxResult.success("操作成功", mmsApiResponse.getData());
            }
        }catch (Exception e){
            logger.error("获取消息列表失败", e);
        }

        // 3.请求失败返回错误信息
        return AjaxResult.error("操作失败");
    }
}
