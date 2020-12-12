package com.apple.developer.dao;

@SuppressWarnings("all")
public interface IEmployeeDao<T> {
    public T selectEmployees();

    public T selectByEmpNo();

    public T selectByEmpName();

    public T selectByDepNo();

    public T insertEmployee();

    public T updateByEmpNo();

    public T deleteByEmpNo();

}
