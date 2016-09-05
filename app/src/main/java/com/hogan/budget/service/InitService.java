package com.hogan.budget.service;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

import com.hogan.budget.base.BaseResource;
import com.hogan.budget.base.BaseService;
import com.hogan.budget.base.bean.DatabaseXML;
import com.hogan.budget.base.bean.GlobalXML;
import com.hogan.budget.base.bean.SqlXML;
import com.hogan.budget.base.global.GlobalConstants;
import com.hogan.budget.base.global.GlobalResource;
import com.hogan.budget.bean.User;
import com.hogan.budget.dao.UserDao;
import com.hogan.budget.dao.impl.UserDaoImpl;
import com.hogan.budget.type.ResourceType;
import com.hogan.budget.util.DBHelper;
import com.hogan.budget.util.NetHelper;
import com.hogan.budget.util.UUID;
import com.hogan.budget.util.XMLParse;
import com.hogan.budget.view.LoadingDialog;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Hogan on 9/3/2016.
 * 初始化页面的服务
 */
public class InitService extends BaseService {

    //该服务的ID
    private String serviceId;

    //配置文件加载进度
    private boolean resourceLoadingProgress = false;

    //数据更新进度
    private boolean dataUpdateLoadingProgress = false;

    //页面中的圆形等待框
    private LoadingDialog initLoading;

    public InitService() {
        super(GlobalConstants.SERVICE_INIT_NAME);
        serviceId = UUID.getUUID();
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        //等待框
        initLoading = new LoadingDialog(globalContext.getCurrentActivity());
        initLoading.show();

        //加载配置文件
        new Thread(new Runnable() {
            @Override
            public void run() {

                InputStream in = null;
                try {
                    //加载数据库xml资源
                    in = globalContext.getCurrentActivity().getAssets().open(GlobalConstants.PATH_DATABASE);
                    BaseResource databaseXML = XMLParse.parse(in, ResourceType.DATABASE, DatabaseXML.class);

                    //加载sql资源
                    in = globalContext.getCurrentActivity().getAssets().open(GlobalConstants.PATH_SQL);
                    BaseResource userSql = XMLParse.parse(in, ResourceType.SQL, SqlXML.UserSql.class);
                    BaseResource budgetSql = XMLParse.parse(in, ResourceType.SQL, SqlXML.BudgetSql.class);
                    BaseResource sqlXML = new SqlXML(userSql, budgetSql);

                    //加载全局xml资源
                    in = globalContext.getCurrentActivity().getAssets().open(GlobalConstants.PATH_GLOBAL);
                    BaseResource globalXML = XMLParse.parse(in, ResourceType.GLOBAL, GlobalXML.class);

                    GlobalResource globalResource = globalContext.getGlobalResource();
                    globalResource.setResource(ResourceType.DATABASE, databaseXML);
                    globalResource.setResource(ResourceType.SQL, sqlXML);
                    globalResource.setResource(ResourceType.GLOBAL, globalXML);

                    resourceLoadingProgress = true;
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (in != null) {
                            in.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

        //查询本地/远程用户数据(减少登录时联网校验的时间)
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    if (globalContext.getGlobalResource().getResource(ResourceType.DATABASE) != null) {
                        SQLiteDatabase sqLiteDatabase = new DBHelper(globalContext.getCurrentActivity()).getWritableDatabase();
                        globalContext.setSqLiteDatabase(sqLiteDatabase);
                        if (!globalContext.getFirstCreateDatabase()) {//并非第一次创建数据库
                            //本地数据库中有无用户的数据(用户安装后没有直接使用)
                            UserDao userDao = new UserDaoImpl();
                            User user = userDao.findByLastLoginDate();
                            if (user != null) {
                                globalContext.setCurrentUser(user);
                                GlobalXML globalXML = (GlobalXML) globalContext.getGlobalResource().getResource(ResourceType.GLOBAL);
                                NetHelper.request(globalXML.getRemoteIP(), GlobalConstants.REQUEST_METHOD_POST, null);
                            } else {
                                GlobalXML globalXML = (GlobalXML) globalContext.getGlobalResource().getResource(ResourceType.GLOBAL);
                                NetHelper.request(globalXML.getRemoteIP(), GlobalConstants.REQUEST_METHOD_POST, null);
                            }
                        } else {
                            //第一次创建数据库
                        }
                        dataUpdateLoadingProgress = true;
                        break;
                    }
                }
            }
        }).start();

        //循环检查加载进度，完成后退出等待框并进入登录页面
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    if (resourceLoadingProgress && dataUpdateLoadingProgress) {
                        initLoading.dismiss();
                        break;
                    }
                }
            }
        }).start();
    }

    @Override
    public String getServiceId() {
        return this.serviceId;
    }
}
