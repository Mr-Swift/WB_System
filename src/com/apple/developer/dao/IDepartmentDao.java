package com.apple.developer.dao;

import com.apple.developer.entity.Department;

@SuppressWarnings("all")
public interface IDepartmentDao<T> {
    public T selectDepartments();

    public T countOfDepartments();

    public T selectDepartmentsByPage(int currentPage, int pageSize);

    public T selectByNo(String depNo);

    public T selectByName(String depName);

    public T insertDepartment(Department department);

    public T updateByNo(Department department);

    public T deleteByNo(String depNo);

}
