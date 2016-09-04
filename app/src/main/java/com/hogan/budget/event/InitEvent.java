package com.hogan.budget.event;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;

import com.hogan.budget.base.BaseEvent;
import com.hogan.budget.service.InitService;

/**
 * Created by Hogan on 9/3/2016.
 * 初始化界面的事件处理类
 */
public class InitEvent {

    /**
     * 初始化页面中图片的触摸事件
     */
    public static class InitSplashEvent extends BaseEvent implements View.OnTouchListener{

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            Intent initService = new Intent(globalContext.getCurrentActivity(), InitService.class);
            globalContext.getCurrentActivity().startService(initService);
            return false;
        }
    }
}
