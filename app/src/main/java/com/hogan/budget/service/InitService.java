package com.hogan.budget.service;

import android.content.Intent;

import com.hogan.budget.base.BaseService;
import com.hogan.budget.base.global.GlobalConstants;
import com.hogan.budget.util.UUID;
import com.hogan.budget.view.LoadingDialog;

/**
 * Created by Hogan on 9/3/2016.
 * 初始化页面的服务
 */
public class InitService extends BaseService {

    //该服务的ID
    private String serviceId;

    //页面中的圆形等待框
    private LoadingDialog initLoading;

    public InitService() {
        super(GlobalConstants.SERVICE_INIT_NAME);
        serviceId = UUID.getUUID();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        
        //等待框
        new Thread(new Runnable() {
            @Override
            public void run() {
                initLoading = new LoadingDialog(globalContext.getCurrentActivity());
                initLoading.show();
            }
        }).start();

        //加载配置文件
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        //更新本地数据
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }

    @Override
    public String getServiceId() {
        return this.serviceId;
    }
}
