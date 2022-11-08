package ps11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/11066
 * 파일 합치기
 * 참고 블로그: https://js1jj2sk3.tistory.com/3
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int k = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] file = new int[k];
			for(int i = 0; i < k; i++) {
				file[i] = Integer.parseInt(st.nextToken());
			}
			
			// dp[i][j]  = i번째 장부터 j번째 장까지 합치는데 드는 최소한의 비용.
			// dp[i][j] = min(i <= k < j){dp[i][k] + dp[k+1][j]} + psum[i][j] (psum[i][j] 는 file의 i부터 j까지의 부분합)
			int[][] d = new int[k][k];
			// sum[i] = 첫 페이지부터 i 페이지까지의 파일의 크기의 합.
			int[] sum = new int[k];
			
			sum[0] = file[0];
			for(int i = 1; i < k; i++) {
				sum[i] = sum[i - 1] + file[i];
			}
			
			// i = d[i][j]를 두 그룹으로 나눴을 때, 첫 번째 그룹의 크기.
			// j = 비용을 구하고자 하는 파일의 첫 번째 페이지.
			// e = 비용을 구하고자 하는 파일의 마지막 페이지.
			// x = d[i][j]를 두 그룹으로 나누는 기준 인덱스.
			for(int i = 1; i < k; i++) {
				for(int j = 0; j < k - i; j++) {
					int e = i + j;
					d[j][e] = Integer.MAX_VALUE;
					
					for(int x = j; x < j + i; x++) {
//						System.out.println(j + " " + x + " " + e);
						d[j][e] = Math.min( d[j][e], d[j][x] + d[x + 1][e] + sum[e] - sum[j] + file[j] );
					}
				}
			}
			
			System.out.println(d[0][k-1]);
		}
	}

}
