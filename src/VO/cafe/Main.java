package vo.cafe;

import java.util.Scanner;

//1. 회원가입
//2. 커피 선택
//3. 결제 현금 or 카드
//4. 어떤 커피가 몇개 팔렸는지
//5. 어떤 사람이 어떤 커피를 몇개를 샀는지
//6. 총 매출
//등등
public class Main {
	Cafe cafe = new Cafe();
	Scanner sc = new Scanner(System.in);
	// 회원등록
	// 사원코드 인증
	// 메뉴선택
	// 결재

	void run() {
		while (true) {
			mainMsg();
			int input = sc.nextInt();
			switch (input) {
			case 1:
				signUp();
				break;
			case 2:
				logIn();
				break;
			case 3:

				break;
			case 4:

				break;

			default:
				break;
			}
		}
	}

	void mainMsg() {
		System.out.println("1. 회원등록");
		System.out.println("2. 사원코드 인증");
		System.out.println("3. 결재취소");
		System.out.println("0. 프로그램종료");
	}

	void signUp() {
		System.out.print("아이디 : ");
		sc.nextLine();
		String id = sc.nextLine();
		System.out.println("성별 1. 남자 / 2. 여자");
		int gender = sc.nextInt();
		if (gender == 1 || gender == 2) {
			if (cafe.signUp(id, gender)) {
				System.out.println("회원가입 성공");
			}
		} else {
			return;
		}
	}

	void logIn() {
		System.out.print("아이디 : ");
		sc.nextLine();
		String id = sc.nextLine();
		cafe.login(id);
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
