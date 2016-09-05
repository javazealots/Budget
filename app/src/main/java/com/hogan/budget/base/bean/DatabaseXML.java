package com.hogan.budget.base.bean;

import com.hogan.budget.base.BaseResource;

/**
 * Created by Hogan on 9/4/2016.
 * 数据库资源文件实体类
 */
public class DatabaseXML implements BaseResource {

    private int localVersion;
    private String name;
    private String initTable;
    private String updateTable;

    public int getLocalVersion() {
        return localVersion;
    }

    public void setLocalVersion(String localVersion) {
        this.localVersion = Integer.parseInt(localVersion);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdateTable() {
        return updateTable;
    }

    public void setUpdateTable(String updateTable) {
        this.updateTable = updateTable;
    }

    public String getInitTable() {
        return initTable;
    }

    public void setInitTable(String initTable) {
        this.initTable = initTable;
    }
}
