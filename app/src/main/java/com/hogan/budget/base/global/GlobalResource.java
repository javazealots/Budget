package com.hogan.budget.base.global;

import com.hogan.budget.base.BaseResource;
import com.hogan.budget.base.BaseType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hogan on 9/3/2016.
 * 全局的资源文件载体类(单例)
 */
public class GlobalResource {

    private static final GlobalResource globalResource = new GlobalResource();
    private Map<BaseType, BaseResource> resourceMap = new HashMap<>();

    private GlobalResource() {
    }

    public static GlobalResource newInstance() {
        return globalResource;
    }

    public void setResource(BaseType xmlType, BaseResource actualResource) {
        resourceMap.put(xmlType, actualResource);
    }

    public BaseResource getResource(BaseType xmlType){
        return resourceMap.get(xmlType);
    }
}
