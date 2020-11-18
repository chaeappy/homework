package vo.cafe;

import java.util.HashMap;
import java.util.Map.Entry;

public class Payment {
	HashMap<Drink, Integer> paymentMap = new HashMap<Drink, Integer>();
	String date;
	Receipt r;
	
	public Payment(String date, Receipt r) {
		this.date = date;
		this.r = r;
		for (Entry<Drink, Integer> entry : r.map.entrySet()) {
			Drink drink = entry.getKey();
			int howMany = entry.getValue();
			
			if (paymentMap.containsKey(drink)) {
				int oldHowMany = paymentMap.get(drink);
				paymentMap.put(drink, oldHowMany + howMany);
			} else {
				paymentMap.put(drink, howMany);
			}
			System.out.println(drink + " " + howMany);
		}
		
		for (Entry<Drink, Integer> entry : paymentMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
	
}
