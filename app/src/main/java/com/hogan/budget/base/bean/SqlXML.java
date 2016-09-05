package com.hogan.budget.base.bean;

import com.hogan.budget.base.BaseResource;

/**
 * Created by Hogan on 9/4/2016.
 * Sql语句资源
 */
public class SqlXML implements BaseResource {

    private BaseResource userSql;
    private BaseResource budgetSql;

    public SqlXML(BaseResource userSql, BaseResource budgetSql) {
        this.budgetSql = budgetSql;
        this.userSql = userSql;
    }

    public BaseResource getUserSql() {
        return userSql;
    }

    public void setUserSql(BaseResource userSql) {
        this.userSql = userSql;
    }

    public BaseResource getBudgetSql() {
        return budgetSql;
    }

    public void setBudgetSql(BaseResource budgetSql) {
        this.budgetSql = budgetSql;
    }

    /**
     * user表的所有sql语句
     */
    public static class UserSql implements BaseResource {

        private String findByLastLoginDate;

        public String getFindByLastLoginDate() {
            return findByLastLoginDate;
        }

        public void setFindByLastLoginDate(String findByLastLoginDate) {
            this.findByLastLoginDate = findByLastLoginDate;
        }
    }

    /**
     * budget表的所有sql语句
     */
    public static class BudgetSql implements BaseResource {

    }
}
