package com.apple.developer.dao;

import com.apple.developer.entity.User;

@SuppressWarnings("all")
public interface IUserDao<T> {
    public T selectUserRoleName();

    public T selectUserStatus();

    public T selectUsers();

    public T countOfUsers();

    public T selectByPage(int currentPage, int pageSize);

    public T selectByAccount(String loginAccount);

    public T selectByRoleId(int roleId);

    public T selectByStatus(String userStatus);

    public T selectByStatusAndRoleId(int roleId, String userStatus);

    public T selectUsersByParams(String loginAccount, int roleId, String userStatus);

    public T insertUser(User userInsert);

    public T deleteByAccount(String loginAccount);

    public T updateByAccount(User userUpdate);


}
