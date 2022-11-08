package no11559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/11559
 * Puyo Puyo
 * */
public class Main_ {
	static int row = 12;
	static int col = 6;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static int puyoCnt = 0;
	static char[][] map;
	static boolean[][] visit;
	
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[row][col];
		visit = new boolean[row][col];
		
		for(int i = 0; i < row; i++)
			map[i] = br.readLine().toCharArray();
		
		while(true) {
			boolean isPuyo = false;
			
			for(int i = row - 1; i >= 0; i--) {
				for(int j = col - 1; j >= 0; j--) {
					if(map[i][j] != '.') {
						puyoCnt = 1;
						visit = new boolean[row][col];
						
						dfs(i, j, map[i][j]);
						
						if(puyoCnt >= 4) {
							isPuyo = true;
							remove();
						}
					}
				}
			}
			
			if(! isPuyo)
				break;
			
			fall();
			result++;
		}
		
		System.out.println(result);
	}

	public static void dfs(int y, int x, char c) {
		visit[y][x] = true;
		
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(0 <= ny && ny < row && 0 <= nx && nx < col) {
				if(c == map[ny][nx] && ! visit[ny][nx]) {
					dfs(ny, nx, c);
					puyoCnt++;
				}
			}
		}
	}
	
	public static void remove() {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(visit[i][j] && map[i][j] != '.')
					map[i][j] = '.';
			}
		}
	}
	
	public static void fall() {
		for(int i = 0; i < col; i++) {
			while(true) {
				boolean isFallPossible = false;
				for(int r = row - 1; r > 0; r--) {
					if(map[r - 1][i] != '.' && map[r][i] == '.') {
						map[r][i] = map[r - 1][i];
						map[r - 1][i] = '.';
						
						isFallPossible = true;
					}
				}
				
				if(! isFallPossible)
					break;
			}
		}
	}
}
