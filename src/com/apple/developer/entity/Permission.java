package com.apple.developer.entity;

import java.io.Serializable;

@SuppressWarnings("all")
public class Permission implements Serializable {
    private int perId;
    private int roleId;
    private int menuId;
    private String perCreateTime;

    private Role role;
    private Menu menu;

    /**
     * 构造方法
     * <p>
     * 存入时，将得到的角色名称、菜单名称查找到对应的角色ID、菜单ID存进去
     * 存入时只需要roleId、menuId，perId自增长、perCreateTime用now()函数自动生成
     * <p>
     * 取出时，将数据库里的角色ID、菜单ID多表联查，查到角色名称、菜单名称取出来
     * 取出时需要perCreateTime,role、menu
     */
    public Permission() {
    }

    public Permission(int roleId, int menuId) {
        this.roleId = roleId;
        this.menuId = menuId;
    }

    public Permission(String perCreateTime, Role role, Menu menu) {
        this.perCreateTime = perCreateTime;
        this.role = role;
        this.menu = menu;
    }


    /**
     * getter&setter方法
     *
     * @return
     */

    public int getperId() {
        return perId;
    }

    public void setperId(int perId) {
        this.perId = perId;
    }

    public int getroleId() {
        return roleId;
    }

    public void setroleId(int roleId) {
        this.roleId = roleId;
    }

    public int getmenuId() {
        return menuId;
    }

    public void setmenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getperCreateTime() {
        return perCreateTime;
    }

    public void setperCreateTime(String perCreateTime) {
        this.perCreateTime = perCreateTime;
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
        return "Permission:"
                + "\troleId-->" + this.role.getroleId()
                + "\troleName-->" + this.role.getroleName()
                + "\tmenuId-->" + this.menu.getmenuId()
                + "\tmenuName-->" + this.menu.getmenuName()
                + "\tperCreateTime-->" + this.getperCreateTime();
    }
}
