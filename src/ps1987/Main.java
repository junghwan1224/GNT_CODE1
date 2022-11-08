package ps1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1987
 * 알파벳
 * */
public class Main {
	static int R;
	static int C;
	static char[][] board;
	static boolean[][] visit;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static Map<Character, Integer> map;
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		visit = new boolean[R][C];
		map = new HashMap<Character, Integer>();
		
		for(int i = 0; i < R; i++)
			board[i] = br.readLine().toCharArray();
		
		visit[0][0] = true;
		map.put(board[0][0], 1);
		
		dfs(0, 0);
		
		System.out.println(result);
	}

	public static void dfs(int curY, int curX) {
		result = Math.max(result, map.size());
		
		for(int i = 0; i < 4; i++) {
			int ny = curY + dy[i];
			int nx = curX + dx[i];
			
			if(0 <= ny && ny < R && 0 <= nx && nx < C && ! visit[ny][nx]) {
				if(map.containsKey(board[ny][nx]))
					continue;
				visit[ny][nx] = true;
				map.put(board[ny][nx], 1);
				dfs(ny, nx);
				visit[ny][nx] = false;
				map.remove(board[ny][nx]);
			}
		}
	}
}
