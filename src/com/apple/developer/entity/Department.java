package com.apple.developer.entity;

import java.io.Serializable;

@SuppressWarnings("all")
public class Department implements Serializable {
    private int depId;
    private String depNo;
    private String depName;
    private String location;
    private String manager;
    private String depCreateTime;

    /**
     * 构造方法
     * <p>
     * 存入时只需要depNo、depName、location、manager，depId自增长、depCreateTime now()函数自动获取
     * <p>
     * 取出时需要depId、depNo、depName、location、manager、depCreateTime
     */

    public Department() {
    }

    public Department(String depNo, String depName) {
        this.depNo = depNo;
        this.depName = depName;
    }

    public Department(String depNo, String depName, String location, String manager) {
        this.depNo = depNo;
        this.depName = depName;
        this.location = location;
        this.manager = manager;
    }

    public Department(String depNo, String depName, String location, String manager, String depCreateTime) {
        this.depNo = depNo;
        this.depName = depName;
        this.location = location;
        this.manager = manager;
        this.depCreateTime = depCreateTime;
    }


    /**
     * getter&setter方法
     *
     * @return
     */
    public int getdepId() {
        return depId;
    }

    public void setdepId(int depId) {
        this.depId = depId;
    }

    public String getdepNo() {
        return depNo;
    }

    public void setdepNo(String depNo) {
        this.depNo = depNo;
    }

    public String getdepName() {
        return depName;
    }

    public void setdepName(String depName) {
        this.depName = depName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getmanager() {
        return manager;
    }

    public void setmanager(String manager) {
        this.manager = manager;
    }

    public String getdepCreateTime() {
        return depCreateTime;
    }

    public void setdepCreateTime(String depCreateTime) {
        this.depCreateTime = depCreateTime;
    }


    /**
     * override toString()方法
     */
    @Override
    public String toString() {
        return "Department{" +
                "depNo='" + depNo + '\'' +
                ", depName='" + depName + '\'' +
                ", location='" + location + '\'' +
                ", manager='" + manager + '\'' +
                ", depCreateTime='" + depCreateTime + '\'' +
                '}';
    }
}
