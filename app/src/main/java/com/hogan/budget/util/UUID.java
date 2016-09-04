package com.hogan.budget.util;

/**
 * Created by Hogan on 9/3/2016.
 */
public class UUID {

    /**
     * 获取32位的UUID
     * @return
     */
    public static String getUUID(){
        return java.util.UUID.randomUUID().toString().replace("-","");
    }
}
