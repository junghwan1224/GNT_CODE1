package ps21921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/21921
 * 블로그
 * */
public class Main {
	static int N;
	static int X;
	static int[] arr;
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int sum = 0;
		int cnt = 0;
		int start = 0;
		
		
		// 최댓값 구하기 
		for(int end = 0; end < N; end++) {
			sum += arr[end];
			
			if(end >= X - 1) {
				result = Math.max(result, sum);
				
				sum -= arr[start];
				start++;
				
			}
		}
		
		// 최댓값이 존재하는 구간 갯수 구하기 
		start = 0;
		sum = 0;
		for(int end = 0; end < N; end++) {
			sum += arr[end];
			
			if(end >= X - 1) {
				if(sum == result) {
					cnt++;
				}
				
				sum -= arr[start];
				start++;
				
			}
		}
		
		if(result == 0)
			System.out.println("SAD");
		else {
			System.out.println(result);
			System.out.println(cnt);
		}
	}

}
