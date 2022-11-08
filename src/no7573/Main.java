package no7573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/7573
 * 고기잡이.
 * 참고 사이트.
 * https://zoosso.tistory.com/381
 * https://jason9319.tistory.com/234
 * https://codingtalk.tistory.com/88
 * http://codersbrunch.blogspot.com/2017/01/7573.html
 * */
public class Main {
	static int N, I, M; // 모눈종이 크기, 그물 크기, 물고기 마릿수.
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		I = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 물고기 좌표 저장 배열.
		int[][] fish = new int[M][2];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			fish[i][0] = Integer.parseInt(st.nextToken()) - 1;
			fish[i][1] = Integer.parseInt(st.nextToken()) - 1;
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < M; j++) {
				for(int k = 1; k < I / 2; k++) {
					// 물고기 두 마리 위치 및 그물을 오른쪽/아래 방향으로 던졌을 때,
					// 잡을 수 있는 물고기의 최대 마릿수를 확인.
					 findFish(fish, i, j, k, I/2 - k);
				}
			}
		}
		
		System.out.println(result);
	}

	// 두 물고기의 현재 위치(curY, curX)에서 잡을 수 있는 물고기 수 및 최댓값 갱신
	// 두 물고기가 위치하는 좌표의 교차점에서 탐색을 해야 효율적으로 탐색 가능.
	public static void findFish(int[][] fish, int curY, int curX, int dy, int dx) {
		int cnt = 0;
		for(int i = 0; i < M; i++) {
			// 물고기 좌표.
			int y = fish[i][0];
			int x = fish[i][1];
			
			// 물고기(y, x)가 인자로 받아온 현재 물고기 위치부터 그물 길이 범위에 있을 경우, 마릿수 증가.
			if(fish[curX][1] <= x && x <= fish[curX][1] + dx && fish[curY][0] <= y && y <= fish[curY][0] + dy) {
				cnt++;
			}
		}
		
		// 최댓값 갱신.
		result = Math.max(result, cnt);
	}
}
