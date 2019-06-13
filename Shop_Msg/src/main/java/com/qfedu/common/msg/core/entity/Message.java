package com.qfedu.common.msg.core.entity;

public class Message {
    private Long id;

    private Integer pcode;

    private Integer type;

    private String title;

    private String concent;

    private String receive;

    private Integer flag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPcode() {
        return pcode;
    }

    public void setPcode(Integer pcode) {
        this.pcode = pcode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getConcent() {
        return concent;
    }

    public void setConcent(String concent) {
        this.concent = concent == null ? null : concent.trim();
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive == null ? null : receive.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}