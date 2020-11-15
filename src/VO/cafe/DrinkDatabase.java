package vo.cafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DrinkDatabase {
	String driver = "org.mariadb.jdbc.Driver";
	Connection connection;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	String i = "(I)";
	String h = "(H)";
	HashMap<Integer, Drink> drinkMap = new HashMap<Integer, Drink>();

	public DrinkDatabase() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/cafe", "pro_chaea", "1234");

			if (connection != null) {
				System.out.println("DB 접속 성공");
				stmt = connection.createStatement();
				rs = stmt.executeQuery("select * from drink;");
				while(rs.next()) {
					int num = rs.getInt("NUM");
					String name = rs.getString("NAME");
					int price = rs.getInt("PRICE");
					int iced = rs.getInt("ICED");
					if(iced == 0) {
						name = h + name;
					} else {
						name = i + name;
					}
					drinkMap.put(num, new Drink(num, name, price * 100));
				}
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
			e.printStackTrace();
		}
	}
}
