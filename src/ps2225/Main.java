package ps2225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2225
 * 합분해
 * */
public class Main {
	static int n;
	static int k;
	static int[][] d;
	static int MOD = 1000000000;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		d = new int[k + 1][n + 1];
		// d[k][n] = 정수 k개를 더해서 그 합이 n이 되는 경우의 수 
		
		// 1개를 사용해서 i를 만들 수 있는 경우는 그 수 본인이 되어야 하므로 1로 초기화 
		for(int i = 0; i <= n; i++)
			d[1][i] = 1;
		
		for(int i = 1; i <= k; i++) {
			for(int j = 0; j <= n; j++) {
				for(int o = 0; o <= j; o++) {
					// i개를 더해서 j를 만들기 위한 탐색 
					// (i - 1)개까지 사용하고, 마지막으로 더해줄 값이 k라고 하면
					// d[i - 1][j - k]인 경우를 더해준다
					d[i][j] += d[i - 1][j - o];
					d[i][j] %= MOD;
				}
			}
		}
		
		System.out.println(d[k][n]);
	}

}
