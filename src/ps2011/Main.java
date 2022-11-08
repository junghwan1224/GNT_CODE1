package ps2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/2011
 * 암호코드
 * */
public class Main {
	static char[] str;
	static int n;
	static int[] d;
	static int MOD = 1000000;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine().toCharArray();
		n = str.length;
		int[] arr = new int[n + 1];
		d = new int[n + 1];
		
		int tmp = Integer.parseInt("" + str[0]);
		if(1 <= tmp && tmp <= 9)
			d[0] = 1;
		
		if(n >= 2) {
			tmp = Integer.parseInt("" + str[1]);
			if(1 <= tmp && tmp <= 9)
				d[1] = d[0] % MOD;
			
			tmp = Integer.parseInt("" + str[0] + str[1]);
			if(10 <= tmp && tmp <= 26)
				d[1] = (d[1] + 1) % MOD;
		}
		
		for(int i = 2; i < n; i++) {
			tmp = Integer.parseInt("" + str[i]);
			if(1 <= tmp && tmp <= 9)
				d[i] = (d[i] + d[i - 1]) % MOD;
			
			if(str[i - 1] != '0') {
				tmp = Integer.parseInt("" + str[i - 1] + str[i]);
				//System.out.println(a);
				if(10 <= tmp && tmp <= 26)
					d[i] = (d[i] + d[i - 2]) % MOD;
			}
		}
		
//		for(int i = 1; i <= n; i++) {
//			arr[i] = Integer.parseInt("" + str[i - 1]);
//		}
//		
//		for(int i = 1; i <= n; i++) {
//			if(1 <= arr[i] && arr[i] <= 9)
//				d[i] = (d[i] + d[i - 1]) % MOD;
//			
//			if(arr[i - 1] != 0 && i > 1) {
//				int tmp = arr[i - 1] * 10 + arr[i];
//				//System.out.println(a);
//				if(10 <= tmp && tmp <= 26)
//					d[i] = (d[i] + d[i - 2]) % MOD;
//			}
//		}
		
		for(int i = 0; i <= n; i++)
			System.out.print(d[i] + " ");
	}

}
