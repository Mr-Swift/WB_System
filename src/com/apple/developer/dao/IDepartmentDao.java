package com.apple.developer.dao;

@SuppressWarnings("all")
public interface IDepartmentDao<T> {
    public T selectDepartments();

    public T selectByNo();

    public T selectByName();

    public T insertDepartment();

    public T updateByNo();

    public T deleteByNo();

}
