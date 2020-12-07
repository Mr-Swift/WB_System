package com.apple.developer.entity;

import java.io.Serializable;

/**
 * 如何取出使用---待定
 */

@SuppressWarnings("all")
public class Config implements Serializable {
    private int con_id;
    private String con_type;
    private String con_key;
    private String con_page;
    private String con_create_time;

    /**
     * 构造方法
     * <p>
     * 存入时只需要con_type、con_key、con_page
     * <p>
     * 取出时需要con_id、con_type、con_key、con_page、con_create_time
     */

    public Config() {
    }

    public Config(String con_type, String con_key, String con_page) {
        this.con_type = con_type;
        this.con_key = con_key;
        this.con_page = con_page;
    }

    public Config(String con_type, String con_key, String con_page, String con_create_time) {
        this.con_type = con_type;
        this.con_key = con_key;
        this.con_page = con_page;
        this.con_create_time = con_create_time;
    }

    /**
     * getter&setter方法
     *
     * @return
     */

    public int getcon_id() {
        return con_id;
    }

    public void setcon_id(int con_id) {
        this.con_id = con_id;
    }

    public String getcon_type() {
        return con_type;
    }

    public void setcon_type(String con_type) {
        this.con_type = con_type;
    }

    public String getcon_key() {
        return con_key;
    }

    public void setcon_key(String con_key) {
        this.con_key = con_key;
    }

    public String getcon_page() {
        return con_page;
    }

    public void setcon_page(String con_page) {
        this.con_page = con_page;
    }

    public String getcon_create_time() {
        return con_create_time;
    }

    public void setcon_create_time(String con_create_time) {
        this.con_create_time = con_create_time;
    }

    /**
     * override toString()方法
     */

    @Override
    public String toString() {
        return "Config{" +
                "con_id=" + con_id +
                ", con_type='" + con_type + '\'' +
                ", con_key='" + con_key + '\'' +
                ", con_page='" + con_page + '\'' +
                ", con_create_time='" + con_create_time + '\'' +
                '}';
    }
}
