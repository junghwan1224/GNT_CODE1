package ps14596;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/14596
 * Quilting (Small)
 * DP로 풀었기 때문에, 14597 Quilting (Large) 문제도 풀림.
 * Small은 DFS로도 풀이 가능.
 * */
public class Main {
	static int[][] b1;
	static int[][] b2;
	static int[][] b3;
	static int[][] result;
	static int value;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		b1 = new int[h][w];
		b2 = new int[h][w];
		b3 = new int[h][w];
		result = new int[h][w];
		
		for(int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < w; j++) {
				b1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < w; j++) {
				b2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/* 포개어지는 경우만 주어지므로 이미지1과 이미지2의 차이의 제곱값을 저장. */
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				// b3[i][j] = Math.abs(b1[i][j] - b2[i][j]);
				b3[i][j] = b3[i][j] * b3[i][j];
				result[i][j] = b3[i][j];
			}
		}
		
		/* 해당 위치의 기준으로, 왼쪽 위, 바로 위, 오른쪽 위까지의 계산된 값들의 최솟값을 갱신 및 더해줌. */
		for(int i = 1; i < h; i++) {
			for(int j = 0; j < w; j++) {
				int minVal = result[i - 1][j];
				
				if(j - 1 >= 0) {
					minVal = Math.min(minVal, result[i - 1][j - 1]);
				}
				
				if(j + 1 < w) {
					minVal = Math.min(minVal, result[i - 1][j + 1]);
				} 
				
				result[i][j] += minVal;
			}
		}
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		
		/* 값을 계속 더해주면 마지막 행의 값들 중 최솟값을 갱신해주면 됨. */
		value = 1000000001;
		for(int i = 0; i < w; i++) {
			value = Math.min(value, result[h - 1][i]);
		}
		
		System.out.println(value);
	}

}
