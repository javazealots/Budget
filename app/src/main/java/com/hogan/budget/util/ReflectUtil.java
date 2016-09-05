package com.hogan.budget.util;

import android.util.Log;

import com.hogan.budget.base.global.GlobalConstants;

import java.lang.reflect.Method;

/**
 * Created by Hogan on 9/4/2016.
 * 反射相关工具类
 */
public class ReflectUtil {

    public static void xmlToBeanBySetMethod(Object bean, String value, String name) {
        Method[] methods = bean.getClass().getMethods();
        for (Method m : methods) {
            if (m.getName().equals("set" + name.substring(0, 1).toUpperCase() + name.substring(1))) {
                try {
                    m.invoke(bean, value);
                } catch (Exception e) {
                    Log.e(GlobalConstants.LOG_XML_TO_BEAN, m.getName() + "doesn't exist.");
                }
                break;
            }
        }
    }
}
