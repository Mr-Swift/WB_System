package com.apple.developer.ts.impl;


import com.apple.developer.ts.ITransaction;
import com.apple.developer.util.DbUtil;

import java.sql.SQLException;

@SuppressWarnings("all")
public class TransactionImpl implements ITransaction {

    @Override
    public void begin() {
        try {
            DbUtil.getConnection().setAutoCommit(false);//关闭自动提交
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void commit() {
        try {
            DbUtil.getConnection().commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void rollback() {
        try {
            DbUtil.getConnection().rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
