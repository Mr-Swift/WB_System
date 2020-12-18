package com.apple.developer.dao.impl;

import com.apple.developer.dao.IDepartmentDao;
import com.apple.developer.dao.IObjectMapper;
import com.apple.developer.entity.Department;
import com.apple.developer.util.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author swift
 */
public class DepartmentDaoImpl implements IDepartmentDao {
    public String getBasicQueryStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select ");
        stringBuffer.append("dep_no,dep_name,location,manager,dep_create_time ");
        stringBuffer.append("from tb_department ");
        return stringBuffer.toString();
    }

    public String getOrderByAscStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("order ");
        stringBuffer.append("by ");
        stringBuffer.append("dep_create_time,dep_id ");
        return stringBuffer.toString();
    }

    public String getOrderByDescStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("order ");
        stringBuffer.append("by ");
        stringBuffer.append("dep_create_time desc,dep_id desc ");
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
        stringBuffer.append("tb_department ");
        stringBuffer.append("(dep_no,dep_name,location,manager,dep_create_time) ");
        stringBuffer.append("values ");
        stringBuffer.append("(?,?,?,?,now()) ");
        return stringBuffer.toString();
    }

    public String getUpdateStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("update ");
        stringBuffer.append("tb_department ");
        stringBuffer.append("set ");
        stringBuffer.append("dep_name=?,location=?,manager=? ");
        stringBuffer.append("where ");
        stringBuffer.append("dep_no=? ");
        return stringBuffer.toString();
    }

    public String getDeleteStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("delete ");
        stringBuffer.append("from ");
        stringBuffer.append("tb_department ");
        stringBuffer.append("where ");
        stringBuffer.append("dep_no=? ");
        return stringBuffer.toString();
    }

    public String getCountOfDepartmentsStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select ");
        stringBuffer.append("count(dep_id) ");
        stringBuffer.append("from ");
        stringBuffer.append("tb_department ");
        return stringBuffer.toString();
    }

    class DepartmentObjectMapper implements IObjectMapper<Department> {
        @Override
        public Department getObjectFromResultSet(ResultSet resultSet) throws SQLException {
            Department department = new Department();
            department.setdepNo(resultSet.getString("dep_no"));
            department.setdepName(resultSet.getString("dep_name"));
            department.setLocation(resultSet.getString("location"));
            department.setmanager(resultSet.getString("manager"));
            department.setdepCreateTime(resultSet.getString("dep_create_time"));
            return department;
        }
    }


    @Override
    public Object selectDepartments() {
        List<Department> departmentList = null;
        try {
            departmentList = JdbcTemplate.executeQuery(getBasicQueryStr() + getOrderByAscStr(), new DepartmentObjectMapper(), null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentList;
    }

    @Override
    public Object countOfDepartments() {
        List<Integer> listOfCount = null;
        try {
            listOfCount = JdbcTemplate.executeQuery(getCountOfDepartmentsStr(), new IObjectMapper() {
                @Override
                public Object getObjectFromResultSet(ResultSet resultSet) throws SQLException {
                    int count = resultSet.getInt("count(dep_id)");
                    return count;
                }
            }, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfCount.get(0);
    }

    @Override
    public Object selectDepartmentsByPage(int currentPage, int pageSize) {
        List<Department> departmentList = null;
        try {
            departmentList = JdbcTemplate.executeQuery(getBasicQueryStr() + getOrderByAscStr() + getLimitStr(), new DepartmentObjectMapper(), (currentPage - 1) * pageSize, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentList;
    }

    @Override
    public Object selectByNo(String depNo) {
        List<Department> departmentList = null;
        String selectByNoStr = "where dep_no=? ";
        try {
            departmentList = JdbcTemplate.executeQuery(getBasicQueryStr() + selectByNoStr + getOrderByAscStr(), new DepartmentObjectMapper(), depNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentList;
    }

    @Override
    public Object selectByName(String depName) {
        List<Department> departmentList = null;
        String selectByNameStr = "where dep_name=? ";
        try {
            departmentList = JdbcTemplate.executeQuery(getBasicQueryStr() + selectByNameStr + getOrderByAscStr(), new DepartmentObjectMapper(), depName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentList;
    }

    @Override
    public Object insertDepartment(Department department) {
        int result = -1;
        try {
            result = JdbcTemplate.executeUpdate(getInsertStr(), department.getdepNo(), department.getdepName(), department.getLocation(), department.getmanager());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Object updateByNo(Department department) {
        int result = -1;
        try {
            result = JdbcTemplate.executeUpdate(getUpdateStr(), department.getdepName(), department.getLocation(), department.getmanager(), department.getdepNo());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Object deleteByNo(String depNo) {
        int result = -1;
        try {
            result = JdbcTemplate.executeUpdate(getDeleteStr(), depNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
