package com.icinfo.lpsp.wechat.manage.dto;

import java.util.List;

/**
 * Created by Administrator on 2017/4/27.
 */
public class MaterialPageDto {


    /**
     * 描述：素材列表
     */
    private List<MaterialDto> materialDtoList;

    /**
     * 描述：总数
     */
    private String total_count;
    /**
     * 描述：本次获取数量
     */
    private String item_count;

    public List<MaterialDto> getMaterialDtoList() {
        return materialDtoList;
    }

    public void setMaterialDtoList(List<MaterialDto> materialDtoList) {
        this.materialDtoList = materialDtoList;
    }

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }

    public String getItem_count() {
        return item_count;
    }

    public void setItem_count(String item_count) {
        this.item_count = item_count;
    }
}
