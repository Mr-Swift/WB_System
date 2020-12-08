package com.apple.developer.entity;

import java.io.Serializable;

@SuppressWarnings("all")
public class Holiday implements Serializable {
    private int holId;
    private String holNo;
    private String empNo;
    private String holType;
    private String holReason;
    private String startTime;
    private String endTime;
    private String holStatus;
    private String holCreateTime;

    private Employee employee;

    /**
     * 构造方法
     * <p>
     * 存入时，将得到的申请人的名字查找到对应的员工编号存进去
     * 存入时只需要holNo、empNo、holType、holReason、startTime、endTime、holStatus，holId自增长、holCreateTime用now()函数自动生成
     * <p>
     * 取出时，将数据库里的员工编号多表联查，查到员工编号、员工姓名取出来
     * 取出时需要holNo、holType、holReason、startTime、endTime、holStatus、holCreateTime，employee
     */
    public Holiday() {
    }

    public Holiday(String holNo, String empNo, String holType, String holReason, String startTime, String endTime, String holStatus) {
        this.holNo = holNo;
        this.empNo = empNo;
        this.holType = holType;
        this.holReason = holReason;
        this.startTime = startTime;
        this.endTime = endTime;
        this.holStatus = holStatus;
    }

    public Holiday(String holNo, String holType, String holReason, String startTime, String endTime, String holStatus, String holCreateTime, Employee employee) {
        this.holNo = holNo;
        this.holType = holType;
        this.holReason = holReason;
        this.startTime = startTime;
        this.endTime = endTime;
        this.holStatus = holStatus;
        this.holCreateTime = holCreateTime;
        this.employee = employee;
    }

    /**
     * getter&setter方法
     *
     * @return
     */
    public int getholId() {
        return holId;
    }

    public void setholId(int holId) {
        this.holId = holId;
    }

    public String getholNo() {
        return holNo;
    }

    public void setholNo(String holNo) {
        this.holNo = holNo;
    }

    public String getempNo() {
        return empNo;
    }

    public void setempNo(String empNo) {
        this.empNo = empNo;
    }

    public String getholType() {
        return holType;
    }

    public void setholType(String holType) {
        this.holType = holType;
    }

    public String getholReason() {
        return holReason;
    }

    public void setholReason(String holReason) {
        this.holReason = holReason;
    }

    public String getstartTime() {
        return startTime;
    }

    public void setstartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getendTime() {
        return endTime;
    }

    public void setendTime(String endTime) {
        this.endTime = endTime;
    }

    public String getholStatus() {
        return holStatus;
    }

    public void setholStatus(String holStatus) {
        this.holStatus = holStatus;
    }

    public String getholCreateTime() {
        return holCreateTime;
    }

    public void setholCreateTime(String holCreateTime) {
        this.holCreateTime = holCreateTime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * override toString()方法
     */
    @Override
    public String toString() {
        return "Holiday{" +
                "holId=" + holId +
                ", holNo='" + holNo + '\'' +
                ", empNo='" + empNo + '\'' +
                ", holType='" + holType + '\'' +
                ", holReason='" + holReason + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", holStatus='" + holStatus + '\'' +
                ", holCreateTime='" + holCreateTime + '\'' +
                ", employee=" + employee +
                '}';
    }
}
