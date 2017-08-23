package com.icinfo.lpsp.wechat.manage.dto;

/**
 * 描述：素材DTO
 */
public class MaterialDto {

    /**
     * 描述：标题
     */
    private String title;

    /**
     * 描述：素材ID
     */
    private String media_id;

    /**
     * 描述：图文URL
     */
    private String url;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
