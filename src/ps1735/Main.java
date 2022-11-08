package ps1735;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1735
 * 분수 합
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a1 = Integer.parseInt(st.nextToken()); // 분자 
		int b1 = Integer.parseInt(st.nextToken()); // 분모 
		
		st = new StringTokenizer(br.readLine());
		int a2 = Integer.parseInt(st.nextToken());
		int b2 = Integer.parseInt(st.nextToken());
		
		int b = b1 * b2;
		int a = (a1 * b2) + (a2 * b1);
		
		int g = gcd(a, b);
		
		a /= g;
		b /= g;
		
		System.out.print(a + " " + b);
	}

	public static int gcd(int a, int b) {
		int tmp = 0;
		int n = 0;
		
		if(a < b) {
			tmp = a;
			a = b;
			b = tmp;
		}
		
		while(b != 0) {
			n = a % b;
			a = b;
			b = n;
		}
		
		return a;
	}
}
