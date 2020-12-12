package com.apple.developer.dao;

@SuppressWarnings("all")
public interface IRoleDao<T> {
    public T selectRoles();

    public T selectById();

    public T selectByName();

    public T insertRole();

    public T deleteById();

    public T updateById();
}
