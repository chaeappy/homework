package vo.bankProgram2;

import java.util.HashMap;

public class Manager {
	HashMap<String, Customer> map = new HashMap<>();
	// 해쉬맵
	
	// 회원가입
	boolean signUp(String id) {
		if (map.containsKey(id)) {
			return false;
		} else {
			map.put(id, new Customer(id, 0));
			return true;
		}
	}
	// 회원탈퇴
	Customer signOff(String id) {
		return map.remove(id);
		//remove 실패시 null 리턴
	}
	
	// 로그인
	Customer logIn(String id) {
			return map.get(id);
	}
}
