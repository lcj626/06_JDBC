package com.ohgiraffers.section01.insert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application01 {

    public static void main(String[] args){
        Connection con = getConnection();

        PreparedStatement pstmt = null;
        int result =0;

        ResultSet rset = null;

        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/resources/mapper/menu-query.xml"));
            pstmt = con.prepareStatement(prop.getProperty("insertMenu"));

            pstmt.setString(1, "손가락맛 순대국밥");
            pstmt.setInt(2, 8000);
            pstmt.setInt(3,4);
            pstmt.setString(4,"Y");

            result = pstmt.executeUpdate(); // Update 입력이 완료되면 1 아니면 0을 반환  excuteQuery -> 조회된 결과들(resultSet)을 반환해 주는 것

            System.out.println("결과 " + result);
            //System.out.println(pstmt);

            pstmt = con.prepareStatement("SELECT * FROM TBL_MENU WHERE MENU_NAME = '손가락맛 순대국밥'");
            System.out.println(pstmt);
            rset = pstmt.executeQuery();
            while(rset.next()){
            System.out.println(rset.getString(1) + " " + rset.getString(2) + " " + rset.getString(3));
            }

        } catch (FileNotFoundException e) {//파일경로 오류를 파악하기 위해
            e.printStackTrace();
        } catch (InvalidPropertiesFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(con);
            close(pstmt);
            close(rset);
        }


    }
}
