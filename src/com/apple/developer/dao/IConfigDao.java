package com.apple.developer.dao;

@SuppressWarnings("all")
public interface IConfigDao<T> {
    public T selectByType(String type);
}
