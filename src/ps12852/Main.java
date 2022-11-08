package ps12852;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * https://www.acmicpc.net/problem/12852
 * 1로 만들기 2
 * */
public class Main {
	// d[i] = 정수 i를 세가지 연산을 통해 1로 만들 수 있는 최소한의 경우의 수.
	static int[] d;
	static int n;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		d = new int[n + 1];
		
		for(int i = 2; i <= n; i++) {
			// 1을 뺀 경우의 수.
			d[i] = d[i - 1] + 1;
			
			// 2로 나누어 떨어졌을 때의 경우의 수가 최소인 경우 값 갱신.
			if(i % 2 == 0 && d[i] > d[i / 2] + 1 )
				d[i] = d[i / 2] + 1;
			
			// 3으로 나누어 떨어졌을 때의 경우의 수가 최소인 경우 값 갱신.
			if(i % 3 == 0 && d[i] > d[i / 3] + 1 )
				d[i] = d[i / 3] + 1;
		}
		
		System.out.println(d[n]);
		
		while(true) {
			// list.add(n);
			System.out.print(n + " ");
			
			if(n == 1)
				break;
			
			if(d[n] == d[n - 1] + 1)
				n = n - 1;
			else if(n % 2 == 0 && d[n] == d[n / 2] + 1)
				n /= 2;
			else if(n % 3 == 0 && d[n] == d[n / 3] + 1)
				n /= 3;
		}
		
	}
	

}
