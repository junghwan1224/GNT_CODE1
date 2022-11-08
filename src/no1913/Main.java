package no1913;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * https://www.acmicpc.net/problem/1913
 * 달팽이
 * */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		int v = 0;
		int [][] arr = null;
		
		try {
			n = Integer.parseInt(br.readLine());
			v = Integer.parseInt(br.readLine());
			
			arr = new int[n][n];
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		int x = (n-1) / 2; // x 좌표.
		int y = (n-1) / 2; // y 좌표.
		int val = 1; // 달팽이 그려가면서 입력하는 값. 
		int move = 1; // 한 방향으로 이동하는 칸 수.
		int cnt = 0; // 같은 move 값으로 두 번 이동했는지 체크.
		// ex) 처음에 상 1칸, 우 1칸 이동했으면 다음에는 하 2칸, 좌2칸 이동해야 하는 부분을 체크해야 하기 때문에.
		//     우 1칸까지 이동했으면 cnt 값이 2가 됨. 다음 로직에서 cnt 값을 0으로 초기화 해주고 이동하는 칸 수인 move값을 1 더해줌.
		arr[y][x] = val; // 시작점 정중앙 세팅.
		int[][] dir = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} }; // 상, 우, 하, 좌.
		// 본 문제는 달팽이 시작 지점이 한 가운데이므로, 이동 방향은 상, 우, 하 좌가 됨.
		int nowDir = 0; // 현재 그리고 있는 방향.
		boolean flag = false; // 루프 탈출 flag
		
		// v값 좌표를 저장할 변수.
		int getX = 0;
		int getY = 0;
		
		while(true) {
			if(cnt == 2) { // 2번 꺾어서 이동했으면 칸수 올리고, 해당 칸수에 대한 이동 횟수 초기화.
				move++;
				cnt = 0;
			}
			int dy = dir[nowDir][0]; // 나아가야 할 방향.
			int dx = dir[nowDir][1]; // 나아가야 할 방향.
			
			// 해당 칸수만큼 이동하면서 값 넣어준다.
			for(int i = 0; i < move; i++) {
				y += dy;
				x += dx;
				arr[y][x] = ++val;
				
				// 달팽이가 그려지는 마지막 위치에 도달했을 경우 루프 탈출.
				if(y == 0 && x == 0) {
					flag = true;
					break;
				}
			}
			
			// 루프 탈출.
			if(flag)
				break;
			
			// 한 방향으로 값을 채웠으니 방향 전환.
			nowDir = (nowDir + 1) % 4;
			
			// 현재 move 값으로 이동한 횟수 + 1
			cnt++;
		}
		
		// 출력시 시간 초과를 고려하여 BufferedWriter 사용.
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				// v 값의 좌표 구하기
				if(arr[i][j] == v) {
					getY = i + 1;
					getX = j + 1;
				}
				
				try {					
					bw.write(Integer.toString(arr[i][j]) + " ");
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			try {
				bw.write("\n");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		try {			
			bw.write(Integer.toString(getY) + " " + Integer.toString(getX));
			
			bw.flush(); // 출력.
			
			br.close();
			bw.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
