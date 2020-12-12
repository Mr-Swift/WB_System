package com.apple.developer.dao;

@SuppressWarnings("all")
public interface IPermissionDao<T> {
    public T selectPermissions();

    public T selectByRoleId();

    public T selectByMenuId();

    public T selectByRoleName();

    public T selectBYMenuName();

    public T selectByRoleIdAndMenuId();

    public T selectByRoleNameAndMenuName();

    public T insertByRoleIdAndMenuId();

    public T insertByRoleNameAndMenuName();

    public T deleteByRoleIdAndMenuId();

    public T deleteByRoleNameAndMenuName();

    public T updateByRoleIdAndMenuId();

    public T updateByRoleNameAndMenuName();


}
