package ps1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1978
 * 소수 찾기
 * */
public class Main {
	static int MAX = 1001;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] prime = new int[MAX];
		for(int i = 2; i < MAX; i++) {
			prime[i] = i;
		}
		
		for(int i = 2; i < Math.sqrt(MAX); i++) {
			if(prime[i] == 0)
				continue;
			for(int j = i * i; j < MAX; j += i) {
				prime[j] = 0;
			}
		}
		
		int result = 0;
		for(int i = 0; i < N; i++) {
			if(prime[arr[i]] != 0)
				result++;
		}
		System.out.println(result);
	}

}
