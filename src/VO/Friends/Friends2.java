package VO.Friends;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Friends2 {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("friends.txt"));
		String str = "아아 테스트중입니다.";
		bw.write(str);
		bw.close();
	}

}
