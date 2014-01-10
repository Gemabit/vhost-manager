/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemabit.vhostmanager.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author andre
 */
public class DBConnection {

    private Connection conn;
    private static String dbURL = "jdbc:derby://localhost:1527/vhost-db;create=true;user=root;password=1234";
    private static Statement stmt = null;

    public boolean connect() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL);
            return true;
        } catch (Exception except) {
            except.printStackTrace();
            return false;
        }
    }

    public void close() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }
        } catch (SQLException sqlExcept) {
            //sqlExcept.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        try {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery(query);
            //results.close();
            //stmt.close();
            return results;
        } catch (SQLException sqlExcept) {
            throw new SQLException(sqlExcept.getMessage());
        }
    }

    public boolean execute(String query) {
        try {
            stmt = conn.createStatement();
            stmt.execute(query);
            stmt.close();
            return true;
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
            return false;
        }
    }
}
