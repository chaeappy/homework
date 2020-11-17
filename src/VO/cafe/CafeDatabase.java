package vo.cafe;
//1. 회원가입
//2. 커피 선택
//3. 결제 현금 or 카드
//4. 어떤 커피가 몇개 팔렸는지
//5. 어떤 사람이 어떤 커피를 몇개를 샀는지
//6. 총 매출
//등등
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class CafeDatabase {
	String driver = "org.mariadb.jdbc.Driver";
	Connection connection;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet drinkRs;
	ResultSet customerRs;
	String i = "(I)";
	String h = "(H)";
	// 음료 map
	HashMap<Integer, Drink> drinkMap = new HashMap<Integer, Drink>();
	// 사원코드 정보 map
	HashMap<String, Customer> customerMap = new HashMap<String, Customer>();

	public CafeDatabase() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/cafe", "pro_chaea", "1234");
			if (connection != null) {
				System.out.println("DB 접속 성공");
				stmt = connection.createStatement();
				drinkRs = stmt.executeQuery("select * from drink;");
				customerRs = stmt.executeQuery("");
				while(drinkRs.next()) {
					int num = drinkRs.getInt("NUM");
					String name = drinkRs.getString("NAME");
					int price = drinkRs.getInt("PRICE");
					int iced = drinkRs.getInt("ICED");
					if(iced == 0) {
						name = h + name;
					} else {
						name = i + name;
					}
					drinkMap.put(num, new Drink(num, name, price * 100));
				}
			}
			connection.close();

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
			e.printStackTrace();
		}
	}
}
