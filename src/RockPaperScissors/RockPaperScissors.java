package RockPaperScissors;

import java.util.Scanner;
// final을 붙일 것.
// static 이유 없을 시 사용하지 말 것.


public class RockPaperScissors {
	static String win = "당신이 이겼습니다.";
	static String lose = "computer가 이겼습니다.";
	static String same = "비겼습니다.";
	static String line = "--------------------------------------------------";

	static void whoIsWiner(int m, int c) {
		int me = m;
		int computer = c;

		switch (me + computer) {
		case 0:
			System.out.println(same);
			break;
		case 1:
			if (me > computer) {
				System.out.println(win);
			} else {
				System.out.println(lose);
			}
			break;
		case 2:
			if (me == computer) {
				System.out.println(same);
			} else if (me < computer) {
				System.out.println(win);
			} else {
				System.out.println(lose);
			}
			break;
		case 3:
			if (me > computer) {
				System.out.println(win);
			} else {
				System.out.println(lose);
			}
			break;
		case 4:
			System.out.println(same);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int exit = 1;
		while (exit == 1) {
			System.out.println(" --------------[ 가위 바위 보 게임 ]--------------");
			System.out.print("가위 0, 바위 1, 보 2  >> ");
			System.out.println();
			int me = sc.nextInt();
			switch (me) {
			case 0:
				System.out.println("당신 : 가위");
				break;
			case 1:
				System.out.println("당 : 바위");
				break;
			case 2:
				System.out.println("당신 : 보");
				break;
			}

			int computer = ((int) (Math.random() * 10)) / 4;
			switch (computer) {
			case 0:
				System.out.println("computer : 가위");
				break;
			case 1:
				System.out.println("computer : 바위");
				break;
			case 2:
				System.out.println("computer : 보");
				break;
			}

			System.out.println(line);
			System.out.print("결과 : ");
			whoIsWiner(me, computer);
			System.out.println(line);
			System.out.println("종료 0, 재게임 1 >> ");
			
			while (true) {
			exit = sc.nextInt();
				if (exit == 0 || exit == 1) {
					break;
				} else {
					System.out.println("숫자를 다시 확인해주세요 >>");
					continue;
				}
			}
			

		}

	} // main

}
