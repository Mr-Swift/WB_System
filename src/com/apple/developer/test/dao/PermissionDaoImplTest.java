package com.apple.developer.test.dao;

import com.apple.developer.dao.IPermissionDao;
import com.apple.developer.dao.impl.PermissionDaoImpl;
import com.apple.developer.entity.Permission;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class PermissionDaoImplTest {

    IPermissionDao iPermissionDao = new PermissionDaoImpl();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getBasicQueryStr() {
    }

    @Test
    void getOrderByAscStr() {
    }

    @Test
    void getLimitStr() {
    }

    @Test
    void getInsertStr() {
    }

    @Test
    void getUpdateStr() {
    }

    @Test
    void getDeleteStr() {
    }

    @Test
    void getCountOfUsersStr() {
    }

    @Test
    void getSelectRoleNamesStr() {
    }

    @Test
    void getSelectMenuNamesStr() {
    }

    @Test
    void selectRoleNames() {
        List<String> roleNameList = (List<String>) iPermissionDao.selectRoleNames();
        for (String str : roleNameList
        ) {
            System.out.println(str);
        }
    }

    @Test
    void selectMenuNames() {
        List<String> menuNameList = (List<String>) iPermissionDao.selectMenuNames();
        for (String str : menuNameList
        ) {
            System.out.println(str);
        }
    }

    @Test
    void selectPermissions() {
        List<Permission> permissionList = (List<Permission>) iPermissionDao.selectPermissions();
        for (Permission permission : permissionList
        ) {
            System.out.println(permission);
        }
    }

    @Test
    void countOfPermissions() {
        int count = (int) iPermissionDao.countOfPermissions();
        System.out.println(count);
    }

    @Test
    void selectPermissionsByPage() {
        List<Permission> permissionList = (List<Permission>) iPermissionDao.selectPermissionsByPage(2, 2);
        for (Permission permission : permissionList
        ) {
            System.out.println(permission);
        }
    }

    @Test
    void selectByRoleId() {
        List<Permission> permissionList = (List<Permission>) iPermissionDao.selectByRoleId(1);
        for (Permission permission : permissionList
        ) {
            System.out.println(permission);
        }
    }

    @Test
    void selectByMenuId() {
        List<Permission> permissionList = (List<Permission>) iPermissionDao.selectByMenuId(1);
        for (Permission permission : permissionList
        ) {
            System.out.println(permission);
        }
    }

    @Test
    void selectByRoleName() {
        List<Permission> permissionList = (List<Permission>) iPermissionDao.selectByRoleName("超级管理员");
        for (Permission permission : permissionList
        ) {
            System.out.println(permission);
        }
    }

    @Test
    void selectByMenuName() {
        List<Permission> permissionList = (List<Permission>) iPermissionDao.selectByMenuName("系统管理");
        for (Permission permission : permissionList
        ) {
            System.out.println(permission);
        }
    }

    @Test
    void selectByRoleIdAndMenuId() {
        List<Permission> permissionList = (List<Permission>) iPermissionDao.selectByRoleIdAndMenuId(1, 1);
        for (Permission permission : permissionList
        ) {
            System.out.println(permission);
        }
    }

    @Test
    void selectByRoleNameAndMenuName() {
    }

    @Test
    void insertByRoleIdAndMenuId() {
    }

    @Test
    void insertByRoleNameAndMenuName() {
    }

    @Test
    void deleteByRoleIdAndMenuId() {
    }

    @Test
    void deleteByRoleNameAndMenuName() {
    }

    @Test
    void updateByRoleIdAndMenuId() {
    }

    @Test
    void updateByRoleNameAndMenuName() {
    }
}