package vo.bankProgram2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Manager {
	// 해쉬맵
	HashMap<String, Customer> map = new HashMap<>();
	File file = new File("/Users/chaea/Desktop/workspace/homework/bankCustomer.txt");

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
		// remove 실패시 null 리턴
	}

	// 로그인
	Customer logIn(String id) {
		return map.get(id);
	}

	// 이체
	Customer sendMoney(String other) {
		return map.get(other);
	}

	void save() {
		try {
			// FileWriter(file, true) true 쓸 경우 이어쓰므로 중복생김
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			for (Map.Entry<String, Customer> entry : map.entrySet()) {
				String key = entry.getKey();
				Customer values = entry.getValue();
				bw.write(values + "\n");
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void load() {
		String str;
		try {
			if (file.exists()) {
				map.clear();
				
				BufferedReader br = new BufferedReader(new FileReader(file));
				while ((str = br.readLine()) != null) {
					str.replace(" ", "");
					String strArr[] = str.split(",");
					String id = strArr[0];
					int money = Integer.parseInt(strArr[1]);
					map.put(id, new Customer(id, money));
					
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
