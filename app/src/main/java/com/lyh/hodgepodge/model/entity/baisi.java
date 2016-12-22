package com.lyh.hodgepodge.model.entity;

import java.util.List;

/**
 * Created by lyh on 2016/12/22.
 */

public class Baisi extends Base{
    public String text;//标题描述
    public String hate;//
    public String love;//点赞
    public String weixin_url;//
    public String type;//
    public String video_uri;//
    public String name;//
    public String create_time;//
    public String image0;//
    public String profile_image;//

    @Override
    public String toString() {
        return "Baisi{" +
                "text='" + text + '\'' +
                ", hate='" + hate + '\'' +
                ", love='" + love + '\'' +
                ", weixin_url='" + weixin_url + '\'' +
                ", type='" + type + '\'' +
                ", video_uri='" + video_uri + '\'' +
                ", name='" + name + '\'' +
                ", create_time='" + create_time + '\'' +
                ", image0='" + image0 + '\'' +
                ", profile_image='" + profile_image + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHate() {
        return hate;
    }

    public void setHate(String hate) {
        this.hate = hate;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public String getWeixin_url() {
        return weixin_url;
    }

    public void setWeixin_url(String weixin_url) {
        this.weixin_url = weixin_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVideo_uri() {
        return video_uri;
    }

    public void setVideo_uri(String video_uri) {
        this.video_uri = video_uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getImage0() {
        return image0;
    }

    public void setImage0(String image0) {
        this.image0 = image0;
    }
}
