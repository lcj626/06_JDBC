package com.ohgiraffers.section01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application01 {

    public static void main(String[] args){
        Connection con = getConnection();

        // statement 쿼리문을 저장하고 실행하는 기능을 하는 용도의 인터페이스
        Statement stmt = null;

        // ResultSet select의 결과 집합을 받아 올 용도의 인터페이스
        ResultSet rset = null;

        try {
            stmt =con.createStatement(); //mysql 을 전달받는 것을 구현 하는 구현체, 쿼리문을 전송

            rset = stmt.executeQuery("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE"); //데이터베이스 서버에 이 명령을 날리겠다 -> 작성한 쿼리 전송
            while(rset.next()){//next() 다음 토큰열을 문자열로 리턴
                System.out.println(rset.getString("EMP_ID")+ " " +rset.getString("EMP_NAME")); //컬럼 라벨명을 문자열로 반환
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            close(con);
            close(stmt);
            close(rset);
        }

    }
}
