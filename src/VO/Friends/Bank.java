package VO.Friends;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
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
			Person ps = new Person(userArr[0], userArr[1]);
		} else {
			System.out.println("삭제할 이름을 입력하세요.");
			userMap.remove(br.readLine());
			System.out.println(userMap.size());
		}
			
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("back.txt"));
		Bank bk = new Bank();
		int input;
		System.out.println("- - - - Bank Program - - - -");
		do {
			System.out.println("[ 1 ] 사용자 등록 / 삭제");
			System.out.println("[ 2 ] 로그인 / 로그아웃");
			System.out.println("[ 3 ] 입금 / 출금 / 송금 / 잔액조회");
			input = bk.sc.nextInt();
			
			switch(input) {
			// 사용자 등록/삭제
			case 1:
				bk.user();
				break;
				//사용자 로그인 로그아웃 : 해쉬맵 
			case 2:
				break;
				//입금/출금
			case 3:
				break;
				// 송금
			case 4:
				break;
				// 잔액조
			case 5:
				break;
			case 6:
				break;
			}
		} while (input != 6);
	} // main

}
