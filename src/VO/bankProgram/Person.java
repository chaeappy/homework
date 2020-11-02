package vo.bankProgram;

class Person {
	String id;
	String name;
	int bankBalance;

	public Person(String id, String name, int bankBalance) {
		this.id = id;
		this.name = name;
		this.bankBalance = bankBalance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBankBalance() {
		return bankBalance;
	}

	public void setBankBalance(int bankBalance) {
		this.bankBalance += bankBalance;
	}

	@Override
	public String toString() {
		return id + ", " + name + ", " + bankBalance;
	}
}
