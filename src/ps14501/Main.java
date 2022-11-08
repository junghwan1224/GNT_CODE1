package ps14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/14501
 * 퇴사
 * */
public class Main {
	static int N;
	static int[] T;
	static int[] P;
	static int[] d;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		T = new int[N + 1];
		P = new int[N + 1];
		d = new int[N + 1];
		
		StringTokenizer st = null;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			T[i] = a;
			P[i] = b;
			d[i] = P[i];
		}
		
		for(int i = 2; i <= N; i++) {
			for(int j = 1; j < i; j++) {
				if(j + T[j] <= i) {
					d[i] = Math.max(P[i] + d[j], d[i]);
				}
			}
		}
		
		int result = 0;
		for(int i = 1; i <= N; i++)
			// 상담 가능한 일이 퇴사일 전이면 최댓값 갱신 
			if(i + T[i] - 1 <= N)
				result = Math.max(result, d[i]);
		
		System.out.println(result);
	}

}
