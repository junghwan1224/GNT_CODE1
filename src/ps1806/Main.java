package ps1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1806
 * 부분합
 * */
public class Main {
	static int N;
	static int S;
	static int MAX = 100001;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[MAX];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int len = MAX;
		
		while(true) {
			if(sum >= S)
				sum -= arr[start++];
			
			else if(end >= N)
				break;
			
			else if(sum < S)
				sum += arr[end++];
			
			if(sum >= S)
				len = Math.min(len, (end - start));
		}
		
		len = (len == MAX) ? 0 : len;
		System.out.println(len);
	}

}
