package com.ohgiraffers.teamproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SignupSystem {

    private List<User> userList;

    public SignupSystem() {
        this.userList = new ArrayList<>();
    }

    public void registerUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("회원가입을 시작합니다.");
        System.out.print("사용자명을 입력하세요: ");
        String username = scanner.nextLine();

        // 패스워드는 보안상의 이유로 안전한 방법으로 저장하는 것이 좋습니다.
        // 실제 프로젝트에서는 해시 함수 등을 사용해야 합니다.
        System.out.print("패스워드를 입력하세요: ");
        String password = scanner.nextLine();

        // 다른 사용자 정보도 입력 받을 수 있음

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);

        // 다른 사용자 정보도 설정

        userList.add(newUser);

        System.out.println("회원가입이 완료되었습니다.");
    }

    public static void main(String[] args) {
        SignupSystem signupSystem = new SignupSystem();
        signupSystem.registerUser();
    }

}
