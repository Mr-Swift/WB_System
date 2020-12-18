package com.apple.developer.test.dao;

import com.apple.developer.dao.IDepartmentDao;
import com.apple.developer.dao.impl.DepartmentDaoImpl;
import com.apple.developer.entity.Department;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class DepartmentDaoImplTest {

    IDepartmentDao iDepartmentDao = new DepartmentDaoImpl();

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
    void getOrderByDescStr() {
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
    void getCountOfDepartmentsStr() {
    }

    @Test
    void selectDepartments() {
        List<Department> departmentList = (List<Department>) iDepartmentDao.selectDepartments();
        for (Department department : departmentList
        ) {
            System.out.println(department);
        }
    }

    @Test
    void countOfDepartments() {
        int count = (int) iDepartmentDao.countOfDepartments();
        System.out.println(count);
    }

    @Test
    void selectDepartmentsByPage() {
        List<Department> departmentList = (List<Department>) iDepartmentDao.selectDepartmentsByPage(2, 2);
        for (Department department : departmentList
        ) {
            System.out.println(department);
        }
    }

    @Test
    void selectByNo() {
        List<Department> departmentList = (List<Department>) iDepartmentDao.selectByNo("A0001");
        for (Department department : departmentList
        ) {
            System.out.println(department);
        }
    }

    @Test
    void selectByName() {
        List<Department> departmentList = (List<Department>) iDepartmentDao.selectByName("总经办");
        for (Department department : departmentList
        ) {
            System.out.println(department);
        }
    }

    @Test
    void insertDepartment() {
        Department department = new Department("A0007", "后勤部", "107仓库", "阿黄");
        int result = (int) iDepartmentDao.insertDepartment(department);
        System.out.println(result);
    }

    @Test
    void updateByNo() {
        Department department = new Department("A0007", "后勤部", "107仓库", "黄小牛");
        int result = (int) iDepartmentDao.updateByNo(department);
        System.out.println(result);
    }

    @Test
    void deleteByNo() {
        int result = (int) iDepartmentDao.deleteByNo("A0007");
        System.out.println(result);
    }
}