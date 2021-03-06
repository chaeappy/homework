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
import java.util.Comparator;
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
		while ((line = br.readLine()) != null) {
			String[] strArr = line.split("\\|");
			if (map.containsKey(strArr[0])) {
				value = map.get(strArr[0]);
				newValue = value + Integer.parseInt(strArr[1]);
				map.put(strArr[0], newValue);
			} else {
				map.put(strArr[0], Integer.parseInt(strArr[1]));
			}
		}
		ArrayList<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort(new Comparator<Entry<String, Integer>>() {

			// 밸류값 홀수 짝수 차례로 오름차순 정렬
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				boolean odd1 = o1.getValue() % 2 == 1;
				boolean odd2 = o2.getValue() % 2 == 1;
				if (odd1 == odd2) {
					return o1.getValue() - o2.getValue();
				}
				if (odd1) {
					return -1;
				}
				if (odd2) {
					return 1;
				}
				return 0;
			}
		});

		for (Entry<String, Integer> entry : list) {
			bw.write(entry + "\n");
			howManyAnimal += entry.getValue();
		}
		bw.write("[결과 : 총 " + howManyAnimal + "마리, " + map.size() + "가지의 동물이 있습니다.]");
		bw.flush();
		bw.close();

	}

}
