package ps2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2003
 * 수들의 합 2
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int ans = 0;
		
		/*
		 * 3 46
		 * 2 23 23
		 * output: 1
		 * */
		while(true) {
			if(sum >= M)
				sum -= arr[start++];
			
			else if(end >= N)
				break;
			
			else if(sum < M)
				sum += arr[end++];
			
			if(sum == M)
				ans++;
		}
		
		System.out.println(ans);
	}

}
