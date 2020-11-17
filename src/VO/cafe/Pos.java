package vo.cafe;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

public class Pos {
	CafeDatabase db = new CafeDatabase();
	HashMap<Drink, Integer> inputMap = new HashMap<Drink, Integer>();
	HashMap<String, Payment> paymentMap = new HashMap<String, Payment>();
	Date date = new Date();
	SimpleDateFormat receipt = new SimpleDateFormat("yyyy년MM월dd일_HH시mm분ss초");
	String rDate = receipt.format(date);
	SimpleDateFormat payment = new SimpleDateFormat("yyyyMMddHHmmss");
	String pDate = payment.format(date);

	// 회원관리 (회원등록 / 회원코드인증)
	boolean signUp(String id) {
		if (db.customerMap.containsKey(id)) {
			return false;
		} else {
			db.customerMap.put(id, new Customer(id));
			return true;
		}
	}
	
	Customer login(String id) {
		if (db.customerMap.containsKey(id)) {
			Customer c = db.customerMap.get(id);
			return c;
		}
		return null; 
	}

	// 메뉴보기
	public void menuMsg() {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int i = 0;
		try {
			for (Entry<Integer, Drink> entry : db.drinkMap.entrySet()) {
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
		if (db.drinkMap.containsKey(num)) {
			Drink drink = db.drinkMap.get(num);
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
		Receipt r = new Receipt(pDate, rDate, inputMap, sum(), str, phoneNum);
		paymentMap.put(pDate, new Payment(pDate, r));
		if (receipt) {
			printReceipt(r);
		}
	}

	public void pay(Customer c, String str, boolean receipt) {
		Receipt r = new Receipt(pDate, rDate, inputMap, sum(), str);
		paymentMap.put(pDate, new Payment(pDate, r));
		if (receipt) {
			printReceipt(r);
		}
	}

	void clear() {
		inputMap.clear();
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

	void printReceipt(Receipt r) {
		System.out.println(r);
	}

	public void cashReceipt(String phoneNum) {
	}

}
