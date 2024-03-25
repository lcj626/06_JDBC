package com.ohgiraffers.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {

    private static Connection con;
    public static Connection getConnection() {

        Properties pros = new Properties();

        try {
            if (con == null || con.isClosed()){
                try {
                    pros.load(new FileReader("src/main/resources/config/connection-info.properties"));
                    //System.out.println(pros.getProperty("driver"));
                    String driver = pros.getProperty("driver");
                    String url = pros.getProperty("url");
                    Class.forName(driver);
                    con = DriverManager.getConnection(url, pros);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    public static Connection getConnection2() {
        Connection con2 = null;
        Properties pros = new Properties();


            try {
                pros.load(new FileReader("src/main/resources/config/connection-info.properties"));
                //System.out.println(pros.getProperty("driver"));
                String driver = pros.getProperty("driver");
                String url = pros.getProperty("url");
                Class.forName(driver);
                con2 = DriverManager.getConnection(url, pros);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        return con2;
    }


    public static void close(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Statement stmt){
        try {
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rset){
        try {
            rset.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





}
