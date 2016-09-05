package com.hogan.budget.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hogan.budget.base.bean.DatabaseXML;
import com.hogan.budget.base.global.GlobalContext;
import com.hogan.budget.type.ResourceType;

/**
 * Created by Hogan on 9/5/2016.
 * 本地数据库帮助类
 */
public class DBHelper extends SQLiteOpenHelper {

    private GlobalContext globalContext = GlobalContext.newInstance();

    public DBHelper(Context context) {
        super(context,
                ((DatabaseXML) GlobalContext.newInstance().getGlobalResource()
                        .getResource(ResourceType.DATABASE)).getName(),
                null,
                ((DatabaseXML) GlobalContext.newInstance().getGlobalResource()
                        .getResource(ResourceType.DATABASE)).getLocalVersion());
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        globalContext.setFirstCreateDatabase(true);
        db.execSQL(((DatabaseXML) globalContext.getGlobalResource()
                .getResource(ResourceType.DATABASE)).getInitTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(((DatabaseXML) globalContext.getGlobalResource()
                .getResource(ResourceType.DATABASE)).getUpdateTable());
    }
}
