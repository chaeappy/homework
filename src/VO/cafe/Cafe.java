package vo.cafe;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

//1. 회원가입
//2. 커피 선택
//3. 결제 현금 or 카드
//4. 어떤 커피가 몇개 팔렸는지
//5. 어떤 사람이 어떤 커피를 몇개를 샀는지
//6. 총 매출
//등등

public class Cafe {
	// 사원코드 정보 map
	HashMap<String, Customer> customerMap = new HashMap<String, Customer>();
	
	HashMap<Date, ArrayList<HashMap<String, Integer>>> reseipt = new HashMap<Date, ArrayList<HashMap<String,Integer>>>();
	// 회원관리 (회원등록 / 회원코드인증)
	boolean signUp(String id, int gender) {
		if (customerMap.containsKey(id)) {
			return false;
		} else {
			customerMap.put(id, new Customer(id, gender));
			return true;
		}
	}
	
	Customer login(String id) {
		if (customerMap.containsKey(id)) {
			Customer c = customerMap.get(id);
			return c;
		}
		return null; 
	}
	
	void order(Customer c, String name, int howMany) {
//		Drink drink = ddb.drinkMap.get(name);
//		ArrayList<HashMap<String, Integer>> orderList = new ArrayList<HashMap<String,Integer>>();
//		int i = 0;
//		for (Entry<Integer, Drink> entry : ddb.drinkMap.entrySet()) {
//			Drink drink = entry.getValue();
//			bw.write(drink + " ");
//			++i;
//			if (i == 3) {
//				bw.write("\n");
//				i = 0;
//			}
//		}
		
	}
	// 
	// 
	// 영수증
	// 판매내역
	// 총매출(어떤 음료, 몇개 팔림)
}
