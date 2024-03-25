package com.ohgiraffers.section01;

import com.ohgiraffers.model.dto.Employee2DTO;
import com.ohgiraffers.model.dto.EmployeeDTO;
import com.ohgiraffers.section01.service.App4Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application04 {

    public static void main(String[] args) {

        /* 데이터를 클래스로 담아서 만들기 */
        /* 객체(object)는 사전적인 정의로 실제 존재하는 것을 말한다.
         * 붕어빵틀 붕어빵 = new 붕어빵틀(); <- 잘못된 예시  붕어빵이라는 이름의 붕어빵틀이 나오는 식
         * 사람 김연아 = new 사람(); <- 옳은 예시  김연아라는 이름의 사람이 나오는것->나중에 속성 부여 해 줄 수 있다
         *
         * 개체 생물학에서의 개체는 하나의 생물체를 뜻한다.
         *
         * EX) 사람 손연재 = new 사람(); <- 인스턴스
         * 사람 이준효 = new 사람(); <- 인스턴스
         * 결혼하다(사람 누구);
         * 손연재.결혼(이준효)
         *
         * 사람.결혼하다(사람) <- 잘못된 것   상호작용은 인스턴스 사이에서 일어난다.
         *
         *
         *
         * -아래의 정답 중 개체를 골라주세요
         * 쥐
         * 미키마우스
         * 제리
         * 사람
         * 손연재
         *
         * 정답 : 미키마우스, 제리, 손연재
         *
         * EX) Employee 테이블 값 출력
         * 200
         * 선동일
         * 621235-1985634
         * sun_di@greedy.com
         * 01099546325
         * D9
         * J1
         * S1
         * 8000000
         * 0.3
         * */

        /*EX) Employee 테이블 값 출력
         * 200
         * 선동일
         * 621235-1985634
         * sun_di@greedy.com
         * 01099546325
         * D9
         * J1
         * S1
         * 8000000
         * 0.3
         * */
//        Employee2DTO nonBuilder = new Employee2DTO();
//        nonBuilder.setEmpId("200");
//        nonBuilder.setEmpName("선동일");
//        // 일일이 다 입력 -> 비효율적 힘듦
//
//
//        EmployeeDTO builderEmp = new EmployeeDTO()
//                    .setEmpNo("621235-1985634").setBonus(0.3).setEmpId("200").setJobCode("j1"); // 한번에 다 가능 효율적 편리
//        //기본 생성자 보다 builder 패턴을 선호 하는 이유 -> 자료값을 수정할 때 유지 보수하기가 편하다 기본생성자로 하면 더 번거로움
//
//        System.out.println(builderEmp);

        Connection con = getConnection();
        App4Service service = new App4Service();

        Statement stmt = null;
        ResultSet rset = null;

        Scanner scanner = new Scanner(System.in);
        System.out.println("조회할 사번을 입력해 주세요");
        String empId = scanner.nextLine();

        String query = " SELECT * FROM EMPLOYEE WHERE EMP_ID = '" + empId + "'";
        System.out.println(query);


        EmployeeDTO emp = null;

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);
            if(rset.next()){
               emp = new EmployeeDTO()
                    .setEmpNo(rset.getString("EMP_NO")).setEmpId(rset.getString("EMP_ID"))
                    .setEmail(rset.getString("EMAIL")).setPhone(rset.getString("PHONE"));
        }

            //service.printEmployee(rset);
            service.print(emp);

    }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con);
            close(rset);
            close(stmt);
        }


    }
}
