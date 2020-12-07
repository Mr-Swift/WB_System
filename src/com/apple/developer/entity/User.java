package com.apple.developer.entity;

import java.io.Serializable;

@SuppressWarnings("all")
public class User implements Serializable {
    private int user_id;
    private String login_account;
    private String login_password;
    private String emp_no;
    private int role_id;
    private String user_status;
    private String user_create_time;

    private Employee employee;
    private Role role;

    /**
     * 构造方法
     * <p>
     * 存入时，将得到的员工姓名、角色名查找到对应的员工编号、角色ID存进去
     * 存入时只需要login_account、login_password、emp_no、role_id、user_status，user_id自增长、user_create_time用now()函数自动生成
     * <p>
     * 取出时，将数据库里的员工编号、角色ID多表联查，查到员工姓名、角色名取出来
     * 取出时需要login_account、login_password、user_status、user_create_time，employee、role
     */

    public User() {
    }

    public User(String login_account, String login_password, String emp_no, int role_id, String user_status) {
        this.login_account = login_account;
        this.login_password = login_password;
        this.emp_no = emp_no;
        this.role_id = role_id;
        this.user_status = user_status;
    }

    public User(String login_account, String login_password, String user_status, String user_create_time, Employee employee, Role role) {
        this.login_account = login_account;
        this.login_password = login_password;
        this.user_status = user_status;
        this.user_create_time = user_create_time;
        this.employee = employee;
        this.role = role;
    }

    /**
     * getter&setter方法
     *
     * @return
     */
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getLogin_account() {
        return login_account;
    }

    public void setLogin_account(String login_account) {
        this.login_account = login_account;
    }

    public String getLogin_password() {
        return login_password;
    }

    public void setLogin_password(String login_password) {
        this.login_password = login_password;
    }

    public String getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(String emp_no) {
        this.emp_no = emp_no;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getUser_status() {
        return user_status;
    }

    public void setUser_status(String user_status) {
        this.user_status = user_status;
    }

    public String getUser_create_time() {
        return user_create_time;
    }

    public void setUser_create_time(String user_create_time) {
        this.user_create_time = user_create_time;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * override toString()方法
     */
    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", login_account='" + login_account + '\'' +
                ", login_password='" + login_password + '\'' +
                ", emp_no='" + emp_no + '\'' +
                ", role_id=" + role_id +
                ", user_status='" + user_status + '\'' +
                ", user_create_time='" + user_create_time + '\'' +
                ", employee=" + employee +
                ", role=" + role +
                '}';
    }
}
