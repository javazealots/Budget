package com.hogan.budget.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.hogan.budget.R;
import com.hogan.budget.base.BaseActivity;
import com.hogan.budget.event.InitEvent;

/**
 * 初始化界面
 */
public class InitActivity extends BaseActivity {

    //初始化界面的图片
    private ImageView initImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        globalContext.setCurrentActivity(this);
    }

    @Override
    public void componentInit() {
        setContentView(R.layout.activity_init);
        initImage = getImageView(R.id.init);
    }

    @Override
    public void componentEvent() {
        initImage.setOnTouchListener(new InitEvent.InitSplashEvent());
    }

}
