package vo.cafe;

import java.util.HashMap;

public class Receipt {
	HashMap<Drink, Integer> map;
	int sum;
	boolean cash;
	String cashReceipt;
	
	public Receipt(HashMap<Drink, Integer> map, int sum, boolean cash) {
		super();
		this.map = map;
		this.sum = sum;
		this.cash = cash;
	}
	
	public Receipt(HashMap<Drink, Integer> map, int sum, boolean cash, String cashReceipt) {
		super();
		this.map = map;
		this.sum = sum;
		this.cash = cash;
		this.cashReceipt = cashReceipt;
	}
	
	
	void printReceipt() {
		
	}
	
}
