package ps1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1389
 * 케빈 베이컨의 6단계 법칙
 * */
public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int MAX = 987654321;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(i == j)
						continue;
					
					else if(arr[i][k] != 0 && arr[k][j] != 0) {
						if(arr[i][j] == 0)
							arr[i][j] = arr[i][k] + arr[k][j];
						else
							arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
					}
				}
			}
		}
		
		int cnt = MAX;
		int result = MAX;
		
		for(int i = 1; i <= N; i++) {
			
			int tmp = 0;
			for(int j = 1; j <= N; j++) {
				tmp += arr[i][j];
			}
			
			if(cnt > tmp) {
				cnt = tmp;
				result = i;
			}
		}
		
		System.out.println(result);
	}

}
