package com.apple.developer.entity;

import java.io.Serializable;

@SuppressWarnings("all")
public class Menu implements Serializable {
    private int menu_id;
    private String menu_name;
    private String href_url;
    private int parent_id;
    private String menu_create_time;

    private Menu parent;

    /**
     * 构造方法
     * <p>
     * 存入写死，客户端不可以自行增加菜单（功能）
     * 取出时只需取出menu_name、href_url
     */

    public Menu() {
    }

    public Menu(int menu_id, String menu_name) {
        this.menu_id = menu_id;
        this.menu_name = menu_name;
    }

    public Menu(String menu_name, String href_url) {
        this.menu_name = menu_name;
        this.href_url = href_url;
    }


    //    public Menu(int menu_id, String menu_name) {
//        this.menu_id = menu_id;
//        this.menu_name = menu_name;
//    }
//
//    public Menu(String menu_name, String href_url, int parent_id) {
//        this.menu_name = menu_name;
//        this.href_url = href_url;
//        this.parent_id = parent_id;
//    }
//
//    public Menu(int menu_id, String menu_name, String href_url, String menu_create_time, Menu parent) {
//        this.menu_id = menu_id;
//        this.menu_name = menu_name;
//        this.href_url = href_url;
//        this.menu_create_time = menu_create_time;
//        this.parent = parent;
//    }


    /**
     * getter&setter方法
     *
     * @return
     */
    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getHref_url() {
        return href_url;
    }

    public void setHref_url(String href_url) {
        this.href_url = href_url;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getMenu_create_time() {
        return menu_create_time;
    }

    public void setMenu_create_time(String menu_create_time) {
        this.menu_create_time = menu_create_time;
    }

    public Menu getMenu() {
        return parent;
    }

    public void setMenu(Menu parent) {
        this.parent = parent;
    }

    /**
     * override toString()方法
     */
    @Override
    public String toString() {
        return "Menu{" +
                "menu_id=" + menu_id +
                ", menu_name='" + menu_name + '\'' +
                ", href_url='" + href_url + '\'' +
                ", parent_id=" + parent_id +
                ", menu_create_time='" + menu_create_time + '\'' +
                ", parent=" + parent +
                '}';
    }
}
