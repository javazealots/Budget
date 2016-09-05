package com.hogan.budget.base.global;

import android.app.Activity;

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

    private GlobalContext() {
        globalResource=GlobalResource.newInstance();
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
}
