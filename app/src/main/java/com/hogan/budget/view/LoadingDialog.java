package com.hogan.budget.view;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Hogan on 9/3/2016.
 * 统一的圆形等待框
 */
public class LoadingDialog extends ProgressDialog {

    public LoadingDialog(Context context) {
        super(context);
        setProgressStyle(ProgressDialog.STYLE_SPINNER);
        setCancelable(false);
    }
}
