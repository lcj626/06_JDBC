package main.java.com.ohgiraffers.section02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTemplate {// 공통된 메서드를 제공하는 클래스

    public static Connection getConnection(){// 연결된 인스턴스를 전달
        Connection con = null;
        Properties prop = new Properties(); //properties 가 쓰는 key 값을 맞춰줘야 한다. 처음 커넥션 파일에 정의한 대로 그대로 써야함

        try {
            prop.load(new FileReader("src/main/java/main/java/com/ohgiraffers/config/connection-info.properties"));

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            con = DriverManager.getConnection(url,prop);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    public static void close(Connection con){
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
