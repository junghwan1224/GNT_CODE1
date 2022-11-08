package ps22862;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/22862
 * 가장 긴 짝수 연속한 부분 수열 (large)
 * */
public class Main {
	static int[] arr;
	static int result;
	static int p1; // 투포인터 시작점.
	static int p2; // 투포인터 끝점.

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 투포인터의 시작점과 끝점을 첫 인덱스로 초기화.
		p1 = 0;
		p2 = 0;
		// 제거한 홀수의 갯수를 저장하는 변수.
		int oddCnt = 0;
		
		// 반복문 시작. 투포인터의 인덱스가 n-1을 초과하면 안됨.
		while(p1 < n && p2 < n) {
			// 제거하는 수는 홀수이어야 연속된 짝수의 수열의 최대 길이를 구할 수 있기 때문에 홀수를 제거한다.
			// 제거한 홀수의 갯수가 k개 이하인 경우.
			if(oddCnt <= k) {
				// 끝점 인덱스의 수가 홀수면, 제거한 홀수의 수 1 증가.
				if(arr[p2] % 2 == 1) {
					oddCnt++;
				}
				// 끝점 인덱스 +1
				p2++;
			}
			
			// k개의 수를 모두 제거했을 경우.
			else {
				// 시작점의 인덱스를 +1 해준다.
				// 시작점에 해당하는 수가 홀수라면, 제거한 홀수의 수를 1 더해준다.(1만큼 원상복구)
				if(arr[p1] % 2 == 1) {
					oddCnt--;
				}
				p1++;
			}
			
			// 홀수를 제거하는 작업을 수행하면서, 짝수로 이루어진 연속한 부분수열의 최대 길이값 갱신.
			result = Math.max(result, (p2 - p1 + 1 - oddCnt));
		}
		
		// p2의 값이 1 증가한 상태에서 구간 값을 계산하기 때문에, 최종 결과값에 1 뺀다.
		System.out.println(result - 1);
	}
}
