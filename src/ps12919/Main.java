package ps12919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/12919
 * A와 B 2
 * */
public class Main {
	static String S;
	static String T;
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();
		
		recursive(S, T);
		
		System.out.println(result);
	}
	
	public static void recursive(String start, String target) {
		if(start.length() == target.length()) {
			if(start.equals(target)) {
				result = 1;
				return;
			}
		}
		
		if(start.length() > target.length())
			return;
		
		if(target.charAt(target.length() - 1) == 'A') {
			recursive(start, target.substring(0, target.length() - 1));
		}
		
		if(target.charAt(0) == 'B') {
			String tmp = target.substring(1, target.length());
			StringBuffer sb = new StringBuffer(tmp);
			tmp = sb.reverse().toString();
			recursive(start, tmp);
		}
	}
}
