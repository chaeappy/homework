package vo.cafe;

import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

public class Receipt {
	HashMap<Drink, Integer> map;
	int sum;
	String str;
	String phoneNum;
	Date date;
	
	public Receipt(Date date, HashMap<Drink, Integer> map, int sum, String str) {
		this.date = date;
		this.map = map;
		this.sum = sum;
		this.str = str;
	}
	
	public Receipt(Date date, HashMap<Drink, Integer> map, int sum, String str, String phoneNum) {
		this.date = date;
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
		return "Receipt : " + date + "\n" + msg + sum + "원" + " [ "+ str +"결제 ] ";
	}

	
}
