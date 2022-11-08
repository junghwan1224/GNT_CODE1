package no11559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/11559
 * Puyo Puyo
 * */
public class Main {
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static boolean[][] visit; // 방문 여부.
	static char[][] arr; // 필드.
	static int cnt; // 연결된 같은 색 뿌요들의 수.

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new char[12][6];
		int result = 0; // 연쇄 횟수(결과값)
		
		for(int i = 0; i < 12; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		visit = new boolean[12][6];
		
		while(true) {
			boolean isPuyo = false; // 없어질 뿌요가 있는지 체크하는 변수.
			
			for(int i = 11; i >= 0; i--) {
				for(int j = 5; j >= 0; j--) {
					if(arr[i][j] != '.' ) { // 뿌요가 있는 경우.
						visit = new boolean[12][6]; // 방문 여부 초기화.
						cnt = 1; // 없어질 뿌요 갯수.
						
						dfs(i, j, arr[i][j]); // 연결된 뿌요 체크.
						
						if(cnt >= 4) { // 뿌요가 상하좌우 4개 이상 연결되어 있으면.
							isPuyo = true; // 없어질 뿌요가 있으므로 true
							remove(); // 없어지는 부분 '.'으로 변환.
						}
					}
				}
			}
			
			// 더이상 없어질 뿌요가 없으면 반복문 종료.
			if(! isPuyo)
				break;
			
			// 뿌요가 터진 후 떨어짐.
			fall();
			// 뿌요가 다 터진 후, 연쇄 횟수 1 증가.
			result++;
		}
		
		System.out.println(result);
	}

	// 뿌요가 상하좌우에 연결되어 있는지 확인.
	public static void dfs(int y, int x, char c) {
		visit[y][x] = true;
		
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0 <= ny && ny < 12 && 0 <= nx && nx < 6 && arr[ny][nx] != '.' && c == arr[ny][nx] && ! visit[ny][nx]) {
				cnt++;
				dfs(ny, nx, c);
			}
		}
	}
	
	// 뿌요가 터지면 '.'으로 변환.
	public static void remove() {
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 6; j++) {
				if(visit[i][j] && arr[i][j] != '.') {
					arr[i][j] = '.';
				}
			}
		}
	}
	
	
	// 뿌요 터진 후 떨어짐.
	public static void fall() {
		for(int j = 0; j < 6; j++) {
			while(true) {
				boolean isFallPossible = false; // 떠있는 뿌요가 있어 떨어질 수 있는지 확인하는 변수.
				
				for(int i = 11; i > 0; i--) {
					// 한 칸씩 떨어뜨림.
					if(arr[i-1][j] != '.' && arr[i][j] == '.') {
						arr[i][j] = arr[i-1][j];
						arr[i-1][j] = '.';
						
						// 떨어질 경우가 있으므로 true.
						isFallPossible = true;
					}
				}
				
				// 더이상 떨어질 수 없으면 반복문 종료.
				if(! isFallPossible)
					break;
			}
		}
	}
}
