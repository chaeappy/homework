package RockPaperScissors;

import java.util.Scanner;

public class RockPaperScissors2 {
	
	static void whoIsWinner(int me, int computer) {
		String[] strArr = {"Same", "Lose", "Win"};
		String[] strArr2 = {"Win", "Same", "Lose"};
		String[] strArr3 = {"Same", "Win", "Lose"};
		
		System.out.print(">> 게임결과: ");
		switch(me) {
		case 0:
			System.out.println(strArr[me + computer]);
			break;
		case 1:
			System.out.println(strArr2[me * computer]);
			break;
		case 2:
			System.out.println(strArr3[me - computer]);
			break;
		
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] rps = {"가위", "바위", "보"};
		int exit = 1;
		while (exit == 1) {
			System.out.println("=========================");
			System.out.println("[ 가위 바위 보 게임 ]");
			System.out.print("가위 0, 바위 1, 보 2  >> ");
			
			int me = sc.nextInt();
			int computer = ((int)(Math.random() * 10)) / 4;
			System.out.println();
			System.out.println("[ Me ] " + rps[me] + "\s" + "vs" + "\s" + "[ computer ] " + rps[computer]);
			whoIsWinner(me, computer);
			System.out.println();
			System.out.println("종료 0, 재게임 1 >> ");
			exit = sc.nextInt();
		}
	}

}
