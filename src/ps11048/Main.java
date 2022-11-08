package ps11048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/11048
 * 이동하기
 * */
public class Main {
	static int N;
	static int M;
	static int[][] A;
	static int[][] d;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new int[N + 1][M + 1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		d = new int[N + 1][M + 1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				int max = Math.max(d[i - 1][j - 1], d[i - 1][j]);
				max = Math.max(max, d[i][j - 1]);
				d[i][j] = max + A[i][j];
			}
		}
		
		System.out.println(d[N][M]);
	}

}
