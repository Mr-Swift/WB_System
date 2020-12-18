package com.apple.developer.test.dao;

import com.apple.developer.dao.IEmployeeDao;
import com.apple.developer.dao.impl.EmployeeDaoImpl;
import com.apple.developer.entity.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class EmployeeDaoImplTest {

    IEmployeeDao iEmployeeDao = new EmployeeDaoImpl();

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
    void getCountOfEmployeeStr() {
    }

    @Test
    void getSelectEmployeeDepNameStr() {
    }

    @Test
    void selectEmployeeDepName() {
        List<String> depNameList = (List<String>) iEmployeeDao.selectEmployeeDepName();
        for (String str : depNameList
        ) {
            System.out.println(str);
        }
    }

    @Test
    void selectEmployees() {
        List<Employee> employeeList = (List<Employee>) iEmployeeDao.selectEmployees();
        for (Employee employee : employeeList
        ) {
            System.out.println(employee);
        }
    }

    @Test
    void countOfEmployees() {
        int count = (int) iEmployeeDao.countOfEmployees();
        System.out.println(count);
    }

    @Test
    void selectEmployeesByPage() {
        List<Employee> employeeList = (List<Employee>) iEmployeeDao.selectEmployeesByPage(2, 3);
        for (Employee employee : employeeList
        ) {
            System.out.println(employee);
        }
    }

    @Test
    void selectByEmpNo() {
        List<Employee> employeeList = (List<Employee>) iEmployeeDao.selectByEmpNo("E0004");
        for (Employee employee : employeeList
        ) {
            System.out.println(employee);
        }
    }

    @Test
    void selectByEmpName() {
        List<Employee> employeeList = (List<Employee>) iEmployeeDao.selectByEmpName("吴莫愁");
        for (Employee employee : employeeList
        ) {
            System.out.println(employee);
        }
    }

    @Test
    void selectByDepNo() {
        List<Employee> employeeList = (List<Employee>) iEmployeeDao.selectByDepNo("A0001");
        for (Employee employee : employeeList
        ) {
            System.out.println(employee);
        }
    }

    @Test
    void insertEmployee() {
        Employee employee = new Employee("E0009", "luc", "A0001", "女", 23, "硕士", "gjh990218@icloud.com", "17751036305", "江苏省镇江市", "2020-12-17");
        int result = (int) iEmployeeDao.insertEmployee(employee);
        System.out.println(result);
    }

    @Test
    void updateByEmpNo() {
        Employee employee = new Employee("E0009", "luc", "A0001", "男", 23, "本科", "gjh990218@icloud.com", "17751036305", "江苏省镇江市", "2020-12-17");
        int result = (int) iEmployeeDao.updateByEmpNo(employee);
        System.out.println(result);
    }

    @Test
    void deleteByEmpNo() {
        int result = (int) iEmployeeDao.deleteByEmpNo("E0006");
        System.out.println(result);
    }
}