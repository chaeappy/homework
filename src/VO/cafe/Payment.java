package vo.cafe;

import java.util.Date;

public class Payment {
	Date date;
	Receipt r;
	public Payment(Date date, Receipt r) {
		this.date = date;
		this.r = r;
	}
	
}
