package ps1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1932
 * 정수 삼각형
 * */
public class Main {
	static int n;
	static int[][] arr;
	static int[][] d;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[505][505];
		d = new int[505][505];
		
		StringTokenizer st = null;
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		d[1][1] = arr[1][1];
		
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				d[i][j] = arr[i][j] + Math.max(d[i - 1][j - 1], d[i - 1][j]);
			}
		}
		
		int result = 0;
		for(int i = 1; i <= n; i++) {
			result = Math.max(result, d[n][i]);
		}
		
		System.out.println(result);
	}

}
