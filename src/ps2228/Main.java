package ps2228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2228
 * 구간 나누기
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n + 1];
		for(int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		int[] s = new int[n + 1];
		int[][] d = new int[n + 1][m + 1];
		
		for(int i = 1; i <= m; i++)
			d[0][i] = -987654321;
		
		for(int i = 1; i <= n; i++)
			s[i] = s[i - 1] + arr[i];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				d[i][j] = d[i - 1][j];
				for(int k = 1; k <= i; k++) {
					if(k - 2 >= 0) {
						d[i][j] = Math.max(d[i][j], d[k - 2][j - 1] + s[i] - s[k - 1]);
					}
					else if (k == 1 && j == 1)
						d[i][j] = Math.max(d[i][j], s[i]);
				}
			}
		}
		
		int result = 0;
		for(int i = 0; i <= n; i++)
			result += Math.max(result, d[i][m]);
		// System.out.println(result);
		System.out.println(d[n][m]);
	}

}
