package ps2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
* https://www.acmicpc.net/problem/2512
* 예산
* */
public class Main {
	static int n;
	static int m;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		m = Integer.parseInt(br.readLine());
		
		int low = 987654321;
		int high = 0;
		long sum = 0;
		for(int i = 0; i < n; i++) {
			low = Math.min(low, arr[i]);
			high = Math.max(high, arr[i]);
			sum += arr[i];
		}
		
		if(sum <= m)
			System.out.println(high);
		else {		
			low = 0;
			while(low <= high) {
				int mid = (low + high) / 2;
				//System.out.println(mid);
				
				// 상한액(mid)를 가지고, 배정된 예산을 모두 더해서 m보다 작거나 같으면 low값을 mid로 변경
				// 상한액이 지방의 예산보다 큰 경우에는 지방의 예산으로 계산 
				long s = 0;
				for(int i = 0; i < n; i++) {
					if(mid < arr[i])
						s += mid;
					else
						s += arr[i];
				}
				
				if(s <= m) {
					low = mid + 1;
				}
				else {
					high = mid - 1;
				}
			}
			
			System.out.println(high);
		}
	}

}
