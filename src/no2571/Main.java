package no2571;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2571
 * 색종이 - 3
 * */
public class Main {
	static int[][] board = new int[101][101];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		int[][] arr = null;
		int result = 100; // 색종이 하나당 넓이는 100이므로, 결과는 최소 100
		
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
		
		// 색종이 영역 표시
		for(int i = 0; i < n; i++) {
			int x = arr[i][0];
			int y = arr[i][1];
			for(int j = y; j < y + 10; j++) {
				for(int k = x; k < x + 10; k++) {
					board[j][k] = 1;
				}
			}
		}
		
		// i, j => 직사각형 시작점
		for(int i = 1; i < 100; i++) {
			for(int j = 1; j < 100; j++) {
				// 시작점 영역이 0이면 건너뜀.
				if(board[i][j] == 0)
					continue;
				
				// y, x => 직사각형 끝점
				// 시작점(i, j)을 기준으로 끝점(y, x) 구하기.
				for(int y = i + 1; y <= 100; y++) {
					for(int x = j + 1; x <= 100; x++) {
						// 끝점이 0이면 해당 직사각형은 넓이를 구할 필요가 없으므로 break
						if(board[y][x] == 0)
							break;
						
						// 구해진 끝점을 기준으로 구한 사각형 넓이
						int area = (y - i + 1) * (x - j + 1);
						
						// 구한 넓이가 지금까지 구한 넓이(result)보다 작다면 갱신할 필요가 없으므로 건너뜀
						if(result >= area)
							continue;
						
						// 시작점부터 끝점까지 전부 색종이 영역인 경우 넓이의 최댓값 갱
						if(isFilled(i, j, y, x)) {
							result = Math.max(result, area);
						}
						// 전부 색종이 영역이 아닌 경우 건너뜀
						else
							break;
					}
					
				}
			}
		}
		
		System.out.println(result);
	}
	
	// 구하고자 하는 사각형이 모두 색칠되어 있는지 확인
	public static boolean isFilled(int sy, int sx, int ey, int ex) {
		for(int i = sy; i <= ey; i++) {
			for(int j = sx; j <= ex; j++) {
				if(board[i][j] != 1)
					return false;
			}
		}
		return true;
	}

}
