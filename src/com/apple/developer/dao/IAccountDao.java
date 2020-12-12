package com.apple.developer.dao;

@SuppressWarnings("all")
public interface IAccountDao<T> {
    public T selectAccounts();

    public T selectByNo();

    public T selectByType();

    public T selectByStatus();

    public T selectByTypeAndStatus();

    public T insertAccount();

    public T updateByNo();

    public T deleteByNo();

    public T getCount();

}
