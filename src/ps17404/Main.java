package ps17404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/17404
 * RGB거리 2
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][3];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		// d[i][j] = i번째 집까지 모든 집을 칠하는 비용의 최솟값. j는 칠한 집의 색. 
		int[][] d = new int[n][3];
		
		int result = Integer.MAX_VALUE;
		
		// k = 첫 번째 집의 색.
		for(int k = 0; k < 3; k++) {	
			for(int i = 0; i < 3; i++) {
				// 첫 번째 집을 색칠할 색이 i일 경우.
				if(i == k)
					d[0][i] = arr[0][i];
				// 그 외의 색은 최댓값으로 지정하여, 나중에 최솟값을 뽑아낼 때, 계산에 영향을 안주도록 함.
				else
					d[0][i] = 1000 * 1000 + 1;
			}
			
			// 이전에 칠한 색과 다른 색을 칠했을 때 최소 비용을 더해줌.
			for(int i = 1; i < n; i++) {
				d[i][0] = arr[i][0] + Math.min(d[i - 1][1], d[i - 1][2]);
				d[i][1] = arr[i][1] + Math.min(d[i - 1][0], d[i - 1][2]);
				d[i][2] = arr[i][2] + Math.min(d[i - 1][0], d[i - 1][1]);
			}
			
			// 첫 번째 집에 칠한 색과 마지막 집에 칠한 색이 같으면 안되므로,
			// 첫 번째 칠해진 색(k번째)을 제외한 나머지 색으로 마지막 집을 칠했을 때의 비용 중 최솟값을 구한다.
			for(int i = 0; i < 3; i++) {
				if(i == k)
					continue;
				result = Math.min(result, d[n-1][i]);
			}
		}
		
		System.out.println(result);
	}

}
