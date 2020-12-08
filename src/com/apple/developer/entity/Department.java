package com.apple.developer.entity;

import java.io.Serializable;

@SuppressWarnings("all")
public class Department implements Serializable {
    private int depId;
    private String depNo;
    private String depName;
    private String location;
    private String leader;
    private String depCreateTime;

    /**
     * 构造方法
     * <p>
     * 存入时只需要depNo、depName、location、leader，depId自增长、depCreateTime now()函数自动获取
     * <p>
     * 取出时需要depId、depNo、depName、location、leader、depCreateTime
     */

    public Department() {
    }

    public Department(String depNo, String depName) {
        this.depNo = depNo;
        this.depName = depName;
    }

    public Department(String depNo, String depName, String location, String leader) {
        this.depNo = depNo;
        this.depName = depName;
        this.location = location;
        this.leader = leader;
    }

    public Department(String depNo, String depName, String location, String leader, String depCreateTime) {
        this.depNo = depNo;
        this.depName = depName;
        this.location = location;
        this.leader = leader;
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

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
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
                "depId=" + depId +
                ", depNo='" + depNo + '\'' +
                ", depName='" + depName + '\'' +
                ", location='" + location + '\'' +
                ", leader='" + leader + '\'' +
                ", depCreateTime='" + depCreateTime + '\'' +
                '}';
    }
}
