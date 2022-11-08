package ps16401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/16401
 * 과자 나눠주기
 * */
public class Main {
	static int M;
	static int N;
	static int low = 987654321;
	static int high = -1;
	static int[] cookie;
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		cookie = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			cookie[i] = Integer.parseInt(st.nextToken());
			low = 1;//Math.min(low, cookie[i]);
			high = Math.max(high, cookie[i]);
		}
		
		while(low <= high) {
			int mid = (low + high) / 2;
			
			int cnt = 0;
			for(int i = 0; i < N; i++) {
//				if(cookie[i] >= mid)
//					cnt++;
				cnt += cookie[i] / mid;
			}
			
			if(cnt >= M) {
				result = Math.max(result, mid);
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
		
		System.out.println(result);
	}

}
