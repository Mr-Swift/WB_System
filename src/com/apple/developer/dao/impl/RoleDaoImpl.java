package com.apple.developer.dao.impl;

import com.apple.developer.dao.IObjectMapper;
import com.apple.developer.dao.IRoleDao;
import com.apple.developer.entity.Role;
import com.apple.developer.util.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author swift
 */
public class RoleDaoImpl implements IRoleDao {
    public String getBasicQueryStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select ");
        stringBuffer.append("role_id,role_name,role_create_time ");
        stringBuffer.append("from tb_role ");
        return stringBuffer.toString();
    }

    public String getOrderByAsc() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("order ");
        stringBuffer.append("by ");
        stringBuffer.append("role_create_time,role_id ");
        return stringBuffer.toString();
    }

    public String getOrderByDesc() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("order ");
        stringBuffer.append("by ");
        stringBuffer.append("order by role_create_time desc,role_id desc ");
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
        stringBuffer.append("tb_role ");
        stringBuffer.append("(role_name,role_create_time) ");
        stringBuffer.append("values ");
        stringBuffer.append("(?,now()) ");
        return stringBuffer.toString();
    }

    public String getUpdateStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("update ");
        stringBuffer.append("tb_role ");
        stringBuffer.append("set ");
        stringBuffer.append("role_name=？ ");
        stringBuffer.append("where ");
        stringBuffer.append("role_id=？ ");
        return stringBuffer.toString();
    }

    public String getDeleteStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("delete ");
        stringBuffer.append("from ");
        stringBuffer.append("tb_role ");
        stringBuffer.append("where ");
        stringBuffer.append("role_id=? ");
        return stringBuffer.toString();
    }

    public String getCountOfRolesStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select ");
        stringBuffer.append("count(role_id) ");
        stringBuffer.append("from ");
        stringBuffer.append("tb_role ");
        return stringBuffer.toString();
    }

    class RoleObjectMapper implements IObjectMapper<Role> {
        @Override
        public Role getObjectFromResultSet(ResultSet resultSet) throws SQLException {
            Role role = new Role();
            role.setroleId(resultSet.getInt("role_id"));
            role.setroleName(resultSet.getString("role_name"));
            role.setroleCreateTime(resultSet.getString("role_create_time"));
            return role;
        }
    }


    @Override
    public Object selectRoles() {
        List<Role> roleList = null;
        try {
            roleList = JdbcTemplate.executeQuery(getBasicQueryStr() + getOrderByAsc(), new RoleObjectMapper(), null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleList;
    }

    @Override
    public Object countOfRoles() {
        List<Integer> listOfCount = null;
        try {
            listOfCount = JdbcTemplate.executeQuery(getCountOfRolesStr(), new IObjectMapper() {
                @Override
                public Object getObjectFromResultSet(ResultSet resultSet) throws SQLException {
                    int count = resultSet.getInt("count(role_id)");
                    return count;
                }
            }, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfCount.get(0);
    }

    @Override
    public Object selectByPage(int currentPage, int pageSize) {
        List<Role> roleList = null;
        try {
            roleList = JdbcTemplate.executeQuery(getBasicQueryStr() + getOrderByAsc() + getLimitStr(), new RoleObjectMapper(), (currentPage - 1) * pageSize, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleList;
    }

    @Override
    public Object selectById(int roleId) {
        List<Role> roleList = null;
        String selectByIdStr = "where role_id=? ";
        try {
            roleList = JdbcTemplate.executeQuery(getBasicQueryStr() + selectByIdStr + getOrderByAsc(), new RoleObjectMapper(), roleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleList;
    }

    @Override
    public Object selectByName(String roleName) {
        List<Role> roleList = null;
        String selectByNameStr = "where role_name=? ";
        try {
            roleList = JdbcTemplate.executeQuery(getBasicQueryStr() + selectByNameStr + getOrderByAsc(), new RoleObjectMapper(), null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleList;
    }

    @Override
    public Object insertRole(Role role) {
        int result = -1;
        try {
            result = JdbcTemplate.executeUpdate(getInsertStr(), role.getroleName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Object deleteById(int roleId) {
        int result = -1;
        try {
            result = JdbcTemplate.executeUpdate(getDeleteStr(), roleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Object updateById(Role role) {
        int result = -1;
        try {
            result = JdbcTemplate.executeUpdate(getUpdateStr(), role.getroleName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
