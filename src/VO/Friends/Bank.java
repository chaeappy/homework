package VO.Friends;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Person {
	String id;
	String name;
	int bankBalance;

	public Person(String id, String name) {
		this.id = id;
		this.name = name;
		bankBalance = 0;
	}

	@Override
	public String toString() {
		return id + ", " + name + ", " + bankBalance;
	}
}

public class Bank {
	Scanner sc = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	HashMap<String, Person> userMap = new HashMap<>();
	String[] personArr = null;
	String line = "============================";

	void user() throws IOException {
		System.out.println("1. 등록 / 2. 삭제");

		if (sc.nextInt() == 1) {
			System.out.println("사용할 아이디와 이름을 입력하세요. ex) 아이디 / 이름");
			String str = br.readLine();
			String[] userArr = str.split("/");
			userMap.put(userArr[0], new Person(userArr[0], userArr[1]));
		} else {
			System.out.println("삭제할 아이디 입력하세요.");
			userMap.remove(br.readLine());
			System.out.println(userMap.size());
		}

	}

	void login() throws IOException {
		System.out.println("아이디를 입력하세요");
		String idGet = br.readLine();
		System.out.println(idGet);
		Loop1: for (Map.Entry<String, Person> entry : userMap.entrySet()) {
			String getKey = entry.getKey() + "";
			System.out.println(getKey == idGet);
			if (getKey == idGet) {
				personArr = (userMap.get(idGet) + "").split(",");
				break Loop1;
			} 
		}
		String secret[] = personArr[1].split("");
		System.out.println(secret[0] + "*" + secret[2] + "님 환영합니다.");
		function();
	}

	void function() {
		System.out.println(line);
		System.out.println("[ 1 ] 입금");
		System.out.println("[ 2 ] 출금");
		System.out.println("[ 3 ] 송금");
		System.out.println("[ 4 ] 잔액조회");
		System.out.println("[ 0 ] 로그아웃");
		int input;
		
		do {
			input = sc.nextInt();
			switch (input) {
			case 1:
				System.out.println("입금할 금액을 입력하세요");
				int saveMoney = sc.nextInt();
				
				Integer.parseInt(personArr[2]);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 0:
				break;
			}
		} while (input != 0);
	}

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("back.txt"));
		Bank bk = new Bank();
		int input;
		System.out.println("- - - - Bank Program - - - -");
		do {
			System.out.println(bk.line);
			System.out.println("[ 1 ] 사용자 등록 / 삭제");
			System.out.println("[ 2 ] 로그인");
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
					System.out.println(bk.line);
					System.out.println("사용자 등록후 로그인하시기 바랍니다");
					System.out.println(bk.line);
				}
				break;
			default:
				System.out.println(bk.line);
				System.out.println("다시 입력하시기 바랍니다.");
				System.out.println(bk.line);
				break;
			}
		} while (input != 6);
	} // main

}