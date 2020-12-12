package com.apple.developer.test.dao;

import com.apple.developer.dao.IUserDao;
import com.apple.developer.dao.impl.UserDaoImpl;
import com.apple.developer.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class UserDaoImplTest {
    IUserDao iUserDao = new UserDaoImpl();

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
    void countOfUsers() {
        int count = (int) iUserDao.countOfUsers();
        System.out.println(count);
    }

    @Test
    void selectUserRoleName() {
        List<String> listOfRoleName = (List<String>) iUserDao.selectUserRoleName();
        for (String str : listOfRoleName
        ) {
            System.out.println(str);
        }
    }

    @Test
    void selectUserStatus() {
        List<String> listOfUserStatus = (List<String>) iUserDao.selectUserStatus();
        for (String str : listOfUserStatus
        ) {
            System.out.println(str);
        }
    }

    @Test
    void selectByPage() {
        List<User> userList = (List<User>) iUserDao.selectUsersByPage(1, 2);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    void selectUsers() {
        List<User> userList = (List<User>) iUserDao.selectUsers();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    void selectByAccount() {
        List<User> userList = (List<User>) iUserDao.selectByAccount("admin");
        for (User user : userList) {
            System.out.println(user);

        }
    }

    @Test
    void selectByStatus() {
        List<User> userList = (List<User>) iUserDao.selectByStatus("注销");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    void selectByRoleId() {
        List<User> userList = (List<User>) iUserDao.selectByRoleId(1);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    void selectByStatusAndRole() {
        List<User> userList = (List<User>) iUserDao.selectByStatusAndRoleId(1, "正常");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    void insertUser() {
        User userInsert = new User("jack01", "jack123", "E0001", 1, "正常");
        int result = (int) iUserDao.insertUser(userInsert);
        System.out.println(result);
    }

    @Test
    void updateByAccount() {
        User userUpdate = new User("jack", "jack123456", "E0002", 1, "正常");
        int result = (int) iUserDao.updateByAccount(userUpdate);
        System.out.println(result);
    }

    @Test
    void deleteByAccount() {
        int result = (int) iUserDao.deleteByAccount("jack01");
        System.out.println(result);
    }

    @Test
    void selectUsersByParams() {
        List<User> userList = (List<User>) iUserDao.selectUsersByParams("admin", 0, null);
        for (User user : userList) {
            System.out.println(user);
        }
    }
}