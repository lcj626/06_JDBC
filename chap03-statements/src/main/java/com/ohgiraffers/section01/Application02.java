package com.ohgiraffers.section01;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application02 {

    public static void main(String[] args){
        // 사원 번호에 해당하는 사원의 정보를 조회 한다.
        //1. connection DB
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;


        //2. 쿼리를 만들어야 한다. Statement 객체
        try {
            stmt = con.createStatement();

            String empid = "200"; // 200번째 사원의 이름을 찾아라
            //3. 쿼리를 보낸다.
            rset = stmt.executeQuery("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID =" +empid);
            while (rset.next()){
                System.out.println(rset.getString("EMP_ID") + " " +rset.getString("EMP_NAME"));
            }
            //4. 결과를 받는다. ResultSet
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            close(rset);
            close(con);
            close(stmt);
        }




    }
}
