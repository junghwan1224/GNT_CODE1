package no2563;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * https://www.acmicpc.net/problem/2563
 * 색종이
 * */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		int[][] arr = null; // 색종이 좌표 저장.
		int[][] board = new int[101][101]; // 100x100 도화지.
		int cnt = 0; // 색칠된 칸의 갯수.
		
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
		
		for(int i = 1; i < 101; i++) {
			for(int j = 1; j < 101; j ++) {
				if(board[i][j] > 0) {
					cnt++; // 색칠된 곳 갯수 세기
				}
			}
		}
		
		System.out.println(cnt);
	}

}
