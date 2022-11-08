package ps12026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/12026
 * BOJ 거리
 * https://simju9397.tistory.com/28
 * */
public class Main {
	static int n;
	static char[] str;
	static char cur;
	static int[] d;
	static int result;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		str = br.readLine().toCharArray();
		
		d = new int[str.length];
		for(int i = 0; i < str.length; i++)
			d[i] = Integer.MAX_VALUE;
		
		dp();
		
		System.out.println(result);
	}

	public static void dp() {
		if(str[0] != 'B') {
			result = -1;
			return;
		}
		
		d[0] = 0;
//		for(int i = 0; i < n - 1; i++) {
//			cur = str[i];
//			if(cur == 'B') {
//				for(int j = i + 1; j < n; j++) {
//					if(str[j] == 'O') {
//						d[j] = (int) Math.min(d[j], d[i] + Math.pow((j - i), 2));
//					}
//				}
//			}
//			
//			else if(cur == 'O') {
//				for(int j = i + 1; j < n; j++) {
//					if(str[j] == 'J') {
//						d[j] = (int) Math.min(d[j], d[i] + Math.pow((j - i), 2));
//					}
//				}
//			}
//			
//			else { // cur == 'J'
//				for(int j = i + 1; j < n; j++) {
//					if(str[j] == 'B') {
//						d[j] = (int) Math.min(d[j], d[i] + Math.pow((j - i), 2));
//					}
//				}
//			}
//		}
		
		for(int i = 1; i < n; i++) {
			cur = str[i];
			if(cur == 'B') {
				for(int j = 0; j < i; j++) {
					if(str[j] == 'J') {
						d[i] = (int) Math.min(d[i], d[j] + Math.pow((i - j), 2));
					}
				}
			}
			
			else if(cur == 'O') {
				for(int j = 0; j < i; j++) {
					if(str[j] == 'B') {
						d[i] = (int) Math.min(d[i], d[j] + Math.pow((i - j), 2));
					}
				}
			}
			
			else { // cur == 'J'
				for(int j = 0; j < i; j++) {
					if(str[j] == 'O') {
						d[i] = (int) Math.min(d[i], d[j] + Math.pow((i - j), 2));
					}
				}
			}
		}
		
		if(d[n - 1] == Integer.MAX_VALUE)
			result = -1;
		else
			result = d[n - 1];
		return;
	}
}
