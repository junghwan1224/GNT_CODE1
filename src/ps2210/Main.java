package ps2210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2210
 * 숫자판 점프
 * */
public class Main {
	static int N = 5;
	static int DIGIT = 6;
	static int[][] arr;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static Set<String> result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[N][N];
		result = new HashSet<String>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				dfs(i, j, 0, "");
			}
		}
		
		System.out.println(result.size());
	}
	
	public static void dfs(int y, int x, int digit, String s) {
		if(digit == DIGIT) {
			result.add(s);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(0 <= ny && ny < N && 0 <= nx && nx < N) {
				dfs(ny, nx, digit + 1, s + Integer.toString(arr[y][x]));
			}
		}
	}
}
