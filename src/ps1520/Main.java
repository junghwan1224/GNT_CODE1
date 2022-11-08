package ps1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1520
 * 내리막 길
 * https://wootool.tistory.com/83
 * */
public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int[][] d;
	static boolean[][] visit;
	
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M + 1];
		d = new int[N + 1][M + 1];
		visit = new boolean[N + 1][M + 1];
		
		for(int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < M + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i < N + 1; i++) {
			for(int j = 1; j < M + 1; j++) {
				d[i][j] = -1;
			}
		}
		
		
		System.out.println(dfs(1, 1));
	}

	public static int dfs(int y, int x) {
		if(y == N && x == M)
			return 1;
		
		if(d[y][x] != -1)
			return d[y][x];
		
		d[y][x] = 0;
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(1 <= ny && ny <= N && 1 <= nx && nx <= M) {
				if(arr[y][x] > arr[ny][nx])
					d[y][x] += dfs(ny, nx);
			}
		}
		
		return d[y][x];
	}
}
