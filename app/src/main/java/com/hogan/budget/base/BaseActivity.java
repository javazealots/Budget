package com.hogan.budget.base;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.hogan.budget.base.global.GlobalContext;

/**
 * 基础的Activity
 */
public abstract class BaseActivity extends Activity {

    public GlobalContext globalContext=GlobalContext.newInstance();

    /**
     * 获取ImageView组件
     *
     * @param id
     * @return
     */
    public ImageView getImageView(int id) {
        return (ImageView) findViewById(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        componentInit();
        componentEvent();
    }

    /**
     * 组件初始化操作
     */
    public abstract void componentInit();

    /**
     * 组件的事件操作
     */
    public abstract void componentEvent();
}
