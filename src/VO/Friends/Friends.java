package VO.Friends;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

class Friends {
	String name;
	String birthDay;
	
	public Friends(String name, String birthDay) {
		this.name = name;
		this.birthDay = birthDay;
		
	}

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("friends.txt"));
		Friends fr = new Friends("김채아", "8월3일");
		Friends fr2 = new Friends("이묘찬", "9월3일");
		String fileName = "\test.txt";	
		HashMap<String, Friends> map = new HashMap();
//		String[] strArr = new String[map.size()];
		String str = "";
	
		map.put(fr.name, fr);
		map.put(fr2.name, fr2);
		
		for (Entry<String, Friends> entry : map.entrySet()) {
			String key = entry.getKey();
			Friends value = entry.getValue();
			bw.write(value + "\n");
			bw.flush();
		}
		
	
			
		
	}

	@Override
	public String toString() {
		return "[name: " + name + ", birthDay: " + birthDay + "]";
	}
}



