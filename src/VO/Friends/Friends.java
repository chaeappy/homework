package VO.Friends;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

class Friends {
	String name;
	String birthDay;
	
	public Friends(String name, String birthDay) {
		this.name = name;
		this.birthDay = birthDay;
		
	}

	public static void main(String[] args) throws IOException {
		Friends fr = new Friends("김채아", "8월3일");
		Friends fr2 = new Friends("이묘찬", "9월3");
		String fileName = "\test.txt";	
		HashMap<String, Friends> map = new HashMap();
		String[] strArr = new String[map.size()];
	
		map.put(fr.name, fr);
		map.put(fr2.name, fr2);
		
		System.out.println(fr.toString());
		
//		FileWriter fw = new FileWriter(new File(fileName), true);
		System.out.println(map.keySet());
		System.out.println(map.entrySet());
	
			
		
	}

	@Override
	public String toString() {
		return "Friends [name=" + name + ", birthDay=" + birthDay + "]";
	}
}



