package ps15992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/15992
 * 1, 2, 3 더하기 7
 * */
public class Main {
	static int MAX = 1000000009;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		long[][] d = new long[1001][1001];
		d[1][1] = 1;
		d[2][1] = 1;
		d[3][1] = 1;
		
		d[2][2] = 1;
		d[3][2] = 2;
		
		d[3][3] = 1;
		
		for(int i = 4; i < 1001; i++) {
			for(int j = 1; j < i + 1; j++) {
				d[i][j] += d[i - 1][j - 1];
				d[i][j] += d[i - 2][j - 1];
				d[i][j] += d[i - 3][j - 1];
				
				d[i][j] %= MAX;
			}
		}
		
		while(T > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			System.out.println(d[N][M]);
			T--;
		}
	}

}
