package vo.cafe;

import java.util.HashMap;
import java.util.Map.Entry;

public class Sales {
	void check(String date, HashMap<String, Receipt> salesMap) {
		for (Entry<String, Receipt> entry : salesMap.entrySet()) {
			String dateKey = entry.getKey().substring(0, date.length());
			if (dateKey.equals(date)) {
				System.out.println(entry.getKey() + " " + entry.getValue());
				
			}
		}
		
	}
}
