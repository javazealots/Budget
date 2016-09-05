package com.hogan.budget.dao.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hogan.budget.base.bean.SqlXML;
import com.hogan.budget.base.global.GlobalContext;
import com.hogan.budget.bean.User;
import com.hogan.budget.dao.UserDao;
import com.hogan.budget.type.ResourceType;

/**
 * Created by Hogan on 9/5/2016.
 */
public class UserDaoImpl implements UserDao {

    private GlobalContext globalContext = GlobalContext.newInstance();
    private SqlXML.UserSql userSql = (SqlXML.UserSql) ((SqlXML)
            globalContext.getGlobalResource().getResource(ResourceType.SQL)).getUserSql();
    private SQLiteDatabase sqLiteDatabase = globalContext.getSqLiteDatabase();

    @Override
    public User findByLastLoginDate() {
        Cursor cursor = sqLiteDatabase.rawQuery(userSql.getFindByLastLoginDate(), null);
        User user = null;
        while (cursor.moveToNext()) {
            user = new User();
            user.setUid(cursor.getString(cursor.getColumnIndex("uid")));
            user.setUsername(cursor.getString(cursor.getColumnIndex("username")));
        }
        return user;
    }
}
