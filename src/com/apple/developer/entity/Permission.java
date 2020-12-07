package com.apple.developer.entity;

import java.io.Serializable;

@SuppressWarnings("all")
public class Permission implements Serializable {
    private int per_id;
    private int role_id;
    private int menu_id;
    private String per_create_time;

    private Role role;
    private Menu menu;

    /**
     * 构造方法
     * <p>
     * 存入时，将得到的角色名称、菜单名称查找到对应的角色ID、菜单ID存进去
     * 存入时只需要role_id、menu_id，per_id自增长、per_create_time用now()函数自动生成
     * <p>
     * 取出时，将数据库里的角色ID、菜单ID多表联查，查到角色名称、菜单名称取出来
     * 取出时需要per_create_time,role、menu
     */
    public Permission() {
    }

    public Permission(int role_id, int menu_id) {
        this.role_id = role_id;
        this.menu_id = menu_id;
    }

    public Permission(String per_create_time, Role role, Menu menu) {
        this.per_create_time = per_create_time;
        this.role = role;
        this.menu = menu;
    }


    /**
     * getter&setter方法
     *
     * @return
     */

    public int getPer_id() {
        return per_id;
    }

    public void setPer_id(int per_id) {
        this.per_id = per_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getPer_create_time() {
        return per_create_time;
    }

    public void setPer_create_time(String per_create_time) {
        this.per_create_time = per_create_time;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    /**
     * override toString()方法
     */
    @Override
    public String toString() {
        return "Permission{" +
                "per_id=" + per_id +
                ", role_id=" + role_id +
                ", menu_id=" + menu_id +
                ", per_create_time='" + per_create_time + '\'' +
                ", role=" + role +
                ", menu=" + menu +
                '}';
    }
}
