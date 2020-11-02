package vo.friends;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

public class Friends2 {
	
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("friends.txt");
		BufferedReader br = new BufferedReader(fr);
		HashMap<String, String> map = new HashMap();
		String line = "";
		String[] strArr = null;
		
		while ((line = br.readLine()) != null) {
			line = line.replace("[name: ", "");
			line = line.replace("birthDay: ", "");
			line = line.replace("]", "");
			
			strArr = line.split(",");
			map.put(strArr[0], strArr[1]);
		}
			for (Entry<String, String> entry : map.entrySet()) {
				String name = entry.getKey();
				String value = entry.getValue();
				System.out.println("[name: " + name + ", birthDay: " + value + "]");
			}
	}



}
