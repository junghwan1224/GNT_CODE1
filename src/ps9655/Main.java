package ps9655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/9655
 * 돌 게임
 * */
public class Main {
	static int N;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String result = (N % 2 == 0) ? "CY" : "SK";
		System.out.println(result);
	}

}
