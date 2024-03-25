package com.ohgiraffers.section01.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class testApp3 {

    public static void main(String[] args) {

        Scanner scr  = new Scanner(System.in);
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int result = 0;
        Properties prop = new Properties();

        System.out.println("업데이트 하실 메뉴를 입력 해주세요");
        String a = scr.nextLine();
        System.out.println("업데이트 하실 가격을 입력 해주세요");
        int b =  scr.nextInt();
        scr.nextLine();
        System.out.println("위치를 입력해 주세요 ");
        String c = scr.nextLine();


        try {
            prop.loadFromXML(new FileInputStream("src/main/resources/mapper/menu-query.xml"));
            pstmt = con.prepareStatement(prop.getProperty("updateMenu"));
            pstmt.setString(1,a);
            pstmt.setInt(2,b);
            pstmt.setString(3,c);


            result = pstmt.executeUpdate();

            if(result ==1){
                System.out.println("성공 했습니다.");
            }else{
                System.out.println("실패 했습니다.");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con);
            close(pstmt);
            scr.close();
        }

    }
}

