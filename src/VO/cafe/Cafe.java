package vo.cafe;

import java.util.HashMap;

//1. 회원가입
//2. 커피 선택
//3. 결제 현금 or 카드
//4. 어떤 커피가 몇개 팔렸는지
//5. 어떤 사람이 어떤 커피를 몇개를 샀는지
//6. 총 매출
//등등
public class Cafe {
	HashMap<String, Customer> map = new HashMap<String, Customer>();
	
	

	// 회원관리 (회원등록 / 회원코드인증)
	boolean signUp(String id, int gender) {
		if (map.containsKey(id)) {
			return false;
		} else {
			map.put(id, new Customer(id, gender));
			return true;
		}
	}
	
	Customer login(String id) {
		if (map.containsKey(id)) {
			Customer c = map.get(id);
			return c;
		}
		return null; 
	}
	// 
	// 
	// 영수증
	// 판매내역
	// 총매출(어떤 음료, 몇개 팔림)
}
