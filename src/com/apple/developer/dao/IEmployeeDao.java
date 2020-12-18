package com.apple.developer.dao;

import com.apple.developer.entity.Employee;

@SuppressWarnings("all")
public interface IEmployeeDao<T> {

    public T selectEmployeeDepName();

    public T selectEmployees();

    public T countOfEmployees();

    public T selectEmployeesByPage(int currentPage, int pageSize);

    public T selectByEmpNo(String empNo);

    public T selectByEmpName(String empName);

    public T selectByDepNo(String depNo);

    public T insertEmployee(Employee employee);

    public T updateByEmpNo(Employee employee);

    public T deleteByEmpNo(String empNo);

}
