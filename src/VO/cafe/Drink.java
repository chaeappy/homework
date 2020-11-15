package vo.cafe;

public class Drink {
	String name;
	int price;
	int num;
	
	public Drink(int num, String name, int price) {
		this.num = num;
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return " [ " + num + " " + name + ", " +  price + "원 ]";
	}



	
	
}
