package haspMap;
// 동물리스트 txt파일을 읽어와서 정리하는 문제
// 중복 키의 밸류값은 더하여 해쉬맵에 추가
// 해쉬맵의 중복키 값, 덮어씌우는 점을 활용 --> 중복키 정리할 필요x
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Test {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("hash_test.txt"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Map<String, Integer> map = new HashMap();
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
		List<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort(new Comparator<Entry<String, Integer>>) {
			
		};
		
		for (Entry<String, Integer> entry : list) {
			bw.write(entry.getKey() + " : " + entry.getValue() + "\n");
			howManyAnimal += entry.getValue();
		}
		bw.write("[결과 : 총 " + howManyAnimal + "마리, " + map.size() + "가지의 동물이 있습니다.]");
		bw.flush();
		bw.close();
		
	}

}