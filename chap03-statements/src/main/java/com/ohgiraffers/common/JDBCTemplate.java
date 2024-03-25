package com.ohgiraffers.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {//common package는 별도의 필드 없이 static 만 씀

    public static Connection getConnection(){
        Connection con =null;

        Properties prop = new Properties();
        try {
            prop.load(new FileReader("src/main/java/com/ohgiraffers/config/connection-info.properties"));
            String driver = prop.getProperty("driver"); //connection-info.properties 파일에 있는 driver(com.mysql.cj.jdbc.Driver) 키 값을 가져온 것
            String url = prop.getProperty("url"); // connection-info.properties 파일에 있는 url(jdbc:mysql://localhost:3306/employee) 키 값을 가져 온 것

            con = DriverManager.getConnection(url, prop);

        } catch (FileNotFoundException e) {//무엇때문에 에러난건지 찾기위해 굳이 filnotexception 만들었다
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void close(Connection con){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement stmt){
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rset){
        try {
            rset.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
