package com.apple.developer.entity;

import java.io.Serializable;

@SuppressWarnings("all")
public class Account implements Serializable {
    private int accId;
    private String accNo;
    private String empNo;
    private String accType;
    private double money;
    private String accStatus;
    private String accCreateTime;

    private Employee employee;

    /**
     * 构造方法
     * <p>
     * 存入时，将得到的申请人的名字查找到对应的员工编号存进去
     * 存入时只需要empNo、accType、money、accStatus，accId自增长、accCreateTime用now()函数自动生成
     * <p>
     * 取出时，将数据库里的员工编号多表联查，查到员工编号、员工姓名取出来
     * 取出时需要accNo、accType、money、accStatus、accCreateTime，employee
     */
    public Account() {
    }

    public Account(String accNo, String empNo, String accType, double money, String accStatus) {
        this.accNo = accNo;
        this.empNo = empNo;
        this.accType = accType;
        this.money = money;
        this.accStatus = accStatus;
    }

    public Account(String accNo, String accType, double money, String accStatus, String accCreateTime, Employee employee) {
        this.accNo = accNo;
        this.accType = accType;
        this.money = money;
        this.accStatus = accStatus;
        this.accCreateTime = accCreateTime;
        this.employee = employee;
    }

    /**
     * getter&setter方法
     *
     * @return
     */
    public int getaccId() {
        return accId;
    }

    public void setaccId(int accId) {
        this.accId = accId;
    }

    public String getaccNo() {
        return accNo;
    }

    public void setaccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getempNo() {
        return empNo;
    }

    public void setempNo(String empNo) {
        this.empNo = empNo;
    }

    public String getaccType() {
        return accType;
    }

    public void setaccType(String accType) {
        this.accType = accType;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getaccStatus() {
        return accStatus;
    }

    public void setaccStatus(String accStatus) {
        this.accStatus = accStatus;
    }

    public String getaccCreateTime() {
        return accCreateTime;
    }

    public void setaccCreateTime(String accCreateTime) {
        this.accCreateTime = accCreateTime;
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
        return "Account{" +
                "accId=" + accId +
                ", accNo='" + accNo + '\'' +
                ", empNo='" + empNo + '\'' +
                ", accType='" + accType + '\'' +
                ", money=" + money +
                ", accStatus='" + accStatus + '\'' +
                ", accCreateTime='" + accCreateTime + '\'' +
                ", employee=" + employee +
                '}';
    }
}
