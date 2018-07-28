package com.sapling.shop.biz.common.mybatis.model;

public class SysSessionToken {
    private Long id;

    private String key;

    private String content;

    private Long lstActiveTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Long getLstActiveTime() {
        return lstActiveTime;
    }

    public void setLstActiveTime(Long lstActiveTime) {
        this.lstActiveTime = lstActiveTime;
    }
}