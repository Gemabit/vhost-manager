/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemabit.vhostmanager.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author andre
 */
public class DBConnection {

    private Connection conn;
    private String queryString = "";
    private static Statement stmt = null;

    public DBConnection() {
        this.queryString = "jdbc:derby://localhost:1527/vhost-db;create=true;user=root;password=1234";
    }

    public DBConnection(String queryString) {
        this.queryString = queryString;
    }

    /**
     * Initializes the connection to the derby database
     *
     * @return boolean
     */
    public boolean connect() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(queryString);
            return true;
        } catch (Exception except) {
            except.printStackTrace();
            return false;
        }
    }

    /**
     * Closes the database connection
     *
     * @return boolean
     */
    public boolean close() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                DriverManager.getConnection(queryString + ";shutdown=true");
                conn.close();
            }

            return true;
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
            return false;
        }
    }

    /**
     * Executes a query and returns it's data (SELECT queries)
     *
     * @param query
     * @return ResultSet
     * @throws SQLException
     */
    public ResultSet executeQuery(String query) throws SQLException {
        stmt = conn.createStatement();
        ResultSet results = stmt.executeQuery(query);
        //results.close();
        //stmt.close();
        return results;
    }

    /**
     * Executes a query (INSERT, UPDATE, DELETE queries)
     * @param query
     * @return boolean
     */
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
