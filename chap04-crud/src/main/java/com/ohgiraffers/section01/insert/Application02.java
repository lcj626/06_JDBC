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
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application02 {

    public static void main(String[] args){
        /*
        * 사용자가 메뉴를 등록 할 수 있도록 만들어 주세요
        * 등록이 완료되면 메뉴등록 성공 실패하면 다시 등록을 요청해주세요
        * */

            Scanner scr  = new Scanner(System.in);
            Connection con = getConnection();
            PreparedStatement pstmt = null;
            int result = 0;
            Properties prop = new Properties();

        System.out.println("등록하실 메뉴를 입력 해주세요");
        String a = scr.nextLine();
        System.out.println("가격을 입력 해주세요");
        int b =  scr.nextInt();
        System.out.println("타입을 입력 해주세요");
        int c = scr.nextInt();

        try {
            prop.loadFromXML(new FileInputStream("src/main/resources/mapper/menu-query.xml"));
            pstmt = con.prepareStatement(prop.getProperty("insertMenu"));
            pstmt.setString(1,a);
            pstmt.setInt(2,b);
            pstmt.setInt(3,c);
            pstmt.setString(4,"Y");

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
