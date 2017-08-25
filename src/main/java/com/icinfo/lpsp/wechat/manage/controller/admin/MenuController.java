package com.icinfo.lpsp.wechat.manage.controller.admin;

import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.lpsp.wechat.common.constant.ConfigConstant;
import com.icinfo.lpsp.wechat.wxsdk.base.BaseResult;
import com.icinfo.lpsp.wechat.wxsdk.menu.MenuManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述：菜单控制器
 */
@Controller("adminMenuController")
@RequestMapping("/admin/menu")
public class MenuController {
    /**
     * 描述: 跳转到菜单页
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String page() throws Exception {
        return "admin/manage/menu";
    }

    /**
     * 描述：获取菜单列表
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/readlist", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public AjaxResult readList() throws Exception {
        String menus = MenuManager.getMenus(ConfigConstant.APP_ID_LIANLIAN, ConfigConstant.APP_SECRET_LIANLIAN);
        if ("error".equals(menus)) {
            return AjaxResult.error("菜单列表获取失败！");
        } else {
            return AjaxResult.success("菜单列表获取成功！", menus);
        }
    }

    /**
     * 描述：保存菜单
     *
     * @param menus 菜单json串
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult add(@RequestParam(name = "menus", required = true) String menus) throws Exception {
        BaseResult result = MenuManager.initMenuByJson(menus, ConfigConstant.APP_ID_LIANLIAN, ConfigConstant.APP_SECRET_LIANLIAN);
        if (result.isSuccess()) {
            return AjaxResult.success("保存菜单成功!");
        } else {
            return AjaxResult.error("保存菜单失败：" + result.getErrcode() + "——" + result.getErrmsg());
        }
    }
}
