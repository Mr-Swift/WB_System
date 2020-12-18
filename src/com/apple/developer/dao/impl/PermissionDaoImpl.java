package com.apple.developer.dao.impl;

import com.apple.developer.dao.IObjectMapper;
import com.apple.developer.dao.IPermissionDao;
import com.apple.developer.entity.Menu;
import com.apple.developer.entity.Permission;
import com.apple.developer.entity.Role;
import com.apple.developer.util.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("all")
/**
 * @author swift
 */
public class PermissionDaoImpl implements IPermissionDao {
    public String getBasicQueryStr() {
        /**
         * SELECT
         * tb_role.role_id,
         * tb_role.role_name,
         * tb_menu.menu_id,
         * tb_menu.menu_name,
         * tb_permission.per_create_time
         * FROM
         * tb_permission
         * JOIN tb_role
         * ON tb_permission.role_id = tb_role.role_id
         * JOIN tb_menu
         * ON tb_permission.menu_id = tb_menu.menu_id
         */
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SELECT ");
        stringBuffer.append("tb_role.role_id, ");
        stringBuffer.append("tb_role.role_name, ");
        stringBuffer.append("tb_menu.menu_id, ");
        stringBuffer.append("tb_menu.menu_name, ");
        stringBuffer.append("tb_permission.per_create_time ");
        stringBuffer.append("FROM ");
        stringBuffer.append("tb_permission ");
        stringBuffer.append("JOIN ");
        stringBuffer.append("tb_role ");
        stringBuffer.append("ON ");
        stringBuffer.append("tb_permission.role_id = tb_role.role_id ");
        stringBuffer.append("JOIN ");
        stringBuffer.append("tb_menu ");
        stringBuffer.append("ON ");
        stringBuffer.append("tb_permission.menu_id = tb_menu.menu_id ");
        return stringBuffer.toString();
    }

    public String getOrderByAscStr() {
        /**
         * ORDER BY tb_role.role_id,tb_menu.menu_id,tb_permission.per_create_time
         */
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("order ");
        stringBuffer.append("by ");
        stringBuffer.append("tb_role.role_id,tb_menu.menu_id,tb_permission.per_create_time ");
        return stringBuffer.toString();
    }

//    public String getOrderByDescStr() {
//        /**
//         *
//         */
//        StringBuffer stringBuffer = new StringBuffer();
//        stringBuffer.append("order ");
//        stringBuffer.append("by ");
//        stringBuffer.append("");
//        return stringBuffer.toString();
//    }

    public String getLimitStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("limit ");
        stringBuffer.append("?,? ");
        return stringBuffer.toString();
    }

    public String getInsertStr() {
        /**
         * insert
         * into
         * tb_permission
         * (role_id,menu_id,per_create_time)
         * values
         * (?,?,now())
         */
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("insert ");
        stringBuffer.append("into ");
        stringBuffer.append("tb_permission ");
        stringBuffer.append("(role_id,menu_id,per_create_time) ");
        stringBuffer.append("values ");
        stringBuffer.append("(?,?,now()) ");
        return stringBuffer.toString();
    }


    public String getUpdateStr() {
        /**
         * update
         * tb_permission
         * set
         * role_id,menu_id
         * where
         * role_id=?
         * and
         * menu_id=?
         */
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("update ");
        stringBuffer.append("tb_permission ");
        stringBuffer.append("set ");
        stringBuffer.append("role_id,menu_id ");
        stringBuffer.append("where ");
        stringBuffer.append("role_id=? ");
        stringBuffer.append("and ");
        stringBuffer.append("menu_id=? ");
        return stringBuffer.toString();
    }


    public String getDeleteStr() {
        /**
         * delete
         * form
         * tb_permission
         * where
         * role_id=?
         * and
         * menu_id=?
         */
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("delete ");
        stringBuffer.append("form ");
        stringBuffer.append("tb_permission ");
        stringBuffer.append("where ");
        stringBuffer.append("role_id=? ");
        stringBuffer.append("and ");
        stringBuffer.append("menu_id=? ");
        return stringBuffer.toString();
    }

    public String getCountOfUsersStr() {
        /**
         * select
         * count(per_id)
         * from
         * tb_permission
         */
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select ");
        stringBuffer.append("count(per_id) ");
        stringBuffer.append("from ");
        stringBuffer.append("tb_permission ");
        return stringBuffer.toString();
    }

    public String getSelectRoleNamesStr() {
        /**
         * SELECT
         * tb_role.role_name
         * FROM
         * tb_permission
         * JOIN
         * tb_role
         * ON
         * tb_permission.role_id = tb_role.role_id
         * GROUP
         * BY
         * tb_role.role_id
         */
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SELECT ");
        stringBuffer.append("tb_role.role_name ");
        stringBuffer.append("FROM ");
        stringBuffer.append("tb_permission ");
        stringBuffer.append("JOIN ");
        stringBuffer.append("tb_role ");
        stringBuffer.append("ON ");
        stringBuffer.append("tb_permission.role_id = tb_role.role_id ");
        stringBuffer.append("GROUP ");
        stringBuffer.append("BY ");
        stringBuffer.append("tb_permission.role_id ");
        stringBuffer.append("ORDER ");
        stringBuffer.append("BY ");
        stringBuffer.append("tb_role.role_id ");
        return stringBuffer.toString();
    }

    public String getSelectMenuNamesStr() {
        /**
         * SELECT
         * tb_menu.menu_name
         * FROM
         * tb_permission
         * JOIN
         * tb_menu
         * ON
         * tb_permission.menu_id = tb_menu.menu_id
         * GROUP
         * BY
         * tb_menu.menu_id
         */
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SELECT ");
        stringBuffer.append("tb_menu.menu_name ");
        stringBuffer.append("FROM ");
        stringBuffer.append("tb_permission ");
        stringBuffer.append("JOIN ");
        stringBuffer.append("tb_menu ");
        stringBuffer.append("ON ");
        stringBuffer.append("tb_permission.menu_id = tb_menu.menu_id ");
        stringBuffer.append("GROUP ");
        stringBuffer.append("BY ");
        stringBuffer.append("tb_permission.menu_id ");
        stringBuffer.append("ORDER ");
        stringBuffer.append("BY ");
        stringBuffer.append("tb_menu.menu_id ");
        return stringBuffer.toString();
    }

    class PermissionObjectMapper implements IObjectMapper<Permission> {
        /**
         * SELECT
         * tb_role.role_id,
         * tb_role.role_name,
         * tb_menu.menu_id,
         * tb_menu.menu_name,
         * tb_permission.per_create_time
         * FROM
         * tb_permission
         * JOIN tb_role
         * ON tb_permission.role_id = tb_role.role_id
         * JOIN tb_menu
         * ON tb_permission.menu_id = tb_menu.menu_id
         */
        @Override
        public Permission getObjectFromResultSet(ResultSet resultSet) throws SQLException {
            Permission permission = new Permission();
            Role role = new Role();
            role.setroleId(resultSet.getInt("tb_role.role_id"));
            role.setroleName(resultSet.getString("tb_role.role_name"));
            permission.setRole(role);
            Menu menu = new Menu();
            menu.setmenuId(resultSet.getInt("tb_menu.menu_id"));
            menu.setmenuName(resultSet.getString("tb_menu.menu_name"));
            permission.setMenu(menu);
            permission.setperCreateTime(resultSet.getString("tb_permission.per_create_time"));
            return permission;
        }
    }

    @Override
    public Object selectRoleNames() {
        List<String> roleNameList = null;
        try {
            roleNameList = JdbcTemplate.executeQuery(getSelectRoleNamesStr(), new IObjectMapper() {
                @Override
                public Object getObjectFromResultSet(ResultSet resultSet) throws SQLException {
                    String roleName = resultSet.getString("tb_role.role_name");
                    return roleName;
                }
            }, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleNameList;
    }

    @Override
    public Object selectMenuNames() {
        List<String> menuNameList = null;
        try {
            menuNameList = JdbcTemplate.executeQuery(getSelectMenuNamesStr(), new IObjectMapper() {
                @Override
                public Object getObjectFromResultSet(ResultSet resultSet) throws SQLException {
                    String menuName = resultSet.getString("tb_menu.menu_name");
                    return menuName;
                }
            }, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuNameList;
    }

    @Override
    public Object selectPermissions() {
        List<Permission> permissionList = null;
        try {
            permissionList = JdbcTemplate.executeQuery(getBasicQueryStr() + getOrderByAscStr(), new PermissionObjectMapper(), null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return permissionList;
    }

    @Override
    public Object countOfPermissions() {
        List<Integer> countList = null;
        try {
            countList = JdbcTemplate.executeQuery(getCountOfUsersStr(), new IObjectMapper() {
                @Override
                public Object getObjectFromResultSet(ResultSet resultSet) throws SQLException {
                    int count = resultSet.getInt("count(per_id)");
                    return count;
                }
            }, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countList.get(0);
    }

    @Override
    public Object selectPermissionsByPage(int currentPage, int pageSize) {
        List<Permission> permissionList = null;
        try {
            permissionList = JdbcTemplate.executeQuery(getBasicQueryStr() + getOrderByAscStr() + getLimitStr(), new PermissionObjectMapper(), (currentPage - 1) * pageSize, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return permissionList;
    }

    @Override
    public Object selectByRoleId(int roleId) {
        String getSelectByRoleIdStr = "where tb_permission.role_id=? ";
        List<Permission> permissionList = null;
        try {
            permissionList = JdbcTemplate.executeQuery(getBasicQueryStr() + getSelectByRoleIdStr + getOrderByAscStr(), new PermissionObjectMapper(), roleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return permissionList;
    }

    @Override
    public Object selectByMenuId(int menuId) {
        String getSelectByMenuIdStr = "where tb_permission.menu_id=? ";
        List<Permission> permissionList = null;
        try {
            permissionList = JdbcTemplate.executeQuery(getBasicQueryStr() + getSelectByMenuIdStr + getOrderByAscStr(), new PermissionObjectMapper(), menuId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return permissionList;
    }

    @Override
    public Object selectByRoleName(String roleName) {
        String getSelectByRoleNameStr = "where tb_role.role_name=? ";
        List<Permission> permissionList = null;
        try {
            permissionList = JdbcTemplate.executeQuery(getBasicQueryStr() + getSelectByRoleNameStr + getOrderByAscStr(), new PermissionObjectMapper(), roleName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return permissionList;
    }

    @Override
    public Object selectByMenuName(String menuName) {
        /**
         * where tb_menu.menu_name=?
         */
        String getSelectByMenuNameStr = "where tb_menu.menu_name=? ";
        List<Permission> permissionList = null;
        try {
            permissionList = JdbcTemplate.executeQuery(getBasicQueryStr() + getSelectByMenuNameStr + getOrderByAscStr(), new PermissionObjectMapper(), menuName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return permissionList;
    }

    @Override
    public Object selectByRoleIdAndMenuId(int roleId, int menuId) {
        /**
         * where tb_role.role_id=? and tb_menu.menu_id=?
         */
        String getSelectByRoleIdAndMenuIdStr = "where tb_role.role_id=? and tb_menu.menu_id=? ";
        List<Permission> permissionList = null;
        try {
            permissionList = JdbcTemplate.executeQuery(getBasicQueryStr() + getSelectByRoleIdAndMenuIdStr + getOrderByAscStr(), new PermissionObjectMapper(), roleId, menuId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return permissionList;
    }

    @Override
    public Object selectByRoleNameAndMenuName(String roleName, String menuName) {
        return null;
    }

    @Override
    public Object insertByRoleIdAndMenuId(Role role) {
        return null;
    }

    @Override
    public Object insertByRoleNameAndMenuName(String roleName, String menuName) {
        return null;
    }

    @Override
    public Object deleteByRoleIdAndMenuId(int roleId, int menuId) {
        return null;
    }

    @Override
    public Object deleteByRoleNameAndMenuName(String roleName, String menuName) {
        return null;
    }

    @Override
    public Object updateByRoleIdAndMenuId(Role role) {
        return null;
    }

    @Override
    public Object updateByRoleNameAndMenuName(String roleName, String menuNaRoleIdme) {
        return null;
    }
}
