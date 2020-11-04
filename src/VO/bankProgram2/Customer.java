package vo.bankProgram2;

public class Customer {
	String id;
	int money;
	
	public Customer(String id, int money) {
		this.id = id;
		this.money = money;
	}
	// 입금
	void saveMoney(int money) {
		this.money += money;
	}
	// 출금
	void spendMoney(int money) {
		this.money -= money;
	}
	// 이체 
	void sendMoney(Customer c, Customer other, int money) {
		c.spendMoney(money);
		other.saveMoney(money);
	}
	@Override
	public String toString() {
		return id + ", " + money;
	}
	
}
