package com.hogan.budget.type;

import com.hogan.budget.base.BaseType;

/**
 * Created by Hogan on 9/4/2016.
 * 资源文件的类型(xml文件中的头标签)
 */
public enum ResourceType implements BaseType {

    DATABASE(1, "database"),
    SQL(2,"sql"),
    GLOBAL(3,"global"),
    ;

    private int id;
    private String description;

    ResourceType(int id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
