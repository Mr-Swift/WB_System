package com.apple.developer.dao.impl;

import com.apple.developer.dao.IObjectMapper;
import com.apple.developer.dao.IUserDao;
import com.apple.developer.entity.Employee;
import com.apple.developer.entity.Role;
import com.apple.developer.entity.User;
import com.apple.developer.util.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author swift
 */
public class UserDaoImpl implements IUserDao {
    public String getBasicQueryStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SELECT ");
        stringBuffer.append("tb_user.login_account,");
        stringBuffer.append("tb_user.login_password,");
        stringBuffer.append("tb_employee.emp_no,");
        stringBuffer.append("tb_employee.emp_name,");
        stringBuffer.append("tb_role.role_id,");
        stringBuffer.append("tb_role.role_name,");
        stringBuffer.append("tb_user.user_status,");
        stringBuffer.append("tb_user.user_create_time ");
        stringBuffer.append("FROM ");
        stringBuffer.append("tb_user ");
        stringBuffer.append("JOIN tb_employee ");
        stringBuffer.append("ON tb_user.emp_no = tb_employee.emp_no ");
        stringBuffer.append("JOIN tb_role ");
        stringBuffer.append("ON tb_role.role_id = tb_user.role_id ");
        return stringBuffer.toString();
    }

    public String getOrderByAsc() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("order ");
        stringBuffer.append("by ");
        stringBuffer.append("tb_user.user_create_time,tb_user.user_id ");
        return stringBuffer.toString();
    }

    public String getOrderByDesc() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("order ");
        stringBuffer.append("by ");
        stringBuffer.append("tb_user.user_create_time desc,tb_user.user_id desc ");
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
        stringBuffer.append("tb_user(login_account,login_password,emp_no,role_id,user_status,user_create_time) ");
        stringBuffer.append("values ");
        stringBuffer.append("(?,?,?,?,?,now()) ");
        return stringBuffer.toString();
    }

    public String getUpdateStr() {
        StringBuffer stringBuffer = new StringBuffer();
//        update tb_user set login_password=?,emp_no=?,role_id=?,user_status=? where login_account=?
        stringBuffer.append("update ");
        stringBuffer.append("tb_user ");
        stringBuffer.append("set ");
        stringBuffer.append("login_password=?,emp_no=?,role_id=?,user_status=? ");
        stringBuffer.append("where ");
        stringBuffer.append("login_account=? ");
        return stringBuffer.toString();
    }

    public String getDeleteStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("delete ");
        stringBuffer.append("from ");
        stringBuffer.append("tb_user ");
        stringBuffer.append("where ");
        stringBuffer.append("login_account=? ");
        return stringBuffer.toString();
    }

    public String getCountOfUsersStr() {
        StringBuffer stringBuffer = new StringBuffer();
//        select count(user_id) from tb_user
        stringBuffer.append("select ");
        stringBuffer.append("count(user_id) ");
        stringBuffer.append("from ");
        stringBuffer.append("tb_user ");
        return stringBuffer.toString();
    }

    public String getSelectUserRoleNameStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SELECT ");
        stringBuffer.append("tb_role.role_name ");
        stringBuffer.append("FROM ");
        stringBuffer.append("tb_user ");
        stringBuffer.append("JOIN tb_role ");
        stringBuffer.append("ON tb_user.role_id = tb_role.role_id ");
        stringBuffer.append("GROUP BY tb_user.role_id ");
        stringBuffer.append("ORDER BY tb_role.role_id ");
        return stringBuffer.toString();
    }

    public String getSelectUserStatusStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select ");
        stringBuffer.append("user_status ");
        stringBuffer.append("from ");
        stringBuffer.append("tb_user ");
        stringBuffer.append("group by ");
        stringBuffer.append("user_status ");
        return stringBuffer.toString();
    }

    class UserObjectMapper implements IObjectMapper<User> {
        @Override
        public User getObjectFromResultSet(ResultSet resultSet) throws SQLException {
            User user = new User();
            user.setloginAccount(resultSet.getString("tb_user.login_account"));
            user.setloginPassword(resultSet.getString("tb_user.login_password"));
            Employee employee = new Employee();
            employee.setempNo(resultSet.getString("tb_employee.emp_no"));
            employee.setempName(resultSet.getString("tb_employee.emp_name"));
            user.setEmployee(employee);
            Role role = new Role();
            role.setroleId(resultSet.getInt("tb_role.role_id"));
            role.setroleName(resultSet.getString("tb_role.role_name"));
            user.setRole(role);
            user.setuserStatus(resultSet.getString("tb_user.user_status"));
            user.setuserCreateTime(resultSet.getString("tb_user.user_create_time"));
            return user;
        }
    }

    @Override
    public Object selectUserRoleName() {
        List<String> listOfRoleName = null;
        try {
            listOfRoleName = JdbcTemplate.executeQuery(getSelectUserRoleNameStr(), new IObjectMapper() {
                @Override
                public Object getObjectFromResultSet(ResultSet resultSet) throws SQLException {
                    String roleName = resultSet.getString("tb_role.role_name");
                    return roleName;
                }
            }, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfRoleName;
    }

    @Override
    public Object selectUserStatus() {
        List<String> listOfUserStatus = null;
        try {
            listOfUserStatus = JdbcTemplate.executeQuery(getSelectUserStatusStr(), new IObjectMapper() {
                @Override
                public Object getObjectFromResultSet(ResultSet resultSet) throws SQLException {
                    String userStatus = resultSet.getString("user_status");
                    return userStatus;
                }
            }, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfUserStatus;
    }

    @Override
    public Object countOfUsers() {
        List<Integer> listOfCount = null;
        try {
            listOfCount = JdbcTemplate.executeQuery(getCountOfUsersStr(), new IObjectMapper() {
                @Override
                public Object getObjectFromResultSet(ResultSet resultSet) throws SQLException {
                    int count = resultSet.getInt("count(user_id)");
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
        List<User> userList = null;
        try {
            userList = JdbcTemplate.executeQuery(getBasicQueryStr() + getOrderByAsc() + getLimitStr(), new UserObjectMapper(), (currentPage - 1) * pageSize, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public Object selectUsers() {
        List<User> userList = null;
        try {
            userList = JdbcTemplate.executeQuery(getBasicQueryStr() + getOrderByAsc(), new UserObjectMapper(), null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public Object selectByAccount(String loginAccount) {
        List<User> userList = null;
        String selectByAccountStr = "where tb_user.login_account=? ";
        try {
            userList = JdbcTemplate.executeQuery(getBasicQueryStr() + selectByAccountStr + getOrderByAsc(), new UserObjectMapper(), loginAccount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public Object selectByStatus(String userStatus) {
        List<User> userList = null;
        String selectByStatusStr = "where tb_user.user_status=? ";
        try {
            userList = JdbcTemplate.executeQuery(getBasicQueryStr() + selectByStatusStr + getOrderByAsc(), new UserObjectMapper(), userStatus);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public Object selectByRoleId(int roleId) {
        List<User> userList = null;
        String selectByRoleIdStr = "where tb_role.role_id=? ";
        try {
            userList = JdbcTemplate.executeQuery(getBasicQueryStr() + selectByRoleIdStr + getOrderByAsc(), new UserObjectMapper(), roleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public Object selectByStatusAndRoleId(int roleId, String userStatus) {
        List<User> userList = null;
        String selectByStatusAndRoleIdStr = "where tb_role.role_id=? and tb_user.user_status=? ";
        try {
            userList = JdbcTemplate.executeQuery(getBasicQueryStr() + selectByStatusAndRoleIdStr + getOrderByAsc(), new UserObjectMapper(), roleId, userStatus);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public Object insertUser(User userInsert) {
        int result = -1;
        try {
            result = JdbcTemplate.executeUpdate(getInsertStr(), userInsert.getloginAccount(), userInsert.getloginPassword(), userInsert.getempNo(), userInsert.getroleId(), userInsert.getuserStatus());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Object updateByAccount(User userUpdate) {
        int result = -1;
        try {
            result = JdbcTemplate.executeUpdate(getUpdateStr(), userUpdate.getloginPassword(), userUpdate.getempNo(), userUpdate.getroleId(), userUpdate.getuserStatus(), userUpdate.getloginAccount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Object deleteByAccount(String loginAccount) {
        int result = -1;
        try {
            result = JdbcTemplate.executeUpdate(getDeleteStr(), loginAccount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Object selectUsersByParams(String loginAccount, int roleId, String userStatus) {
        List<User> userList = null;
        if (loginAccount == null && roleId == 0 && userStatus == null) {
            userList = (List<User>) selectUsers();
        } else if (loginAccount != null && roleId == 0 && userStatus == null) {
            userList = (List<User>) selectByAccount(loginAccount);
        } else if (loginAccount == null && roleId != 0 && userStatus == null) {
            userList = (List<User>) selectByRoleId(roleId);
        } else if (loginAccount == null && roleId == 0 && userStatus != null) {
            userList = (List<User>) selectByStatus(userStatus);
        } else if (loginAccount == null && roleId != 0 && userStatus != null) {
            userList = (List<User>) selectByStatusAndRoleId(roleId, userStatus);
        }
        return userList;
    }
}
