package vo.cafe;

public class Customer {
	String eMail;
	String passWord;
	String name;
	Receipt receipt;

	// 결재내역 영수증

	public Customer(String eMail, String passWord) {
		this.eMail = eMail;
		this.passWord = passWord;
	}

	// 구매내역(현금 or 카드 / 구매한 음료 및 총 개수
	// 영수증 (음료/잔수/금액/카드or현금)

}
