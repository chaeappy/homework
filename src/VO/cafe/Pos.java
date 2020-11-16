package vo.cafe;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

public class Pos {
	DrinkDatabase ddb = new DrinkDatabase();
	HashMap<Drink, Integer> inputMap = new HashMap<Drink, Integer>();
	HashMap<Date, Payment> paymentMap = new HashMap<Date, Payment>();
	Date date = new Date(System.currentTimeMillis());
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
	
	
	
	public void pay(Customer c, String str, String phoneNum, boolean receipt) {
		if (receipt) {
			System.out.println(new Receipt(date, inputMap, sum(), str, phoneNum));
		} else {
			Receipt r = new Receipt(date, inputMap, sum(), str, phoneNum);
			paymentMap.put(date, new Payment(date, r));
		}
	}
	
	public void pay(Customer c, String str, boolean receipt) {
		if (receipt) {
			System.out.println(new Receipt(date, inputMap, sum(), str));
		} else {
			Receipt r = new Receipt(date, inputMap, sum(), str);
			paymentMap.put(date, new Payment(date, r));
		}
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
