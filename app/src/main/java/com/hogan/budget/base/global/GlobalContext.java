package com.hogan.budget.base.global;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;

import com.hogan.budget.bean.User;

/**
 * Created by Hogan on 9/3/2016.
 * 全局资源类(单例)
 */
public class GlobalContext {

    private static final GlobalContext globalContext = new GlobalContext();

    //当前活动的activity
    private Activity currentActivity;

    //全局的资源文件接口
    private GlobalResource globalResource;

    //本地数据库对象
    private SQLiteDatabase sqLiteDatabase;

    //是否为第一次创建数据库
    private Boolean firstCreateDatabase;

    //当前运行的user
    private User currentUser;

    private GlobalContext() {
        globalResource = GlobalResource.newInstance();
        firstCreateDatabase = false;
    }

    public static GlobalContext newInstance() {
        return globalContext;
    }

    public GlobalResource getGlobalResource() {
        return globalResource;
    }

    public void setGlobalResource(GlobalResource globalResource) {
        this.globalResource = globalResource;
    }

    public Activity getCurrentActivity() {
        return currentActivity;
    }

    public void setCurrentActivity(Activity currentActivity) {
        this.currentActivity = currentActivity;
    }

    public SQLiteDatabase getSqLiteDatabase() {
        return sqLiteDatabase;
    }

    public void setSqLiteDatabase(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase = sqLiteDatabase;
    }

    public Boolean getFirstCreateDatabase() {
        return firstCreateDatabase;
    }

    public void setFirstCreateDatabase(Boolean firstCreateDatabase) {
        this.firstCreateDatabase = firstCreateDatabase;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
