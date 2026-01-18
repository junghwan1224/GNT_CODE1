package ps12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/12865
 * 평범한 배낭
 *
 * ref. https://st-lab.tistory.com/141
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] d = new int[n + 1][k + 1];
		int[] w = new int[n + 1];
		int[] v = new int[n + 1];

		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= k; j++) {
				if(w[i] > j)
					d[i][j] = d[i - 1][j];
				else {
					d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - w[i]] + v[i]);
				}
			}
		}

		System.out.println(d[n][k]);
	}

}
