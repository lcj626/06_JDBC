package main.java.com.ohgiraffers.section01.connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Application03 {

    public static void main(String[] args){
        Properties prop = new Properties();
        Connection con = null;

        try {
            prop.load(new FileReader("src/main/java/main/java/com/ohgiraffers/config/connection-info.properties"));
            // System.out.println(prop.getProperty("driver"));
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url"); //db 접속 경로
            String user = prop.getProperty("user");// db 아이디
            String password = prop.getProperty("password"); //id의 비밀번호

            //DriverManager.getConnection은 매개변수로 url,user(db id), password(id의 비밀번호)를 전달해 주면
            //연결하려고 하는 diver를 찾아서 해당 db서버의 데이터 베이스에 연결하는 메서드이다.

            // 연결해서 연결돼있는 객체를 con에 담는다. 실질적으로 가져오는 것 con

            con = DriverManager.getConnection(url, user, password);
            System.out.println(con);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

}
