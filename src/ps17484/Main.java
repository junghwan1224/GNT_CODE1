package ps17484;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* https://www.acmicpc.net/problem/17484
* 진우의 달 여행 (Small)
* */
public class Main {
	static int n, m;
	static int[][] arr;
	static int[][][] d;
	static int MAX = 987654321;
	static int result = MAX;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		// d[i][j][k] = (i, j)번째 위치에 k 방향으로 왔을 때의 최솟값
		// k = 0 왼쪽, k = 1 가운데, k = 2 오른쪽 
		d = new int[n][m][3]; 
		
		for(int i = 0; i < n; i++)
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				Arrays.fill(d[i][j], MAX);
		
		for(int i = 0; i < m; i++) {
			d[0][i][0] = arr[0][i];
			d[0][i][1] = arr[0][i];
			d[0][i][2] = arr[0][i];
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < m; j++) {
				// 왼쪽에서 못오는 경우 
				if(j == 0) {
					d[i][j][1] = Math.min(d[i - 1][j][0], d[i - 1][j][2]) + arr[i][j];
					d[i][j][2] = Math.min(d[i - 1][j + 1][0], d[i - 1][j + 1][1]) + arr[i][j];
				}
				
				// 양쪽에서 올 수 있는 경우 
				else if(0 < j && j < m - 1) {
					d[i][j][0] = Math.min(d[i - 1][j - 1][1], d[i - 1][j - 1][2]) + arr[i][j];
					d[i][j][1] = Math.min(d[i - 1][j][0], d[i - 1][j][2]) + arr[i][j];
					d[i][j][2] = Math.min(d[i - 1][j + 1][0], d[i - 1][j + 1][1]) + arr[i][j];
				}
				
				// 오른쪽에서 못오는 경우
				else if(j == m - 1) {
					d[i][j][0] = Math.min(d[i - 1][j - 1][1], d[i - 1][j - 1][2]) + arr[i][j];
					d[i][j][1] = Math.min(d[i - 1][j][0], d[i - 1][j][2]) + arr[i][j];
				}
			}
		}
		
		for(int i = 0; i < m ; i++) {
			for(int j = 0; j < 3; j++)
				result = Math.min(result, d[n - 1][i][j]);
		}
		
		System.out.println(result);
	}

}
