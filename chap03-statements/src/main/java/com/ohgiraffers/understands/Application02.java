package com.ohgiraffers.understands;

import static com.ohgiraffers.common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application02 {

    public static void main(String[] args){


        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        try {
            stmt = con.createStatement();

            String query =  "SELECT " +
                                "a.EMP_ID , " +
                                "a.EMP_NAME , " +
                                "a.EMAIL , " +
                                "a.PHONE , " +
                                "b.JOB_NAME " +
                              " FROM EMPLOYEE a " +
                             " JOIN JOB b ON a.JOB_CODE = b.JOB_CODE " +
                             " WHERE a.EMP_NAME = '선동일'; ";

            rset = stmt.executeQuery(query);
            while (rset.next()){
                System.out.println(rset.getString("a.EMP_ID") + " "
                        + rset.getString("a.EMP_NAME") + " "
                        + rset.getString("a.EMAIL") + " "
                        + rset.getString("a.PHONE") + " " + rset.getString("b.JOB_NAME"));
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
