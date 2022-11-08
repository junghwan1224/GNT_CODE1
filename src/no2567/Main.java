package no2567;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2567
 * 색종이 - 2
 * */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		int[][] arr = null; // 색종이 좌표 저장.
		int[][] board = new int[102][102]; // 100x100 도화지.
		int cnt = 0; // 둘레를 측정하는 기준이 되는 칸(==테두리)의 갯수, 결과값
		
		try {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][2];
			
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < n; i++) {
			int x = arr[i][0];
			int y = arr[i][1];
			
			for(int j = y; j < y + 10; j++) {
				for(int k = x; k < x + 10; k++) {
					board[j][k]++; //색종이 있는 곳 색칠(0보다 크게 해줌)
				}
			}
		}
		
		// 둘레 구하기. == 색칠된 테두리 갯수 세기.
		for(int i = 1; i < 101; i++) {
			for(int j = 1; j < 101; j++) {
				// 현재 칸이 색칠되어 있고,(윗칸이 색칠x, 아랫칸 색칠o 인 경우) 또는 (윗칸이 색칠o, 아랫칸 색칠x 인 경우)
				if(board[i][j] > 0 && ( (board[i-1][j] > 0 && board[i+1][j] == 0) || (board[i-1][j] == 0 && board[i+1][j] > 0) )) {
					cnt++;
				}
				
				// 현재 칸이 색칠되어 있고,(왼쪽칸이 색칠x, 오른쪽칸 색칠o 인 경우) 또는 (왼쪽칸이 색칠o, 오른쪽칸 색칠x 인 경우)
				if(board[i][j] > 0 && ( (board[i][j-1] > 0 && board[i][j+1] == 0) || (board[i][j-1] == 0 && board[i][j+1] > 0) )) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
