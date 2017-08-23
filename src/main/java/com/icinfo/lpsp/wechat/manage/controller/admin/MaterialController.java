package com.icinfo.lpsp.wechat.manage.controller.admin;

import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.lpsp.wechat.common.constant.ConfigConstant;
import com.icinfo.lpsp.wechat.manage.dto.MaterialDto;
import com.icinfo.lpsp.wechat.manage.dto.MaterialPageDto;
import com.icinfo.lpsp.wechat.wxsdk.material.MaterialManager;
import com.icinfo.lpsp.wechat.wxsdk.material.bean.NewsItem;
import com.icinfo.lpsp.wechat.wxsdk.material.bean.NewsMaterialList;
import com.icinfo.lpsp.wechat.wxsdk.material.bean.OtherItem;
import com.icinfo.lpsp.wechat.wxsdk.material.bean.OtherMaterialList;
import com.icinfo.lpsp.wechat.wxsdk.material.enums.EMateriaType;
import com.icinfo.lpsp.wechat.wxsdk.token.TokenManager;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：素材控制器
 */
@Controller
@RequestMapping("/admin/material")
public class MaterialController {

    /**
     * 描述: 跳转到素材页
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String page() throws Exception {
        return "admin/manage/material";
    }


    /**
     * 描述：获取对应素材列表
     *
     * @param type   素材类型
     * @param offset 返回素材的偏移位置
     * @param count  返回素材的数量
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/readlist", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public AjaxResult readList(@RequestParam(name = "type", required = true) String type,
                               @RequestParam(name = "offset", required = true) String offset,
                               @RequestParam(name = "count", required = true) String count) throws Exception {
        //1.如果类型为news则是图文获取操作，否则为其他素材操作
        if (EMateriaType.MATERIAL_TYPE_NEWS.getValue().equals(type)) {
            //获取图文列表
            NewsMaterialList newsmateriallist = MaterialManager.getForeverNewsMaterialsList(TokenManager.getToken(ConfigConstant.APP_ID_LIANLIAN, ConfigConstant.APP_SECRET_LIANLIAN).getAccess_token(), type, offset, count);
            //2.如果错误码为空，则获取素材成功返回成功信息，否则返回失败信息
            if (StringUtils.isEmpty(newsmateriallist.getErrcode())) {
                return AjaxResult.success("图文获取成功", processNews(newsmateriallist));
            } else {
                return AjaxResult.error("图文获取失败", newsmateriallist.getErrcode());
            }
        } else {
            //获取其他素材列表
            OtherMaterialList othermateriallist = MaterialManager.getForeverOtherMaterialsList(TokenManager.getToken(ConfigConstant.APP_ID_LIANLIAN, ConfigConstant.APP_SECRET_LIANLIAN).getAccess_token(), type, offset, count);
            //2.如果错误码为空，则获取素材成功返回成功信息，否则返回失败信息
            if (StringUtils.isEmpty(othermateriallist.getErrcode())) {
                return AjaxResult.success("图片获取成功", processOthers(othermateriallist));
            } else {
                return AjaxResult.error("图片获取失败", othermateriallist.getErrcode());
            }
        }
    }


    /**
     * 描述：处理图文信息
     *
     * @return
     * @throws Exception
     */
    private MaterialPageDto processNews(NewsMaterialList news) throws Exception {
        MaterialPageDto materialPageDto = new MaterialPageDto();
        List<MaterialDto> list = new ArrayList<>();
        for (NewsItem newsItem : news.getItem()) {
            MaterialDto materialDto = new MaterialDto();
            materialDto.setMedia_id(newsItem.getMedia_id());
            materialDto.setUrl(newsItem.getContent().getNews_item().get(0).getUrl());
            materialDto.setTitle(newsItem.getContent().getNews_item().get(0).getTitle());
            list.add(materialDto);
        }
        materialPageDto.setMaterialDtoList(list);
        materialPageDto.setTotal_count(news.getTotal_count());
        materialPageDto.setItem_count(news.getItem_count());
        return materialPageDto;
    }

    /**
     * 描述：处理其他信息
     *
     * @return
     * @throws Exception
     */
    private MaterialPageDto processOthers(OtherMaterialList others) throws Exception {
        MaterialPageDto materialPageDto = new MaterialPageDto();
        List<MaterialDto> list = new ArrayList<>();
        for (OtherItem otherItem : others.getItem()) {
            MaterialDto materialDto = new MaterialDto();
            materialDto.setMedia_id(otherItem.getMedia_id());
            materialDto.setTitle(otherItem.getName());
            list.add(materialDto);
        }
        materialPageDto.setMaterialDtoList(list);
        materialPageDto.setTotal_count(others.getTotal_count());
        materialPageDto.setItem_count(others.getItem_count());
        return materialPageDto;
    }
}
