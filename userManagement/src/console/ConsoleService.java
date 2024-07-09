package console;

import java.util.Scanner;

public class ConsoleService {
    Scanner scanner = new Scanner(System.in);
    public void showMenu() {
        System.out.println("1: 회원가입 / 2: 로그인 / 3: 회원정보 수정 / 4: 탈퇴 / 0: 종료");
    }

    public void showRegisterMessage() {
        System.out.println("가입하실 아이디와 비밀번호를 (띄어쓰기로 구분하여) 입력하세요.");
    }

    public void showLoginMessage() {
        System.out.println("로그인하실 아이디와 비밀번호를 (띄어쓰기로 구분하여) 입력하세요.");
    }

    public void showUpdateMessage() {
        System.out.println("수정하실 아이디와 비밀번호를 (띄어쓰기로 구분하여) 입력하세요.");
    }

    public void showWecomeMessage(String userName) {
        System.out.println(String.format("%s님 가입을 환영합니다.", userName));
    }

    public void warningLoginMessage() {
        System.out.println("로그인 상태가 아닙니다.");
    }

    public void showUpdateCompleteMessage(String userName) {
        System.out.println(String.format("%s님 회원정보 수정 완료", userName));
    }

    public void showEmitMessage(String userName) {
        System.out.println(String.format("%s님 탈퇴 완료", userName));
    }


    public String receiveMessage() {
        System.out.print("입력: ");
        return scanner.nextLine();
    }
}
