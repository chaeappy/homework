package vo.cafe;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map.Entry;

public class Pos {
	DrinkDatabase ddb = new DrinkDatabase();
	HashMap<Drink, Integer> inputMap = new HashMap<Drink, Integer>();
//	HashMap<Integer, Integer> inputMap = new HashMap<Integer, Integer>();

	// 메뉴보기
	public void menuMsg() {
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
	public void input(int[] drinkArr) {
		int num = drinkArr[0];
		int howMany = drinkArr[1];
		if (ddb.drinkMap.containsKey(num)) {
			Drink drink = ddb.drinkMap.get(num);
			if (inputMap.containsKey(drink)) {
				int oldHowMany = inputMap.get(drink);
				inputMap.put(drink, oldHowMany + howMany);
			} else {
				inputMap.put(drink, howMany);
			}
		} else {
			System.out.println("입력실패");
		}
	}

	public void printInput() {
		for (Entry<Drink, Integer> entry : inputMap.entrySet()) {
			Drink drink = entry.getKey();
			int howMany = entry.getValue();
			System.out.println(drink.name + " " + howMany);
		}

	}

	// 포스 메뉴삭제
	public void deleteInput(int num) {
		for (Entry<Drink, Integer> entry : inputMap.entrySet()) {
			Drink drink = entry.getKey();
			if (num == drink.num) {
				inputMap.remove(drink);
				return;
			}
		}
	}
	
	
	
	public void pay(String phoneNum, boolean receipt) {
		
	}
		
	public void pay(boolean receipt) {
		
	}
	
	public int sum() {
		int sum = 0;
		for (Entry<Drink, Integer> entry : inputMap.entrySet()) {
			Drink drink = entry.getKey();
			int howMany = entry.getValue();
			sum += drink.price * howMany;
		}
		return sum;
	}
	
	public void cashReceipt(String phoneNum) {
	}

}
