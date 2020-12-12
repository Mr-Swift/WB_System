package com.apple.developer.dao;

@SuppressWarnings("all")
public interface IMenuDao<T> {
    public T selectByMenuId();

    public T selectByMenuName();

    public T selectByParentId();

    public T selectByParentName();
}
