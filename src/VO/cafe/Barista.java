package vo.cafe;

import java.util.HashMap;
import java.util.Scanner;

//1. 회원가입
//2. 커피 선택
//3. 결제 현금 or 카드
//4. 어떤 커피가 몇개 팔렸는지
//5. 어떤 사람이 어떤 커피를 몇개를 샀는지
//6. 총 매출
//등등
public class Barista {
	Cafe cafe = new Cafe();
	Pos p = new Pos();
	Scanner sc = new Scanner(System.in);
	String stars = "*****************************************";
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
			case 0:
				// 프로그램 종료
				break;

			default:
				break;
			}
		}
	}

	void mainMsg() {
		System.out.println(stars);
		System.out.println("1. 회원등록");
		System.out.println("2. 사원코드 인증");
		System.out.println("0. 프로그램종료");
	}

	void signUp() {
		System.out.println(stars);
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
		System.out.println(stars);
		System.out.print("아이디 : ");
		sc.nextLine();
		String id = sc.nextLine();
		Customer c = cafe.login(id);
		work(c);
	}

	void work(Customer c) {
		while (true) {
			int input = workMsg();
			switch (input) {
			case 1:
				// 주문
				order(c);
				break;
			case 2:
				// 결재취소
				break;
			case 3:
				// 영수증재발행
				break;
			case 4:
				break;
			case 0:
				break;

			default:
				break;
			}
		}
	}

	int workMsg() {
		System.out.println(stars);
		System.out.println("1. 주문");
		System.out.println("2. 결제취소");
		System.out.println("3. 영수증재발행");
		return sc.nextInt();
	}

	void order(Customer c) {
		while (true) {
			int input = orderMsg();
			switch (input) {
			// 메뉴확인
			case 1:
				p.menuMsg();
				break;
			// 메뉴선택
			case 2:
				input();
				p.printInput();
				break;
			// 메뉴삭제
			case 3:
				deleteInput();
				p.printInput();
				break;
			// 결제
			case 4:
				pay();
				break;

			default:
				break;
			
			}
			
//			p.input(drinkArr);
		}

	}
	
	int orderMsg() {
		System.out.println(stars);
		System.out.println("1. 메뉴확인");
		System.out.println("2. 메뉴선택");
		System.out.println("3. 메뉴삭제");
		System.out.println("4. 결제");
		return sc.nextInt();
	}
	
	void input() {
		System.out.println(stars);
		System.out.print("메뉴번호 : ");
		int num = sc.nextInt();
		System.out.print("개수 : ");
		int howMany = sc.nextInt();
		int[] drinkArr = { num, howMany };
		p.input(drinkArr);
	}
	
	void deleteInput() {
		System.out.println(stars);
		System.out.print("(삭제)메뉴번호 : ");
		int num = sc.nextInt();
		p.deleteInput(num);
	}

	
	void pay() {
		System.out.println("1. 현금결제");
		System.out.println("2. 카드결제");
		int input = sc.nextInt();
		switch (input) {
		case 1:
			cash();
			break;
		case 2:
			card();
			break;

		default:
			break;
		}
		p.pay(input);
		
	}
	
	void cash() {
		
	}
	
	void card() {
		
	}

	public static void main(String[] args) {
		new Barista().run();
	}
}