package ps9020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * https://www.acmicpc.net/problem/9020
 * 골드바흐의 추측
 * */
public class Main {
	static int MAX = 10001;
	static int[] prime;
	static int N;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 에라토스테네스의 체
		prime = new int[MAX];
		for(int i = 2; i < MAX; i++)
			prime[i] = i;
		
		for(int i = 2; i < MAX; i++) {
			if(prime[i] == 0)
				continue;
			
			for(int j = i * 2; j < MAX; j += i)
				prime[j] = 0;
		}
		
		N = Integer.parseInt(br.readLine());
		
		while(N > 0) {
			// 입력한 짝수 
			int n = Integer.parseInt(br.readLine());
			// 골드바흐 파티션인 두 소수의 차 
			int diff = MAX;
			// 골드바흐 파티션 저장할 리스트 
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			for(int i = 2; i < MAX; i++) {
				// 탐색중인 수가 소수 아니면 패스 
				if(prime[i] == 0)
					continue;
				
				// 입력값 n에서 현재 탐색중인 소수 i를 뺀 값 
				int a = Math.abs(n - prime[i]);
				
				// a가 소수이면 골드바흐 파티션이다 
				if(prime[a] != 0) {
					// diff값이 초기값일 때, 즉 골드바흐 파티션을 최초로 찾아서 저장할 때 
					if(diff == MAX) {
						// 두 소수 저장 및 값의 차이 초기화 
						list.add(i);
						list.add(a);
						diff = Math.abs(a - i);
					}
					
					// 두번째 이후의 골드바흐 파티션을 찾았을 때 최솟값 및 골드바흐 파티션 갱신 
					else if(diff > Math.abs(a - i)) {
						list = new ArrayList<Integer>();
						list.add(i);
						list.add(a);
						diff = Math.abs(a - i);
					}
				}
			}
			
			// 출력을 위해 정렬 
			Collections.sort(list);
			
			System.out.println(list.get(0) + " " + list.get(1));
			
			N--;
		}
	}

}
