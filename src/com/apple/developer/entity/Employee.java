package com.apple.developer.entity;

import java.io.Serializable;

@SuppressWarnings("all")
public class Employee implements Serializable {
    private int emp_id;
    private String emp_no;
    private String emp_name;
    private String dep_no;
    private String sex;
    private int age;
    private String education;
    private String email;
    private String telphone;
    private String address;
    private String entry_time;
    private String emp_create_time;

    private Department department;

    /**
     * 构造方法
     * <p>
     * 存入时，将得到的部门名查找到对应的部门编号存进去
     * 存入时只需要emp_no、emp_name、dep_no、sex、age、education、email、telphone、address、entry_time，emp_id自增长、emp_create_time用now()函数自动生成
     * <p>
     * 取出时，将数据库里的部门编号多表联查，得到部门编号和部门名
     * 取出时需要emp_no、emp_name、sex、age、education、email、telphone、address、entry_time、emp_create_time，department
     */

    public Employee() {
    }

    public Employee(String emp_no, String emp_name) {
        this.emp_no = emp_no;
        this.emp_name = emp_name;
    }

    public Employee(String emp_no, String emp_name, String dep_no, String sex, int age, String education, String email, String telphone, String address, String entry_time) {
        this.emp_no = emp_no;
        this.emp_name = emp_name;
        this.dep_no = dep_no;
        this.sex = sex;
        this.age = age;
        this.education = education;
        this.email = email;
        this.telphone = telphone;
        this.address = address;
        this.entry_time = entry_time;
    }

    public Employee(String emp_no, String emp_name, String sex, int age, String education, String email, String telphone, String address, String entry_time, String emp_create_time, Department department) {
        this.emp_no = emp_no;
        this.emp_name = emp_name;
        this.sex = sex;
        this.age = age;
        this.education = education;
        this.email = email;
        this.telphone = telphone;
        this.address = address;
        this.entry_time = entry_time;
        this.emp_create_time = emp_create_time;
        this.department = department;
    }

    /**
     * getter&setter方法
     *
     * @return
     */
    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(String emp_no) {
        this.emp_no = emp_no;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getDep_no() {
        return dep_no;
    }

    public void setDep_no(String dep_no) {
        this.dep_no = dep_no;
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

    public String getEntry_time() {
        return entry_time;
    }

    public void setEntry_time(String entry_time) {
        this.entry_time = entry_time;
    }

    public String getEmp_create_time() {
        return emp_create_time;
    }

    public void setEmp_create_time(String emp_create_time) {
        this.emp_create_time = emp_create_time;
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
        return "Employee{" +
                "emp_id=" + emp_id +
                ", emp_no='" + emp_no + '\'' +
                ", emp_name='" + emp_name + '\'' +
                ", dep_no='" + dep_no + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", education='" + education + '\'' +
                ", email='" + email + '\'' +
                ", telphone='" + telphone + '\'' +
                ", address='" + address + '\'' +
                ", entry_time='" + entry_time + '\'' +
                ", emp_create_time='" + emp_create_time + '\'' +
                ", department=" + department +
                '}';
    }
}
