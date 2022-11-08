package ps1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/1003
 * 피보나치 함수
 * */
public class Main {
	static int T;
	static int[][] f;
	static StringBuffer sb;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		sb = new StringBuffer();
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			f = new int[N + 1][2];
			f[0][0] = 1;
			f[0][1] = 0;
			if(N > 0) {
				f[1][0] = 0;
				f[1][1] = 1;
				
				for(int i = 2; i < N + 1; i++) {
					f[i][0] = f[i - 1][0] + f[i - 2][0];
					f[i][1] = f[i - 1][1] + f[i - 2][1];
				}
			}
			
			sb.append(f[N][0]).append(" ").append(f[N][1]).append("\n");
		}
		
		System.out.println(sb);
	}

}
