package vo.cafe;

import java.util.HashMap;
import java.util.Map.Entry;

public class Receipt {
	HashMap<Drink, Integer> map;
	int sum;
	String str;
	String phoneNum;
	String pDate;
	String rDate;
	String stars = "*****************************************";
	
	public Receipt(String pDate, String rDate, HashMap<Drink, Integer> map, int sum, String str) {
		this.pDate = pDate;
		this.rDate = rDate;
		this.map = map;
		this.sum = sum;
		this.str = str;
	}
	
	public Receipt(String pDate, String rDate, HashMap<Drink, Integer> map, int sum, String str, String phoneNum) {
		this.pDate = pDate;
		this.rDate = rDate;
		this.map = map;
		this.sum = sum;
		this.str = str;
		this.phoneNum = phoneNum;
	}

	@Override
	public String toString() {
		 // 현재시간을 가져와 Date형으로 저장한다
		String msg = "";
		for (Entry<Drink, Integer> entry : map.entrySet()) {
			Drink drink = entry.getKey();
			int howMany = entry.getValue();
			msg += drink.name + " " + howMany + "\n";
		}
		return "[ Receipt : " + pDate + " ] \n" + rDate + "\n" + stars + "\n" + msg + sum + "원" + " [ "+ str +"결제 ] ";
	}

	
}
