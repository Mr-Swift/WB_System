package com.apple.developer.entity;

import java.io.Serializable;

@SuppressWarnings("all")
public class Role implements Serializable {
    private int roleId;
    private String roleName;
    private String roleCreateTime;


    /**
     * 构造方法
     * <p>
     * 存入时只需要roleName,roleId自增长 roleCreateTime用now()函数自动生成
     * <p>
     * 取出时需要roleId roleName roleCreateTime
     */
    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Role(int roleId, String roleName, String roleCreateTime) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleCreateTime = roleCreateTime;
    }


    /**
     * getter&setter方法
     *
     * @return
     */
    public int getroleId() {
        return roleId;
    }

    public void setroleId(int roleId) {
        this.roleId = roleId;
    }

    public String getroleName() {
        return roleName;
    }

    public void setroleName(String roleName) {
        this.roleName = roleName;
    }

    public String getroleCreateTime() {
        return roleCreateTime;
    }

    public void setroleCreateTime(String roleCreateTime) {
        this.roleCreateTime = roleCreateTime;
    }

    /**
     * override toString()方法
     */
    @Override
    public String toString() {
        return "role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleCreateTime='" + roleCreateTime + '\'' +
                '}';
    }
}
