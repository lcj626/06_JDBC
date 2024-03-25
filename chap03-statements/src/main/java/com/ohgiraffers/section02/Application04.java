package com.ohgiraffers.section02;

import com.ohgiraffers.model.dto.EmployeeDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application04 {

    public static void main(String[] args){
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        EmployeeDTO emp = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("성씨를 입력해 주세요");
        String empName = scanner.nextLine();

        Properties prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/employee-query.xml")); // 파일을 읽어서 stream 객체로 나열 시킨다.
            pstmt = con.prepareStatement(prop.getProperty("selectEmpByfamilyName")); // employee-query.xml 파일에서 쿼리 보기 편하게 작성하고 가져오기만 하면 됨
            //인텔리제이에서 직접 쿼리 작성하면 불편하고 관리가 어려움
            pstmt.setString(1,empName);
            rset = pstmt.executeQuery();

            while (rset.next()){
                System.out.println(rset.getString(1) + " " + rset.getString(2) + " " + rset.getString(3));
            }
            //System.out.println(prop.getProperty("selectEmpByfamilyName"));
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
