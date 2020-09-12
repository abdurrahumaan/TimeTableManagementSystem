/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

/**
 *
 * @author Pasindu
 */
public class DB_Connection {

    static Connection c;

    private static void setConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
//        Class.forName("com.mysql.jdbc.Driver");

        c = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/slitttimetable", "slittuser1", "SlitUser123");
//        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sliit_timetable", "root", "");
    }

    public static int iud(String sql) throws Exception {
        int val = 0;
        if (c == null) {
            setConnection();
        }
        val = c.createStatement().executeUpdate(sql);
        return val;
    }

    public static ResultSet search(String sql) throws Exception {
        if (c == null) {
            setConnection();
        }
        return c.createStatement().executeQuery(sql);
    }

    public static Connection getDB() throws Exception {
        if (c == null) {
            setConnection();
        }
        return c;
    }

    public static Connection iudPS() throws Exception {
        if (c == null) {
            setConnection();
        }
        return c;
    }
}
