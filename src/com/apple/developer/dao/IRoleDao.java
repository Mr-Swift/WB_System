package com.apple.developer.dao;

import com.apple.developer.entity.Role;

@SuppressWarnings("all")
public interface IRoleDao<T> {
    public T selectRoles();

    public T countOfRoles();

    public T selectByPage(int currentPage, int pageSize);

    public T selectById(int roleId);

    public T selectByName(String roleName);

    public T insertRole(Role role);

    public T deleteById(int roleId);

    public T updateById(Role role);
}
