package com.apple.developer.entity;

import java.io.Serializable;

@SuppressWarnings("all")
public class Account implements Serializable {
    private int acc_id;
    private String acc_no;
    private String emp_no;
    private String acc_type;
    private double money;
    private String acc_status;
    private String acc_create_time;

    private Employee employee;

    /**
     * 构造方法
     * <p>
     * 存入时，将得到的申请人的名字查找到对应的员工编号存进去
     * 存入时只需要emp_no、acc_type、money、acc_status，acc_id自增长、acc_create_time用now()函数自动生成
     * <p>
     * 取出时，将数据库里的员工编号多表联查，查到员工编号、员工姓名取出来
     * 取出时需要acc_no、acc_type、money、acc_status、acc_create_time，employee
     */
    public Account() {
    }

    public Account(String acc_no, String emp_no, String acc_type, double money, String acc_status) {
        this.acc_no = acc_no;
        this.emp_no = emp_no;
        this.acc_type = acc_type;
        this.money = money;
        this.acc_status = acc_status;
    }

    public Account(String acc_no, String acc_type, double money, String acc_status, String acc_create_time, Employee employee) {
        this.acc_no = acc_no;
        this.acc_type = acc_type;
        this.money = money;
        this.acc_status = acc_status;
        this.acc_create_time = acc_create_time;
        this.employee = employee;
    }

    /**
     * getter&setter方法
     *
     * @return
     */
    public int getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(int acc_id) {
        this.acc_id = acc_id;
    }

    public String getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(String acc_no) {
        this.acc_no = acc_no;
    }

    public String getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(String emp_no) {
        this.emp_no = emp_no;
    }

    public String getAcc_type() {
        return acc_type;
    }

    public void setAcc_type(String acc_type) {
        this.acc_type = acc_type;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getAcc_status() {
        return acc_status;
    }

    public void setAcc_status(String acc_status) {
        this.acc_status = acc_status;
    }

    public String getAcc_create_time() {
        return acc_create_time;
    }

    public void setAcc_create_time(String acc_create_time) {
        this.acc_create_time = acc_create_time;
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
                "acc_id=" + acc_id +
                ", acc_no='" + acc_no + '\'' +
                ", emp_no='" + emp_no + '\'' +
                ", acc_type='" + acc_type + '\'' +
                ", money=" + money +
                ", acc_status='" + acc_status + '\'' +
                ", acc_create_time='" + acc_create_time + '\'' +
                ", employee=" + employee +
                '}';
    }
}
