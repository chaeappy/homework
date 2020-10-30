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
	String name;
	String id;
	int bankBalance;
	
	public Person(String name, String id) {
		this.name = name;
		this.id = id;
	}
}

public class Bank {
	Scanner sc = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	HashMap<String, String> userMap = new HashMap<>();
	
	void user() throws IOException {
		System.out.println("1. 등록 / 2. 삭제");
		
		if (sc.nextInt() == 1) {
			System.out.println("이름과 아이디를 입력하세요. ex) 이름 / 아이디");
			String str = br.readLine();
			String[] userArr = str.split("/");
			userMap.put(userArr[0], userArr[1]);
		} else {
			System.out.println("삭제할 이름을 입력하세요.");
			userMap.remove(br.readLine());
			System.out.println(userMap.size());
		}
			
		
	}
	
	void login() throws IOException {
		System.out.println("아이디를 입력하세요");
		String nameGet = br.readLine();
		Loop1 : for(Map.Entry<String, String> entry : userMap.entrySet()) {
			String getKey = entry.getKey();
			if (userMap.get(getKey).equals(nameGet)) {
				String loginName[] = getKey.split("");
				System.out.println(loginName[0] + "*" + loginName[2] + "님 환영합니다.");
				break Loop1;
			}
		}
		function();
	}
	
	void function() {
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("back.txt"));
		Bank bk = new Bank();
		int input;
		String line = "-----------------------------------";
		System.out.println("- - - - Bank Program - - - -");
		do {
			System.out.println("[ 1 ] 사용자 등록 / 삭제");
			System.out.println("[ 2 ] 로그인");
			input = bk.sc.nextInt();
			
			switch(input) {
			// 사용자 등록/삭제
			case 1:
				bk.user();
				break;
				//사용자 로그인 로그아웃 : 해쉬맵 
			case 2:
				if (bk.userMap.size() != 0) {
					bk.login();
				} else if (bk.userMap.size() == 0) {
					System.out.println(line);
					System.out.println("사용자 등록후 로그인하시기 바랍니다");
					System.out.println(line);
				}
				break;
			default :
				System.out.println(line);
				System.out.println("다시 입력하시기 바랍니다.");
				System.out.println(line);
				break;
			}
		} while (input != 6);
	} // main

}
