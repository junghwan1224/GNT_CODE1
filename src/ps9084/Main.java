package ps9084;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/9084
 * 동전
 * */
public class Main {
	
	static int T;
	static int N;
	static int M;
	static int[] coin;
	static int[] d; // d[m] = n. m원을 만들 수 있는 동전의 가짓수는 n이다.

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		while(T > 0) {
			N = Integer.parseInt(br.readLine());
			coin = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				coin[i] = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(br.readLine());
			
			d = new int[M + 1];
			
			d[0] = 1;
			
			// 이 문제에서는 잘못된 접근.
//			for(int i = 1; i < M + 1; i++) {
//				for(int j = 0; j < N; j++) {
//					if(i - coin[j] > 0) {
//						d[i] += d[i - coin[j]];
//					}
//				}
//			}
			
			// i = 동전 인덱스.
			// j = 금액.
			// i와 j를 바꾸면 중복된 케이스(순서가 달라도 경우의 수를 다르게 인식)도 존재하기 때문에 위처럼 설정.
			for(int i = 0; i < N; i++) {
				// 동전의 금액이 M보다 크 문제에서 요구하는 경우의 수에 포함될 수 없으므로, 작거나 같은 값만 포함.
				// 해당 금액의 동전 하나로 주어진 금액을 만들 수 있으므로 경우의 수 1 더해줌.
				if(coin[i] <= M)
					d[coin[i]] += 1;
				for(int j = 1; j < M + 1; j++) {
					if(j - coin[i] > 0) {
						// j원에서 coin[i]원을 뺀 값이 0보다 크다면.
						// j원을 만들 수 있는 경우의 수 안에는 (j - coin[i])원을 만들 수 있는 경우의 수도 포함되어 있으므로.
						// 해당 경우의 수도 더해준다. (j - coin[i])원에 coin[i]원만 더해주면 되니까.
						d[j] += d[j - coin[i]];
					}
				}
			}
			
			System.out.println(d[M]);
			
			T--;
		}
	}

}
