package ps2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2015
 * 수들의 합 4
 * https://skdltm117.tistory.com/36
 * description: https://ongveloper.tistory.com/215
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N + 1];
		int[] S = new int[N + 1];
		long result = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i < N + 1; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			S[i] = S[i - 1] + A[i];
		}
		
		// key: 누적합, value: 갯수
		Map<Integer, Long> map = new HashMap<Integer, Long>();
		
		for(int i = 1; i < N + 1; i++) {
			if(S[i] == K)
				result++;
			
			if(map.containsKey(S[i] - K))
				result += map.get(S[i] - K);
			
			
			if(map.containsKey(S[i]))
				map.put(S[i], map.get(S[i]) + 1);
			else
				map.put(S[i], 1L);
		}
		
		System.out.println(result);
	}

}
