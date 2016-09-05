package com.hogan.budget.base.bean;

import com.hogan.budget.base.BaseResource;

/**
 * Created by Hogan on 9/4/2016.
 * 全局资源类
 */
public class GlobalXML implements BaseResource{

    private String syncHour;
    private String remoteIP;

    public String getSyncHour() {
        return syncHour;
    }

    public void setSyncHour(String syncHour) {
        this.syncHour = syncHour;
    }

    public String getRemoteIP() {
        return remoteIP;
    }

    public void setRemoteIP(String remoteIP) {
        this.remoteIP = remoteIP;
    }
}
