package ps11050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/11050
 * 이항 계수 1
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] d = new int[n + 1][k + 1];

		for(int i = 0; i < n + 1; i++)
			d[i][0] = 1;
		
		for(int i = 1; i < n + 1; i++) {
			for(int j = 1; j < k + 1; j++) {
				d[i][j] = d[i - 1][j - 1] + d[i - 1][j];
				// System.out.println("N = " + i + ", K = " + j + ", VAL = " + d[i][j]);
			}
		}
		
		System.out.println(d[n][k]);
	}

}
