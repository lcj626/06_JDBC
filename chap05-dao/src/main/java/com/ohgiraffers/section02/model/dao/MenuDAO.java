package com.ohgiraffers.section02.model.dao;

import com.ohgiraffers.section02.model.dto.MenuDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import static com.ohgiraffers.common.JDBCTemplate.*;
public class MenuDAO {


    private Properties prop = new Properties();

    // public MenuDAO(){ -> 기본 생성자 만들면 파일을 가져오기 힘듦
    //}

    public MenuDAO(String url) {
        try {
            prop.loadFromXML(new FileInputStream(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int selectLastMenuCode(Connection con){
        Statement statement = null;
        ResultSet rset = null;
        int maxCode = 0;

        String query = prop.getProperty("selectLastMenuCode");
        try {
            statement = con.createStatement();
            rset = statement.executeQuery(query);
            if(rset.next()){
                maxCode = rset.getInt("MAX(A.MENU_CODE)");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con);
            close(statement);
            close(rset);
        }
        return maxCode;
    }

    public List<Map<Integer, String>> selectAllCategory(Connection con){
        Statement stmt = null;
        ResultSet rset = null;
        List<Map<Integer, String>> categoryList = new ArrayList<>();
        String query = prop.getProperty("selectAllCategoryList");
        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);
            if(rset.next()){ // if냐 while이냐는 동작에 문제 없으나 메모리 낭비를 하냐 안하냐 이다
                Map<Integer, String> category = new HashMap<>();

                category.put(rset.getInt("CATEGORY_CODE"), rset.getString("CATEGORY_NAME")); // 키, 밸류
                categoryList.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con);
            close(stmt);
            close(rset);
        }
        return categoryList;
    }

    public int insertMenu(Connection con, MenuDTO menuDTO){
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("insertMenu");
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, menuDTO.getMenuName());
            pstmt.setInt(2, menuDTO.getPrice());
            pstmt.setString(3, menuDTO.getCategoryCode());
            pstmt.setString(4, menuDTO.getStatus());
            result = pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con);
            close(pstmt);
        }
        return result;
    }


}
