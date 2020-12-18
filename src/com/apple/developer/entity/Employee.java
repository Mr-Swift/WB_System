package com.apple.developer.entity;

import java.io.Serializable;

@SuppressWarnings("all")
public class Employee implements Serializable {
    private int empId;
    private String empNo;
    private String empName;
    private String depNo;
    private String sex;
    private int age;
    private String education;
    private String email;
    private String telphone;
    private String address;
    private String entryTime;
    private String empCreateTime;

    private Department department;

    /**
     * 构造方法
     * <p>
     * 存入时，将得到的部门名查找到对应的部门编号存进去
     * 存入时只需要empNo、empName、depNo、sex、age、education、email、telphone、address、entryTime，empId自增长、empCreateTime用now()函数自动生成
     * <p>
     * 取出时，将数据库里的部门编号多表联查，得到部门编号和部门名
     * 取出时需要empNo、empName、sex、age、education、email、telphone、address、entryTime、empCreateTime，department
     */

    public Employee() {
    }

    public Employee(String empNo, String empName) {
        this.empNo = empNo;
        this.empName = empName;
    }

    public Employee(String empNo, String empName, String depNo, String sex, int age, String education, String email, String telphone, String address, String entryTime) {
        this.empNo = empNo;
        this.empName = empName;
        this.depNo = depNo;
        this.sex = sex;
        this.age = age;
        this.education = education;
        this.email = email;
        this.telphone = telphone;
        this.address = address;
        this.entryTime = entryTime;
    }

    public Employee(String empNo, String empName, String sex, int age, String education, String email, String telphone, String address, String entryTime, String empCreateTime, Department department) {
        this.empNo = empNo;
        this.empName = empName;
        this.sex = sex;
        this.age = age;
        this.education = education;
        this.email = email;
        this.telphone = telphone;
        this.address = address;
        this.entryTime = entryTime;
        this.empCreateTime = empCreateTime;
        this.department = department;
    }

    /**
     * getter&setter方法
     *
     * @return
     */
    public int getempId() {
        return empId;
    }

    public void setempId(int empId) {
        this.empId = empId;
    }

    public String getempNo() {
        return empNo;
    }

    public void setempNo(String empNo) {
        this.empNo = empNo;
    }

    public String getempName() {
        return empName;
    }

    public void setempName(String empName) {
        this.empName = empName;
    }

    public String getdepNo() {
        return depNo;
    }

    public void setdepNo(String depNo) {
        this.depNo = depNo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getentryTime() {
        return entryTime;
    }

    public void setentryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getempCreateTime() {
        return empCreateTime;
    }

    public void setempCreateTime(String empCreateTime) {
        this.empCreateTime = empCreateTime;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * override toString()方法
     */
    @Override
    public String toString() {
        /**
         *     private int empId;
         *     private String empNo;
         *     private String empName;
         *     private String depNo;
         *     private String sex;
         *     private int age;
         *     private String education;
         *     private String email;
         *     private String telphone;
         *     private String address;
         *     private String entryTime;
         *     private String empCreateTime;
         *
         *     private Department department;
         */
        return "Employee:" + "\tempNo-->" + this.empNo
                + "\tempName-->" + this.empName
                + "\tdepNo-->" + this.department.getdepNo()
                + "\tdepName-->" + this.department.getdepName()
                + "\tsex-->" + this.sex
                + "\tage-->" + this.age
                + "\teducation-->" + this.education
                + "\temail-->" + this.email
                + "\ttelphone-->" + this.telphone
                + "\taddress-->" + this.address
                + "\tentryTime-->" + this.entryTime
                + "\tempCreateTime-->" + this.empCreateTime;
    }
}
