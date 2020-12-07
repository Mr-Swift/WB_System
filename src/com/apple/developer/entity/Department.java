package com.apple.developer.entity;

import java.io.Serializable;

@SuppressWarnings("all")
public class Department implements Serializable {
    private int dep_id;
    private String dep_no;
    private String dep_name;
    private String location;
    private String leader;
    private String dep_create_time;

    /**
     * 构造方法
     * <p>
     * 存入时只需要dep_no、dep_name、location、leader，dep_id自增长、dep_create_time now()函数自动获取
     * <p>
     * 取出时需要dep_id、dep_no、dep_name、location、leader、dep_create_time
     */

    public Department() {
    }

    public Department(String dep_no, String dep_name) {
        this.dep_no = dep_no;
        this.dep_name = dep_name;
    }

    public Department(String dep_no, String dep_name, String location, String leader) {
        this.dep_no = dep_no;
        this.dep_name = dep_name;
        this.location = location;
        this.leader = leader;
    }

    public Department(String dep_no, String dep_name, String location, String leader, String dep_create_time) {
        this.dep_no = dep_no;
        this.dep_name = dep_name;
        this.location = location;
        this.leader = leader;
        this.dep_create_time = dep_create_time;
    }


    /**
     * getter&setter方法
     *
     * @return
     */
    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public String getDep_no() {
        return dep_no;
    }

    public void setDep_no(String dep_no) {
        this.dep_no = dep_no;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
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

    public String getDep_create_time() {
        return dep_create_time;
    }

    public void setDep_create_time(String dep_create_time) {
        this.dep_create_time = dep_create_time;
    }


    /**
     * override toString()方法
     */
    @Override
    public String toString() {
        return "Department{" +
                "dep_id=" + dep_id +
                ", dep_no='" + dep_no + '\'' +
                ", dep_name='" + dep_name + '\'' +
                ", location='" + location + '\'' +
                ", leader='" + leader + '\'' +
                ", dep_create_time='" + dep_create_time + '\'' +
                '}';
    }
}
