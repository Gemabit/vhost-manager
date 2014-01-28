/**
 * vHost - Virtual Host Manager.
 *
 * @copyright © Gemabit <www.gemabit.com> 2014
 * @license Apache License, Version 2.0
 *
 * Copyright 2014 Gemabit
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
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
     *
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
