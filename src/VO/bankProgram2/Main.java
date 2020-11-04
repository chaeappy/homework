package vo.bankProgram2;

import java.util.Scanner;

public class Main {
	Scanner sc = new Scanner(System.in);
	Manager m = new Manager();
	String line = "========================";
	String enter = "\n";

	void run() {
		while (true) {
			int input = showMainMsg();
			switch (input) {
			// 회원
			case 1:
				int number = customerMsg();
				if (number == 1) {
					signUp();
				} else if (number == 2) {
					signOff();
				}
				break;
			// 로그인
			case 2:
				Customer c = logIn();
				if (c != null) {
					work(c);
				}
				break;
			case 3:
				// 종료
				break;

			default:
				break;
			}
		}

	}

	// 메인메세지
	int showMainMsg() {
		System.out.println(line);
		System.out.println("1. 회원관리");
		System.out.println("2. 로그인");
		System.out.println("3. 프로그램 종료");
		return sc.nextInt();
	}

	int customerMsg() {
		System.out.println(line);
		System.out.println("1. 회원가입");
		System.out.println("2. 회원탈퇴");
		return sc.nextInt();
	}

	// 회원가입
	void signUp() {
		System.out.print("아이디 : ");
		sc.nextLine();
		String id = sc.nextLine();
		if (m.signUp(id)) {
			System.out.println(id + " 회원가입 성공");
		} else {
			System.out.println("회원가입 실패");
			return;
		}
	}

	void signOff() {
		System.out.print("삭제할 아이디 : ");
		sc.nextLine();
		String id = sc.nextLine();
		Customer c = m.signOff(id);
		if (c != null) {
			System.out.println(id + " 회원탈퇴");
		} else {
			System.out.println("회원탈퇴 실패");
			return;
		}
	}

	// 로그인
	Customer logIn() {
		System.out.print("아이디 : ");
		sc.nextLine();
		String id = sc.nextLine();
		Customer c = m.logIn(id);
		if (c != null) {
			System.out.println(id + "님 환영합니다");
		} else {
			System.out.println("로그인 실패");
		}
		return c;

	}
	
	void saveMoney(Customer c) {
		System.out.print("입금할 금액 : ");
		int money = sc.nextInt();
		c.saveMoney(money);
	}
	
	void spendMoney(Customer c) {
		System.out.print("출금할 금액 : ");
		int money = sc.nextInt();
		c.spendMoney(money);
	}
	
	void sendMoney(Customer c) {
		System.out.print("받는사람 아이디 : ");
		sc.nextLine();
		String id = sc.nextLine();
		System.out.print("금액 : ");
		int money = sc.nextInt();
		Customer other = (m.sendMoney(id));
		if (other != null) {
			c.sendMoney(c, other, money);
		} else {
			return;
		}
		
	}

	// 뱅크기능메세지
	int showBankMsg() {
		System.out.println(line);
		System.out.println("1. 입금");
		System.out.println("2. 출금");
		System.out.println("3. 이체");
		System.out.println("4. 잔액조회");
		System.out.println("5. 로그아웃");
		return sc.nextInt();
	}

	// 은행업무
	void work(Customer c) {
		while (true) {
			int input = showBankMsg();
			switch (input) {
			// 입금
			case 1:
				saveMoney(c);
				break;
			// 출금
			case 2:
				spendMoney(c);
				break;	
			// 이체
			case 3:
				sendMoney(c);
				break;
			// 잔액조회
			case 4:
				System.out.println(c.money);
				break;
			// 종료
			case 5:

				break;

			default:
				break;
			}
		}
	}

	// 입금
	// 출금
	// 이체
	// 잔액조회

	// 프로그램종료
	void exit() {

	}

	public static void main(String[] args) {
		new Main().run();
	}

}
