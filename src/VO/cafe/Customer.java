package vo.cafe;

import java.util.ArrayList;

public class Customer {
	ArrayList<Drink> list = new ArrayList<Drink>();
	String id;
	int gender;
	
	public Customer(ArrayList<Drink> list, String id, int gender) {
		super();
		this.list = list;
		this.id = id;
		this.gender = gender;
	}

	public Customer(String id, int gender) {
		super();
		this.id = id;
		this.gender = gender;
	}
	

	
	//구매내역(현금 or 카드 / 구매한 음료 및 총 개수
	//영수증 (음료/잔수/금액/카드or현금)
	
	
	
	
}
