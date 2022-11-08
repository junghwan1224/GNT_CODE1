package ps18290;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/18290
 * NM과 K (1)
 * */
public class Main {
	static int N;
	static int M;
	static int K;
	static int[][] arr;
	static boolean[][] visit;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static int result = -987654321;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visit = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		dfs(0, 0);
		
		System.out.println(result);
	}

	public static void dfs(int cnt, int sum) {
		if(cnt == K) {
			result = Math.max(result, sum);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(! visit[i][j]) {if(check(i, j)) {
						visit[i][j] = true;
	                    dfs(cnt + 1, sum + arr[i][j]);                    
	                    visit[i][j] = false;
					}
				}
			}
		}
		
		return;
	}
	
	public static boolean check(int y, int x) {
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(0 <= ny && ny < N && 0 <= nx && nx < M) {
				if(visit[ny][nx])
					return false;
			}
		}
		
		return true;
	}
}
