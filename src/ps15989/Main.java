package ps15989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/15989
 * 1, 2, 3 더하기 4 
 * */
public class Main {
	static int T;
	static int n;
	static int[][] arr;
	static StringBuffer sb;
	static int MAX = 10001;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		arr = new int[MAX][4];
		
		// arr[i][j] = 마지막에 j를 더하여 i를 만드는 경우의 수 
		arr[1][1] = 1;
		arr[2][1] = 1;
		arr[3][1] = 1;
		
		arr[2][2] = 1;
		arr[3][2] = 1;
		
		arr[3][3] = 1;
		
		int[] arr2 = new int[MAX];
		arr2[1] = 1;
		arr2[2] = 2;
		arr2[3] = 3;
		
		for(int i = 4; i < MAX; i++) {
			arr[i][1] = arr[i - 1][1];
			arr[i][2] = arr[i - 2][1] + arr[i - 2][2];
			arr[i][3] = arr[i - 3][1] + arr[i - 3][2] + arr[i - 3][3];
		}
		
		sb = new StringBuffer();
		
		for(int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			sb.append(arr[n][1] + arr[n][2] + arr[n][3]).append("\n");
		}
		
		System.out.println(sb);
	}

}
