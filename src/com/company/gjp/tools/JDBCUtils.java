package com.company.gjp.tools;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class JDBCUtils {
    private static final BasicDataSource dataSource = new BasicDataSource();

    static {
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/gjp?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
        dataSource.setMaxActive(10);
        dataSource.setMaxIdle(5);
        dataSource.setMinIdle(2);
        dataSource.setInitialSize(10);
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
