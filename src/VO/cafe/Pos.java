package vo.cafe;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map.Entry;

public class Pos {
	DrinkDatabase ddb = new DrinkDatabase();
	HashMap<Integer, Integer> inputMap = new HashMap<Integer, Integer>();

	// 메뉴보기
	void menuMsg() {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int i = 0;
		try {
			for (Entry<Integer, Drink> entry : ddb.drinkMap.entrySet()) {
				Drink drink = entry.getValue();
				bw.write(drink + "");
				++i;
				if (i == 4) {
					bw.write("\n");
					bw.write("\n");
					i = 0;
				}
			}
			bw.flush();
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 포스 메뉴입력
	void input(int[] drinkArr) {
		int num = drinkArr[0];
		int howMany = drinkArr[1];
		if (ddb.drinkMap.containsKey(num)) {
			if (inputMap.containsKey(num)) {
				int plus = inputMap.get(num);
				inputMap.put(num, howMany + plus);
			} else {
				inputMap.put(num, howMany);
			}
		} else {
			System.out.println("입력실패");
		}
	}

	void printInput() {
		for (Entry<Integer, Integer> entry : inputMap.entrySet()) {
			int num = entry.getKey();
			int howMany = entry.getValue();
			Drink drink = ddb.drinkMap.get(num);
			String name = drink.name;
			System.out.println(name + " " + howMany);
		}

	}

	// 포스 메뉴삭제
	public void deleteInput(int num) {
		for (Entry<Integer, Integer> entry : inputMap.entrySet()) {
			if (num == entry.getKey()) {
				inputMap.remove(num);
				return;
			}
		}
	}
	
	void pay(int input) {
		printInput();
		String charge = "";
		int total = sum();
		if (input == 1) {
			charge = "현금결제";
		} else if (input == 2) {
			charge = "카드결제";
		}
		System.out.println("Total : " + total + "원");
		System.out.println(charge);
		
	}
	
	int sum() {
		int sum = 0;
		for (Entry<Integer, Integer> entry : inputMap.entrySet()) {
			int num = entry.getKey();
			int howMany = entry.getValue();
			Drink drink = ddb.drinkMap.get(num);
			sum += drink.price * howMany;
		}
		return sum;
	}

}
