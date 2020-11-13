package vo.cafe;

import java.util.HashMap;

public class Drink {
	static HashMap<String, Integer> drink = new HashMap<String, Integer>();
	static HashMap<Drink, Integer> count = new HashMap<Drink, Integer>();
	
	public static void main() {
		String i = "(I)";
		String h = "(H)";
		drink.put("에스프레소", 15);
		drink.put(h + "아메리카노", 15);
		drink.put(i + "아메리카노", 18);
		drink.put(h + "카페라떼", 20);
		drink.put(i + "카페라떼", 23);
		drink.put(h + "카푸치노", 20);
		drink.put(i + "카푸치노", 23);
		drink.put(h + "바닐라라떼", 25);
		drink.put(i + "바닐라라떼", 28);
		drink.put(h + "헤이즐넛라떼", 25);
		drink.put(i + "헤이즐넛라떼", 28);
		drink.put(h + "카페모카", 25);
		drink.put(i + "카페모카", 28);
		drink.put(h + "마끼아또", 25);
		drink.put(i + "마끼아또", 28);
		drink.put(h + "에쏘그린티라떼", 35);
		drink.put(i + "에쏘그린티라떼", 35);
		drink.put("김과장커피", 30);
		drink.put("콜드브루카노", 25);
		drink.put("콜드브루라떼", 28);
		drink.put("콜드브루소이라떼", 33);
		drink.put(h + "흑심라떼", 30);
		drink.put(i + "흑심라떼", 33);
		drink.put("Add샷", 5);
		drink.put("Add바닐라시럽", 5);
		drink.put("Add헤이즐넛시럽", 5);
		drink.put("Add카라멜시럽", 5);
		drink.put("두유변경", 5);
		drink.put("텀블러할인", -1);
		drink.put("Add컵", 1);
		drink.put(h + "곡물라떼", 33);
		drink.put(i + "곡물라떼", 36);
		drink.put(h + "그린티라떼", 30);
		drink.put(i + "그린티라떼", 33);
		drink.put(h + "초코라떼", 30);
		drink.put(i + "초코라떼", 33);
		drink.put(h + "홍차라떼", 33);
		drink.put(i + "홍차라떼", 36);
		drink.put(h + "흑심밀크티", 33);
		drink.put(i + "흑심밀크티", 36);
		drink.put("딸기라떼", 38);
		drink.put("딸기초코", 38);
		drink.put(h + "카모마일", 15);
		drink.put(i + "카모마일", 18);
		drink.put(h + "페퍼민트", 15);
		drink.put(i + "페퍼민트", 18);
		drink.put(h + "얼그레이", 15);
		drink.put(i + "얼그레이", 18);
		drink.put(h + "루이보스", 15);
		drink.put(i + "루이보스", 18);
		drink.put("복숭아아이스티", 20);
		drink.put(h + "레몬차", 33);
		drink.put(i + "레몬차", 36);
		drink.put(h + "자몽차", 33);
		drink.put(i + "자몽차", 36);
		drink.put(h + "유자차", 33);
		drink.put(i + "유자차", 36);
		drink.put("자몽에이드", 35);
		drink.put("레몬에이드", 35);
	}
}
