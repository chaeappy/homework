package VO.Friends;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Friends2 {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("friends.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String line = "";
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}
}
