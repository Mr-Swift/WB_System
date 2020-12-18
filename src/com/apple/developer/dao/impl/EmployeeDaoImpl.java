package com.apple.developer.dao.impl;

import com.apple.developer.dao.IEmployeeDao;
import com.apple.developer.dao.IObjectMapper;
import com.apple.developer.entity.Department;
import com.apple.developer.entity.Employee;
import com.apple.developer.util.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author swift
 */
public class EmployeeDaoImpl implements IEmployeeDao {
    public String getBasicQueryStr() {
        StringBuffer stringBuffer = new StringBuffer();

        /**
         * SELECT
         * tb_employee.emp_no,
         * tb_employee.emp_name,
         * tb_department.dep_no,
         * tb_department.dep_name,
         * tb_employee.sex,
         * tb_employee.age,
         * tb_employee.education,
         * tb_employee.email,
         * tb_employee.telphone,
         * tb_employee.address,
         * tb_employee.entry_time,
         * tb_employee.emp_create_time
         * FROM
         * tb_employee
         * JOIN tb_department
         * ON tb_employee.dep_no = tb_department.dep_no
         */
        stringBuffer.append("SELECT ");
        stringBuffer.append("tb_employee.emp_no, ");
        stringBuffer.append("tb_employee.emp_name, ");
        stringBuffer.append("tb_department.dep_no, ");
        stringBuffer.append("tb_department.dep_name, ");
        stringBuffer.append("tb_employee.sex, ");
        stringBuffer.append("tb_employee.age, ");
        stringBuffer.append("tb_employee.education, ");
        stringBuffer.append("tb_employee.email, ");
        stringBuffer.append("tb_employee.telphone, ");
        stringBuffer.append("tb_employee.address, ");
        stringBuffer.append("tb_employee.entry_time, ");
        stringBuffer.append("tb_employee.emp_create_time ");
        stringBuffer.append("FROM ");
        stringBuffer.append("tb_employee ");
        stringBuffer.append("JOIN tb_department ");
        stringBuffer.append("ON tb_employee.dep_no = tb_department.dep_no ");
        return stringBuffer.toString();
    }

    public String getOrderByAscStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("order ");
        stringBuffer.append("by ");
        stringBuffer.append("tb_employee.emp_create_time,tb_employee.emp_id ");
        return stringBuffer.toString();
    }

    public String getOrderByDescStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("order ");
        stringBuffer.append("by ");
        stringBuffer.append("tb_employee.emp_create_time desc,tb_employee.emp_id desc ");
        return stringBuffer.toString();
    }

    public String getLimitStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("limit ");
        stringBuffer.append("?,? ");
        return stringBuffer.toString();
    }

    public String getInsertStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("insert ");
        stringBuffer.append("into ");
        stringBuffer.append("tb_employee ");
        stringBuffer.append("(emp_no,emp_name,dep_no,sex,age,education,email,telphone,address,entry_time,emp_create_time) ");
        stringBuffer.append("values ");
        stringBuffer.append("(?,?,?,?,?,?,?,?,?,?,now()) ");
        return stringBuffer.toString();
    }

    public String getUpdateStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("update ");
        stringBuffer.append("tb_employee ");
        stringBuffer.append("set ");
        stringBuffer.append("emp_name=?,dep_no=?,sex=?,age=?,education=?,email=?,telphone=?,address=?,entry_time=? ");
        stringBuffer.append("where ");
        stringBuffer.append("emp_no=? ");
        return stringBuffer.toString();
    }

    public String getDeleteStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("delete ");
        stringBuffer.append("from ");
        stringBuffer.append("tb_employee ");
        stringBuffer.append("where ");
        stringBuffer.append("emp_no=? ");
        return stringBuffer.toString();
    }

    public String getCountOfEmployeeStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select ");
        stringBuffer.append("count(emp_id) ");
        stringBuffer.append("from ");
        stringBuffer.append("tb_employee ");
        return stringBuffer.toString();
    }

    public String getSelectEmployeeDepNameStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SELECT ");
        stringBuffer.append("tb_department.dep_name ");
        stringBuffer.append("FROM ");
        stringBuffer.append("tb_employee ");
        stringBuffer.append("JOIN ");
        stringBuffer.append("tb_department ");
        stringBuffer.append("ON ");
        stringBuffer.append("tb_employee.dep_no = tb_department.dep_no ");
        stringBuffer.append("GROUP BY ");
        stringBuffer.append("tb_department.dep_id ");
        stringBuffer.append("ORDER BY ");
        stringBuffer.append("tb_department.dep_id ");
        return stringBuffer.toString();
    }

    class EmployeeObjectMapper implements IObjectMapper<Employee> {
        @Override
        public Employee getObjectFromResultSet(ResultSet resultSet) throws SQLException {
            /**
             * SELECT
             * tb_employee.emp_no,
             * tb_employee.emp_name,
             * tb_department.dep_no,
             * tb_department.dep_name,
             * tb_employee.sex,
             * tb_employee.age,
             * tb_employee.education,
             * tb_employee.email,
             * tb_employee.telphone,
             * tb_employee.address,
             * tb_employee.entry_time,
             * tb_employee.emp_create_time
             * FROM
             * tb_employee
             * JOIN tb_department
             * ON tb_employee.dep_no = tb_department.dep_no
             */
            Employee employee = new Employee();
            employee.setempNo(resultSet.getString("tb_employee.emp_no"));
            employee.setempName(resultSet.getString("tb_employee.emp_name"));
            Department department = new Department();
            department.setdepNo(resultSet.getString("tb_department.dep_no"));
            department.setdepName(resultSet.getString("tb_department.dep_name"));
            employee.setDepartment(department);
            employee.setSex(resultSet.getString("tb_employee.sex"));
            employee.setAge(resultSet.getInt("tb_employee.age"));
            employee.setEducation(resultSet.getString("tb_employee.education"));
            employee.setEmail(resultSet.getString("tb_employee.email"));
            employee.setTelphone(resultSet.getString("tb_employee.telphone"));
            employee.setAddress(resultSet.getString("tb_employee.address"));
            employee.setentryTime(resultSet.getString("tb_employee.entry_time"));
            employee.setempCreateTime(resultSet.getString("tb_employee.emp_create_time"));

            return employee;
        }
    }

    @Override
    public Object selectEmployeeDepName() {
        List<String> listOfDepName = null;
        try {
            listOfDepName = JdbcTemplate.executeQuery(getSelectEmployeeDepNameStr(), new IObjectMapper() {
                @Override
                public Object getObjectFromResultSet(ResultSet resultSet) throws SQLException {
                    String depName = resultSet.getString("tb_department.dep_name");
                    return depName;
                }
            }, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfDepName;
    }

    @Override
    public Object selectEmployees() {
        List<Employee> employeeList = null;
        try {
            employeeList = JdbcTemplate.executeQuery(getBasicQueryStr() + getOrderByAscStr(), new EmployeeObjectMapper(), null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Object countOfEmployees() {
        List<Integer> listOfCount = null;
        try {
            listOfCount = JdbcTemplate.executeQuery(getCountOfEmployeeStr(), new IObjectMapper() {
                @Override
                public Object getObjectFromResultSet(ResultSet resultSet) throws SQLException {
                    int count = resultSet.getInt("count(emp_id)");
                    return count;
                }
            }, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfCount.get(0);
    }

    @Override
    public Object selectEmployeesByPage(int currentPage, int pageSize) {
        List<Employee> employeeList = null;
        try {
            employeeList = JdbcTemplate.executeQuery(getBasicQueryStr() + getOrderByAscStr() + getLimitStr(), new EmployeeObjectMapper(), (currentPage - 1) * pageSize, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Object selectByEmpNo(String empNo) {
        List<Employee> employeeList = null;
        String selectByEmpNoStr = "where tb_employee.emp_no=? ";
        try {
            employeeList = JdbcTemplate.executeQuery(getBasicQueryStr() + selectByEmpNoStr + getOrderByAscStr(), new EmployeeObjectMapper(), empNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Object selectByEmpName(String empName) {
        List<Employee> employeeList = null;
        String selectByEmpNameStr = "where tb_employee.emp_name=? ";
        try {
            employeeList = JdbcTemplate.executeQuery(getBasicQueryStr() + selectByEmpNameStr + getOrderByAscStr(), new EmployeeObjectMapper(), empName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Object selectByDepNo(String depNo) {
        List<Employee> employeeList = null;
        String selectByDepNoStr = "where tb_department.dep_no=? ";
        try {
            employeeList = JdbcTemplate.executeQuery(getBasicQueryStr() + selectByDepNoStr + getOrderByAscStr(), new EmployeeObjectMapper(), depNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Object insertEmployee(Employee employee) {
        int result = -1;
        try {
            result = JdbcTemplate.executeUpdate(getInsertStr(), employee.getempNo(), employee.getempName(), employee.getdepNo(), employee.getSex(), employee.getAge(), employee.getEducation(), employee.getEmail(), employee.getTelphone(), employee.getAddress(), employee.getentryTime());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Object updateByEmpNo(Employee employee) {
        int result = -1;
        try {
            result = JdbcTemplate.executeUpdate(getUpdateStr(), employee.getempName(), employee.getdepNo(), employee.getSex(), employee.getAge(), employee.getEducation(), employee.getEmail(), employee.getTelphone(), employee.getAddress(), employee.getentryTime(), employee.getempNo());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Object deleteByEmpNo(String empNo) {
        int result = -1;
        try {
            result = JdbcTemplate.executeUpdate(getDeleteStr(), empNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
