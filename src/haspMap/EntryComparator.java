package haspMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class EntryComparator<K, V extends Comparable<V>> implements Comparator <Map.Entry<K, V>>{
	

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap();
		map.put("Hola", 7);
		map.put("Adios", 3);
		List<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		

		list.sort(new EntryComparator<String, Integer>());
		

		System.out.println(list);
	}
	

	@Override
	public int compare(Entry<K, V> o1, Entry<K, V> o2) {
        return o1.getValue().compareTo(o2.getValue());
	}


}

