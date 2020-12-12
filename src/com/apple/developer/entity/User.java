package com.apple.developer.entity;

import java.io.Serializable;

@SuppressWarnings("all")
public class User implements Serializable {
    private int userId;
    private String loginAccount;
    private String loginPassword;
    private String empNo;
    private int roleId;
    private String userStatus;
    private String userCreateTime;

    private Employee employee;
    private Role role;

    /**
     * 构造方法
     * <p>
     * 存入时，将得到的员工姓名、角色名查找到对应的员工编号、角色ID存进去
     * 存入时只需要loginAccount、loginPassword、empNo、roleId、userStatus，userId自增长、userCreateTime用now()函数自动生成
     * <p>
     * 取出时，将数据库里的员工编号、角色ID多表联查，查到员工姓名、角色名取出来
     * 取出时需要loginAccount、loginPassword、userStatus、userCreateTime，employee、role
     */

    public User() {
    }

    public User(int roleId) {
        this.roleId = roleId;
    }

    public User(String userStatus) {
        this.userStatus = userStatus;
    }

    public User(String loginAccount, String loginPassword, String empNo, int roleId, String userStatus) {
        this.loginAccount = loginAccount;
        this.loginPassword = loginPassword;
        this.empNo = empNo;
        this.roleId = roleId;
        this.userStatus = userStatus;
    }

    public User(String loginAccount, String loginPassword, Employee employee, Role role, String userStatus, String userCreateTime) {
        this.loginAccount = loginAccount;
        this.loginPassword = loginPassword;
        this.employee = employee;
        this.role = role;
        this.userStatus = userStatus;
        this.userCreateTime = userCreateTime;

    }

    /**
     * getter&setter方法
     *
     * @return
     */
    public int getuserId() {
        return userId;
    }

    public void setuserId(int userId) {
        this.userId = userId;
    }

    public String getloginAccount() {
        return loginAccount;
    }

    public void setloginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getloginPassword() {
        return loginPassword;
    }

    public void setloginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getempNo() {
        return empNo;
    }

    public void setempNo(String empNo) {
        this.empNo = empNo;
    }

    public int getroleId() {
        return roleId;
    }

    public void setroleId(int roleId) {
        this.roleId = roleId;
    }

    public String getuserStatus() {
        return userStatus;
    }

    public void setuserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getuserCreateTime() {
        return userCreateTime;
    }

    public void setuserCreateTime(String userCreateTime) {
        this.userCreateTime = userCreateTime;
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
        return "User:"
                + "\tlogin_account--->" + this.loginAccount
                + "\tlogin_password--->" + this.loginPassword
                + "\temp_no--->" + this.employee.getempNo()
                + "\temp_name--->" + this.employee.getempName()
                + "\trole_id--->" + this.role.getroleId()
                + "\trole_name--->" + this.role.getroleName()
                + "\tuser_status--->" + this.userStatus
                + "\tuser_create_time--->" + this.userCreateTime;
    }
}
