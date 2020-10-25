package haspMap;

import java.util.HashMap;
import java.util.Set;

public class Test_HashMap {

	public static void main(String[] args) {
		HashMap<String , Integer> map = new HashMap<String , Integer>();

	    map.put("신논현", 1);
	    map.put("강남", 2);
	    map.put("혜화", 3);
	    map.put("안양", 4);
	    map.put("수원", 5);

	    Set set = map.keySet();
	    System.out.println(set);
	    
	}

}
