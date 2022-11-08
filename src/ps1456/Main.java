package ps1456;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1456
 * 거의 소수
 * */
public class Main {
	static long A;
	static long B;
	static int[] arr;
	static int RANGE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		RANGE = 10000001;
		arr = new int[RANGE];
		
		// 에라토스테네스의 체로 소수 판별 
		for(int i = 1; i < RANGE; i++)
			arr[i] = i;
		
		for(int i = 2; i < RANGE; i++) {
			if(arr[i] == 0)
				continue;
			
			for(int j = i + i; j < RANGE; j += i) 
				arr[j] = 0;
		}
		
		int cnt = 0;
		long limit = 100000000000000L;
		for(int i = 2; i < RANGE; i++) {
			// 어떤 수의 제곱이 B보다 커진다면 더 순회할 필요 없으므로 반복문 종료 
			if((long)i * (long)i > B)
				break;
			
			// 현재 탐색중인 수가 소수라면 
			if(arr[i] != 0) {
				// n = 거의 소수 
				long n = (long)i * (long)i;
				
				// B보다 작거나 같을 때 까지 순회 
				while(n <= B) {
					// 거의 소수가 A보다 크거나 같으면 가짓수 1 더해줌 
					if(A <= n)
						cnt++;
					// 다음 거의 소수 확인 
					n *= (long)i;
					// 거의 소수인 값이 long 범위 벗어나면? 루프 종료 
					if(n % (long)i != 0)
						break;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
