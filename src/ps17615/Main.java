package ps17615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/17615
 * 볼 모으기 
 * */
public class Main {
	static int N;
	static char[] balls;
	static int result = 987654321;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		balls = br.readLine().toCharArray();
		
		int red = 0; // 빨간 공 갯수 
		int blue = 0; // 파란 공 갯수 
		
		int leftCnt = 0; // 왼쪽부터 연속한 볼의 갯수 
		int rightCnt = 0; // 오른쪽부터 연속한 볼의 갯수 
		
		for(int i = 0; i < balls.length; i++) {
			if(balls[i] == 'R')
				red++;
			else
				blue++;
		}
		// 두 공 중에 갯수가 적은 공이 정답 후보가 될 수 있음 
		result = Math.min(red, blue);
		
		// 왼쪽에 연속한 볼 갯수 구하기 
		char color = balls[0];
		for(int i = 0; i < balls.length; i++) {
			if(balls[i] == color)
				leftCnt++;
			else
				break;
		}
		int move = (color == 'R') ? (red - leftCnt) : (blue - leftCnt);
		result = Math.min(result, move);
		
		// 오른쪽에 연속한 볼 갯수 구하기 
		color = balls[N - 1];
		for(int i = N - 1; i >= 0; i--) {
			if(balls[i] == color)
				rightCnt++;
			else
				break;
		}
		move = (color == 'R') ? (red - rightCnt) : (blue - rightCnt);
		result = Math.min(result, move);
		
		System.out.println(result);
	}

}