package com.hogan.budget.base.global;

import com.hogan.budget.base.BaseActivity;

/**
 * Created by Hogan on 9/3/2016.
 * 全局资源类(单例)
 */
public class GlobalContext {

    private static final GlobalContext globalContext = new GlobalContext();

    //当前活动的activity
    private BaseActivity currentActivity;

    //全局的资源文件接口
    private GlobalResource globalResource;

    private GlobalContext() {
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

    public BaseActivity getCurrentActivity() {
        return currentActivity;
    }

    public void setCurrentActivity(BaseActivity currentActivity) {
        this.currentActivity = currentActivity;
    }
}
