package ps9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/9663
 * N-Queen
 * */
public class Main {
	static int n; // 체스판 크기 및 퀸 갯수.
	static int result; // 결과값.
	static int[] cols; // 퀸을 배치한 행/열의 위치 값.  index = 행 / value = 열.

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		cols = new int[n];
		
		// 배열 초기화.
		for(int i = 0; i < n; i++)
			cols[i] = -1;
		
		dfs(0);
		
		System.out.println(result);
	}
	
	// 퀸을 배치할 수 있는지 체크.
	// y = 현재 퀸을 배치한 행.
	// x = 현재 퀸을 배치한 열.
	public static boolean isSetQueen(int y, int x) {
		// 첫 행부터 현재 퀸을 배치한 행의 직전 행까지 놓여진 퀸의 위치와 비교.
		for(int i = 0; i < y; i++) {	
			// 현재 열이 이전에 위치한 퀸 중 같은 열에 위치한 경우.
			// 또는 현재 위치가 이전에 위치한 퀸 중 같은 대각선 라인에 있는 경우.
			// 퀸을 배치할 수 없으므로 false 반환.
			if(cols[i] != -1) {
				if((x == cols[i]) || ( (y - i) == Math.abs(x - cols[i]) ))
					return false;
			}
		}
		
		// 반복문이 끝날때까지 함수가 종료되지 않았다는건 퀸을 배치할 수 있다는 뜻이므로 true 반환.
		return true;
	}
	
	// 재귀
	// a = 현재 퀸을 배치할 수 있는지 탐색 중인 행.
	public static void dfs(int a) {
		// 마지막 행까지 도달했다면, 서로 공격할 수 없게 퀸을 배치했다는 뜻이므로 결과값을 1 더한 후 함수 종료.
		if(n == a) {
			result++;
			return;
		}
		
		// a행의 i열에 퀸을 배치할 수 있는지 체크 후 퀸 배치.
		// a행의 i열에 퀸 배치한 상태에서 다음 퀸을 배치할 수 있는지 확인하기 위해 재귀 호출.
		// i = 열.
		for(int i = 0; i < n; i++) {
			// 아직 퀸이 배치되지 않았으면.
			if(cols[a] == -1) {
				// 배치할 수 있는지 검사.
				if(isSetQueen(a, i)) {
					// 퀸 배치.
					cols[a] = i;
					dfs(a + 1);
					// 해당 위치에서 검사가 끝났으면 퀸 뺀다.
					cols[a] = -1;
				}
			}
		}
	}
}
