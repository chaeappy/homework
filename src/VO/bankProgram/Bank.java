package vo.bankProgram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bank {
	Scanner sc = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = null;
	static final File file = new File("bankCustomer.txt");
	HashMap<String, Person> userMap = new HashMap<>();
	String[] personArr = null;
	static final String line = "============================";

	void user() throws IOException {
		System.out.println("1. 등록 / 2. 삭제");
		int input = sc.nextInt();
		String[] userArr;
		switch (input) {
		case 1:
			while (true) {
				System.out.println(line);
				System.out.println("사용할 아이디와 이름을 입력하세요. ex) 아이디 / 이름");
				String str = br.readLine().trim().replace(" ", "");
				userArr = str.split("/");
				if (!userMap.containsKey(userArr[0])) {
					userMap.put(userArr[0], new Person(userArr[0], userArr[1], 0));
					bw = new BufferedWriter(new FileWriter(file));
					for (Map.Entry<String, Person> entry : userMap.entrySet()) {
						Person values = entry.getValue();
						bw.write(values + "\n");
					}
					bw.flush();
					bw.close();
					break;
				} else {
					System.out.println("사용할 수 없는 아이디입니다.");
				}
			}
			break;
		case 2:
			System.out.println("삭제할 아이디 입력하세요.");
			userMap.remove(br.readLine());
			bw = new BufferedWriter(new FileWriter(file));
			for (Map.Entry<String, Person> entry : userMap.entrySet()) {
				Person values = entry.getValue();
				bw.write(values + "\n");
			}
			bw.flush();
			bw.close();
			break;
		}
	}

	void login() throws IOException {
		System.out.println("아이디를 입력하세요");
		String idGet = br.readLine();
		Loop1: for (Map.Entry<String, Person> entry : userMap.entrySet()) {
			String getKey = entry.getKey() + "";
			if (getKey.equals(idGet)) {
				personArr = (userMap.get(idGet) + "").replace(" ", "").split(",");
				System.out.println();
				break Loop1;
			}
		}
		String secret[] = personArr[1].split("");
		if (secret.length == 3) {
			System.out.println(secret[0] + "*" + secret[2] + "님 환영합니다.");
		} else {
			String star = "*";
			for (int i = 0; i < secret.length - 2; i++) {
				star += "*";
			}

			System.out.println(secret[0] + star + "님 환영합니다.");
		}
		function();
	}

	void function() throws IOException {
		int input;

		do {
			System.out.println(line);
			System.out.println("[ 1 ] 입금");
			System.out.println("[ 2 ] 출금");
			System.out.println("[ 3 ] 송금");
			System.out.println("[ 4 ] 잔액조회");
			System.out.println("[ 0 ] 로그아웃");
			input = sc.nextInt();
			switch (input) {
			case 1:
				System.out.println("현재잔액 : " + userMap.get(personArr[0]).getBankBalance());
				System.out.println("입금할 금액을 입력하세요");
				int saveMoney = sc.nextInt();
				userMap.get(personArr[0]).setBankBalance(saveMoney);
				System.out.println("입금 후 총 금액 : " + userMap.get(personArr[0]).getBankBalance());
				bw = new BufferedWriter(new FileWriter(file));
				for (Map.Entry<String, Person> entry : userMap.entrySet()) {
					Person values = entry.getValue();
					bw.write(values + "\n");
				}
				bw.flush();
				bw.close();
				break;
			case 2:
				System.out.println("출금가능 금액 : " + userMap.get(personArr[0]).getBankBalance());
				System.out.println("출금할 금액을 입력하세요");
				int spendMoney = sc.nextInt();
				if (spendMoney <= userMap.get(personArr[0]).getBankBalance()) {
					userMap.get(personArr[0]).setBankBalance(spendMoney * -1);
					System.out.println("출금 후 잔액 : " + userMap.get(personArr[0]).getBankBalance());
					bw = new BufferedWriter(new FileWriter(file));
					for (Map.Entry<String, Person> entry : userMap.entrySet()) {
						Person values = entry.getValue();
						bw.write(values + "\n");
					}
					bw.flush();
					bw.close();
				} else {
					System.out.println("잔액이 부족합니다.");
				}
				break;
			case 3:
				System.out.println("이체가능 금액 : " + userMap.get(personArr[0]).getBankBalance());
				System.out.println("이체할 대상의 아이디와 금액을 입력하세요 ex) 아이디 / 금액(숫자)");
				String[] sendArr = br.readLine().trim().replace(" ", "").split("/");
				if (Integer.parseInt(sendArr[1]) <= userMap.get(personArr[0]).getBankBalance()) {
					userMap.get(personArr[0]).setBankBalance(Integer.parseInt(sendArr[1]) * -1);
					userMap.get(sendArr[0]).setBankBalance(Integer.parseInt(sendArr[1]));
					System.out.println("정상적으로 이체되었습니다.");
					System.out.println("이체 후 잔액 : " + userMap.get(personArr[0]).getBankBalance());
					bw = new BufferedWriter(new FileWriter(file));
					for (Map.Entry<String, Person> entry : userMap.entrySet()) {
						Person values = entry.getValue();
						bw.write(values + "\n");
					}
					bw.flush();
					bw.close();
				} else {
					System.out.println("잔액이 부족합니다.");
				}
				break;
			case 4:
				System.out.println(personArr[0] + "님의 계좌 총 금액 : " + userMap.get(personArr[0]).getBankBalance());
				break;
			case 0:
				break;
			}
		} while (input != 0);
	}

	public static void main(String[] args) throws IOException {
		int input;
		String msg;
		Bank bk = new Bank();

		BufferedReader brForFile;

		String[] userArr;

		if (file.exists()) {
			brForFile = new BufferedReader(new FileReader(file));
			while ((msg = brForFile.readLine()) != null) {
				userArr = msg.replace(" ", "").split(",");
				bk.userMap.put(userArr[0], new Person(userArr[0], userArr[1], Integer.parseInt(userArr[2])));
			}
		} else if (!file.exists()) {
			file.createNewFile();
		}

		System.out.println("- - - - Bank Program - - - -");
		do {
			System.out.println(line);
			System.out.println("[ 1 ] 사용자 등록 / 삭제");
			System.out.println("[ 2 ] 로그인");
			System.out.println("[ 0 ] 프로그램 종료");
			input = bk.sc.nextInt();

			switch (input) {
			// 사용자 등록/삭제
			case 1:
				bk.user();
				break;
			// 사용자 로그인 로그아웃 : 해쉬맵
			case 2:
				if (bk.userMap.size() != 0) {
					bk.login();
				} else if (bk.userMap.size() == 0) {
					System.out.println(line);
					System.out.println("사용자 등록후 로그인하시기 바랍니다");
					System.out.println(line);
				}
				break;
			case 0:
				System.out.println("이용해주셔서 감사합니다.");
				bk.bw = new BufferedWriter(new FileWriter(file));
				for (Map.Entry<String, Person> entry : bk.userMap.entrySet()) {
					Person values = entry.getValue();
					bk.bw.write(values + "\n");
				}
				bk.bw.flush();
				bk.bw.close();
				break;
			default:
				System.out.println(line);
				System.out.println("다시 입력하시기 바랍니다.");
				System.out.println(line);
				break;
			}
		} while (input != 0);
	} // main

}