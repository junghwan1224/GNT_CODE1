package ps11653;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/11653
 * 소인수분해
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] prime = new int[n + 1];
		for(int i = 2; i < n + 1; i++)
			prime[i] = i;
		
		for(int i = 2; i < n + 1; i++) {
			if(prime[i] == 0)
				continue;
			for(int j = i + i; j < n + 1; j += i)
				prime[j] = 0;
		}
		
		StringBuffer sb = new StringBuffer();
		
		int tmp = n;
		for(int i = 2; i < n + 1; i++) {
			if(tmp == 1)
				break;
			if(prime[i] == 0)
				continue;
			
			if(tmp % i == 0) {
				while(tmp % i == 0) {
					sb.append(i).append("\n");
					tmp /= i;
				}
			}
		}
		
		System.out.println(sb);
	}

}
