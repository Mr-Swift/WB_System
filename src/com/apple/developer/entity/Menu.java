package com.apple.developer.entity;

import java.io.Serializable;

@SuppressWarnings("all")
public class Menu implements Serializable {
    private int menuId;
    private String menuName;
    private String hrefUrl;
    private int parentId;
    private String menuCreateTime;

    private Menu parent;

    /**
     * 构造方法
     * <p>
     * 存入写死，客户端不可以自行增加菜单（功能）
     * 取出时只需取出menuName、hrefUrl
     * <p>
     * 增删改写死，无法从客户端进行操作。仅保留查询。
     */

    public Menu() {
    }

    public Menu(int menuId, String menuName) {
        this.menuId = menuId;
        this.menuName = menuName;
    }

    public Menu(String menuName, String hrefUrl) {
        this.menuName = menuName;
        this.hrefUrl = hrefUrl;
    }


    //    public Menu(int menuId, String menuName) {
//        this.menuId = menuId;
//        this.menuName = menuName;
//    }
//
//    public Menu(String menuName, String hrefUrl, int parentId) {
//        this.menuName = menuName;
//        this.hrefUrl = hrefUrl;
//        this.parentId = parentId;
//    }
//
//    public Menu(int menuId, String menuName, String hrefUrl, String menuCreateTime, Menu parent) {
//        this.menuId = menuId;
//        this.menuName = menuName;
//        this.hrefUrl = hrefUrl;
//        this.menuCreateTime = menuCreateTime;
//        this.parent = parent;
//    }


    /**
     * getter&setter方法
     *
     * @return
     */
    public int getmenuId() {
        return menuId;
    }

    public void setmenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getmenuName() {
        return menuName;
    }

    public void setmenuName(String menuName) {
        this.menuName = menuName;
    }

    public String gethrefUrl() {
        return hrefUrl;
    }

    public void sethrefUrl(String hrefUrl) {
        this.hrefUrl = hrefUrl;
    }

    public int getparentId() {
        return parentId;
    }

    public void setparentId(int parentId) {
        this.parentId = parentId;
    }

    public String getmenuCreateTime() {
        return menuCreateTime;
    }

    public void setmenuCreateTime(String menuCreateTime) {
        this.menuCreateTime = menuCreateTime;
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
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", hrefUrl='" + hrefUrl + '\'' +
                ", parentId=" + parentId +
                ", menuCreateTime='" + menuCreateTime + '\'' +
                ", parent=" + parent +
                '}';
    }
}
