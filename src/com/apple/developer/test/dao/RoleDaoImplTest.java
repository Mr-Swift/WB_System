package com.apple.developer.test.dao;

import com.apple.developer.dao.IRoleDao;
import com.apple.developer.dao.impl.RoleDaoImpl;
import com.apple.developer.entity.Role;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class RoleDaoImplTest {
    IRoleDao iRoleDao = new RoleDaoImpl();

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
    void getOrderByAsc() {
    }

    @Test
    void getOrderByDesc() {
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
    void getCountOfRolesStr() {
        int count = (int) iRoleDao.countOfRoles();
        System.out.println(count);
    }

    @Test
    void selectRoles() {
        List<Role> roleList = (List<Role>) iRoleDao.selectRoles();
        for (Role role : roleList
        ) {
            System.out.println(role);
        }
    }

    @Test
    void selectByPage() {
        List<Role> roleList = (List<Role>) iRoleDao.selectByPage(2, 2);
        for (Role role : roleList
        ) {
            System.out.println(role);
        }
    }

    @Test
    void selectById() {
        List<Role> roleList = (List<Role>) iRoleDao.selectById(3);
        for (Role role : roleList
        ) {
            System.out.println(role);
        }
    }

    @Test
    void selectByName() {

    }
}