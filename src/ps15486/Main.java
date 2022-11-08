package ps15486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/15486
 * 퇴사 2
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
		T = new int[N + 2];
		P = new int[N + 2];
		d = new int[N + 2];
		
		StringTokenizer st = null;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
			//d[i] = P[i];
		}
		
//		for(int i = 2; i <= N; i++) {
//			for(int j = 1; j < i; j++) {
//				if(j + T[j] <= i) {
//					d[i] = Math.max(d[i], d[j] + P[i]);
//				}
//			}
//		}
		
		int result = 0;
		for(int i = 1; i <= N + 1; i++) {
			result = Math.max(result, d[i]);
			if(i + T[i] - 1 <= N) {
				d[i + T[i]] = Math.max(d[i + T[i]], result + P[i]);
				//d[i + T[i]] = Math.max(d[i + T[i]], d[i] + P[i]);
			}
		}
		
//		for(int i = 1; i <= N + 1; i++) {
//			//if(i + T[i] - 1 <= N)
//			result = Math.max(result, d[i]);
//			System.out.println(d[i]);
//		}
		
		System.out.println(result);
	}

}
