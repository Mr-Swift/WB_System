package com.apple.developer.entity;

import java.io.Serializable;

@SuppressWarnings("all")
public class Role implements Serializable {
    private int role_id;
    private String role_name;
    private String role_create_time;


    /**
     * 构造方法
     * <p>
     * 存入时只需要role_name,role_id自增长 role_create_time用now()函数自动生成
     * <p>
     * 取出时需要role_id role_name role_create_time
     */
    public Role() {
    }

    public Role(String role_name) {
        this.role_name = role_name;
    }

    public Role(int role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }

    public Role(int role_id, String role_name, String role_create_time) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.role_create_time = role_create_time;
    }


    /**
     * getter&setter方法
     *
     * @return
     */
    public int getrole_id() {
        return role_id;
    }

    public void setrole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getrole_name() {
        return role_name;
    }

    public void setrole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getrole_create_time() {
        return role_create_time;
    }

    public void setrole_create_time(String role_create_time) {
        this.role_create_time = role_create_time;
    }

    /**
     * override toString()方法
     */
    @Override
    public String toString() {
        return "role{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", role_create_time='" + role_create_time + '\'' +
                '}';
    }
}
