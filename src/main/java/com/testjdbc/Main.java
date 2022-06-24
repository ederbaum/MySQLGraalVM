package com.testjdbc;


import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class Main {


    // TODO: Change to your own connection details
    public static final String MYSQL_JDBC_URL = "jdbc:mysql://abcd.efghijklm.us-east-1.rds.amazonaws.com:3306/database?autoReconnect=true";
    public static final String MYSQL_USERNAME = "root";
    public static final String MYSQL_PASSWORD = "password";


    private void doSQLQuery(final Connection conn) {
        // TODO: Do some SQL query
    }
    private void testJDBC() throws SQLException {
        try(Connection conn = DriverManager.getConnection(MYSQL_JDBC_URL, MYSQL_USERNAME, MYSQL_PASSWORD)){
            doSQLQuery(conn);
        }
    }

    public static void main(String[] args) throws SQLException {
        new Main().testJDBC();
    }


}

