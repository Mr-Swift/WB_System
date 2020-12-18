package com.apple.developer.dao;

import com.apple.developer.entity.Role;

@SuppressWarnings("all")
public interface IPermissionDao<T> {
    public T selectRoleNames();

    public T selectMenuNames();


    public T selectPermissions();


    public T countOfPermissions();

    public T selectPermissionsByPage(int currentPage, int pageSize);


    public T selectByRoleId(int roleId);

    public T selectByMenuId(int menuId);

    public T selectByRoleName(String roleName);

    public T selectByMenuName(String menuName);

    public T selectByRoleIdAndMenuId(int roleId, int menuId);

    public T selectByRoleNameAndMenuName(String roleName, String menuName);


    public T insertByRoleIdAndMenuId(Role role);

    public T insertByRoleNameAndMenuName(String roleName, String menuName);

    public T deleteByRoleIdAndMenuId(int roleId, int menuId);

    public T deleteByRoleNameAndMenuName(String roleName, String menuName);

    public T updateByRoleIdAndMenuId(Role role);

    public T updateByRoleNameAndMenuName(String roleName, String menuName);

}
