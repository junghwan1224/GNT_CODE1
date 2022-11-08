package ps15988;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/15988
 * 1, 2, 3 더하기 3
 * */
public class Main {
	static int T;
	static long[] d;
	static int MAX = 1000010;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		d = new long[MAX];
		d[1] = 1;
		d[2] = 2;
		d[3] = 4;
		
		for(int i = 4; i < MAX; i++) {
			d[i] = (d[i - 1] + d[i - 2] + d[i - 3]) % 1000000009;
		}
		
		StringBuffer sb = new StringBuffer();
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(d[N]).append("\n");
		}
		
		System.out.println(sb);
	}

}
