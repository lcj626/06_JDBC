package com.ohgiraffers.understands;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application01 {

    public static void main(String[] args){

//        employee 테이블에서 급여를 가장 많이 받는 사원의 정보를 출력하세요


//        SELECT
//                EMP_ID ,
//                EMP_NAME ,
//                EMAIL ,
//                PHONE
//        FROM EMPLOYEE
//        ORDER BY SALARY DESC
//        LIMIT 1;


        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        try {
            stmt = con.createStatement();

            String query = "SELECT " +
                                "EMP_ID , " +
                                "EMP_NAME , " +
                                "EMAIL , " +
                                "PHONE " +
                              " FROM EMPLOYEE " +
                             " ORDER BY SALARY DESC " +
                             " LIMIT 1; ";

            rset = stmt.executeQuery(query);
            while (rset.next()){
                System.out.println(rset.getString("EMP_ID") + " " + rset.getString("EMP_NAME") + " " + rset.getString("EMAIL") + " " +rset.getString("PHONE"));

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
