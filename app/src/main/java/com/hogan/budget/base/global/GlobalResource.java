package com.hogan.budget.base.global;

/**
 * Created by Hogan on 9/3/2016.
 * 全局的资源文件载体类(单例)
 */
public class GlobalResource {

    private static final GlobalResource globalResource=new GlobalResource();

    private GlobalResource(){}

    public static GlobalResource newInstance(){
        return globalResource;
    }


}
