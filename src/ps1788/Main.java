package ps1788;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/1788
 * 피보나치 수의 확장
 * */
public class Main {
	static int n;
	static int mod = 1000000000;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		int a = 0;
		int b = 1;
		int i = 0;
		/*
		 * 0 이상일 때 피보나치 수 구하는 식 
		 * f(n) = f(n - 1) + f(n - 2)
		 * */
		if(n >= 0) {
			while(i < n) {
				int tmp = a;
				a = (a + b) % mod;
				b = tmp;
				i++;
			}
		}
		/*
		 * 음수 피보나치 수 구하는 식 
		 * f(n) = f(n + 2) - f(n + 1)
		 * */
		else {
			while(i > n) {
				int tmp = a;
				a = (b - a) % mod;
				b = tmp;
				i--;
			}
		}
		
		int c = 1;
		if(a == 0)
			c = 0;
		else if(a < 0)
			c = -1;
		else
			c = 1;
		
		System.out.println(c);
		System.out.println(Math.abs(a));
	}

}
