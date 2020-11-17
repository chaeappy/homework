package vo.cafe;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);

		SimpleDateFormat key = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = key.format(date);
		System.out.println("date : " + s);
		
		SimpleDateFormat receipt = new SimpleDateFormat("yyyy년MM월dd일_HH시mm분ss초");
		String k = receipt.format(date);
		System.out.println("date : " + k);
		

	}
}
