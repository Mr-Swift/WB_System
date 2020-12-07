package com.apple.developer.entity;

import java.io.Serializable;

@SuppressWarnings("all")
public class Holiday implements Serializable {
    private int hol_id;
    private String hol_no;
    private String emp_no;
    private String hol_type;
    private String hol_reason;
    private String start_time;
    private String end_time;
    private String hol_status;
    private String hol_create_time;

    private Employee employee;

    /**
     * 构造方法
     * <p>
     * 存入时，将得到的申请人的名字查找到对应的员工编号存进去
     * 存入时只需要hol_no、emp_no、hol_type、hol_reason、start_time、end_time、hol_status，hol_id自增长、hol_create_time用now()函数自动生成
     * <p>
     * 取出时，将数据库里的员工编号多表联查，查到员工编号、员工姓名取出来
     * 取出时需要hol_no、hol_type、hol_reason、start_time、end_time、hol_status、hol_create_time，employee
     */
    public Holiday() {
    }

    public Holiday(String hol_no, String emp_no, String hol_type, String hol_reason, String start_time, String end_time, String hol_status) {
        this.hol_no = hol_no;
        this.emp_no = emp_no;
        this.hol_type = hol_type;
        this.hol_reason = hol_reason;
        this.start_time = start_time;
        this.end_time = end_time;
        this.hol_status = hol_status;
    }

    public Holiday(String hol_no, String hol_type, String hol_reason, String start_time, String end_time, String hol_status, String hol_create_time, Employee employee) {
        this.hol_no = hol_no;
        this.hol_type = hol_type;
        this.hol_reason = hol_reason;
        this.start_time = start_time;
        this.end_time = end_time;
        this.hol_status = hol_status;
        this.hol_create_time = hol_create_time;
        this.employee = employee;
    }

    /**
     * getter&setter方法
     *
     * @return
     */
    public int getHol_id() {
        return hol_id;
    }

    public void setHol_id(int hol_id) {
        this.hol_id = hol_id;
    }

    public String getHol_no() {
        return hol_no;
    }

    public void setHol_no(String hol_no) {
        this.hol_no = hol_no;
    }

    public String getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(String emp_no) {
        this.emp_no = emp_no;
    }

    public String getHol_type() {
        return hol_type;
    }

    public void setHol_type(String hol_type) {
        this.hol_type = hol_type;
    }

    public String getHol_reason() {
        return hol_reason;
    }

    public void setHol_reason(String hol_reason) {
        this.hol_reason = hol_reason;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getHol_status() {
        return hol_status;
    }

    public void setHol_status(String hol_status) {
        this.hol_status = hol_status;
    }

    public String getHol_create_time() {
        return hol_create_time;
    }

    public void setHol_create_time(String hol_create_time) {
        this.hol_create_time = hol_create_time;
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
                "hol_id=" + hol_id +
                ", hol_no='" + hol_no + '\'' +
                ", emp_no='" + emp_no + '\'' +
                ", hol_type='" + hol_type + '\'' +
                ", hol_reason='" + hol_reason + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", hol_status='" + hol_status + '\'' +
                ", hol_create_time='" + hol_create_time + '\'' +
                ", employee=" + employee +
                '}';
    }
}
