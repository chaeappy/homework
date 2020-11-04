package vo.bankProgram2;

import java.util.Scanner;

public class Main {
	Scanner sc = new Scanner(System.in);
	Manager m = new Manager();
	String line = "========================";
	String enter = "\n";

	void run() {
		m.load();
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
				m.save();
				break;
			// 로그인
			case 2:
				logIn();
				break;
			case 3:
				// 종료
				System.out.println("프로그램 종료");
				return;

			default:
				errorMsg();
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
			errorMsg();
		}
	}

	void signOff() {
		System.out.print("삭제할 아이디 : ");
		sc.nextLine();
		String id = sc.nextLine();
		Customer c = m.signOff(id);
		if (c != null) {
			System.out.println(id + " 회원탈퇴");
			m.save();
		} else {
			errorMsg();
		}
	}

	// 로그인
	void logIn() {
		System.out.print("아이디 : ");
		sc.nextLine();
		String id = sc.nextLine();
		Customer c = m.logIn(id);
		if (c != null) {
			System.out.println(id + "님 환영합니다");
			work(c);
		} else {
			errorMsg();
		}
			return;

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
				m.save();
				break;
			// 출금
			case 2:
				spendMoney(c);
				m.save();
				break;	
			// 이체
			case 3:
				sendMoney(c);
				m.save();
				break;
			// 잔액조회
			case 4:
				System.out.println(c.money);
				break;
			// 로그아웃
			case 5:
				return;
			default:
				errorMsg();
				break;
			}
		}
	}


	// 에러메세지
	void errorMsg() {
		System.out.println("다시 입력하세요.");
	}

	public static void main(String[] args) {
		new Main().run();
	}

}
