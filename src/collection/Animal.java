package collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map.Entry;

public class Animal {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("hash_test.txt"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String, Integer> map = new HashMap();
		String line = "";
		int value = 0;
		int newValue = 0;
		int howManyAnimal = 0;
		
		while((line = br.readLine()) != null) {
			String[] strArr = line.split("\\|");
			if (map.containsKey(strArr[0])) {
				value = map.get(strArr[0]);
				newValue = value + Integer.parseInt(strArr[1]);
				map.put(strArr[0], newValue);
			} else {
				map.put(strArr[0], Integer.parseInt(strArr[1]));
			}
		}
		
		for (Entry<String, Integer> entry : map.entrySet()) {
			bw.write(entry.getKey() + " : " + entry.getValue() + "\n");
			howManyAnimal += entry.getValue();
		}
		bw.write("[결과 : 총 " + howManyAnimal + "마리, " + map.size() + "가지의 동물이 있습니다.]");
		bw.flush();
		bw.close();
		
	}

}
