package ps12904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/12904
 * A와 B
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
		
//		while(true) {
//			if(S.length() == T.length()) {
//				if(S.equals(T))
//					result = 1;
//				break;
//			}
//			System.out.println(T);
//			
//			if(T.charAt(T.length() - 1) == 'A')
//				T = T.substring(0, T.length() - 1);
//			
//			else if(T.charAt(T.length() - 1) == 'B') {
//				T = T.substring(0, T.length() - 1);
//				StringBuffer sb = new StringBuffer(T);
//				String reverseT = sb.reverse().toString();
//				T = reverseT;
//			}
// 		}
		
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
		
		else if(target.charAt(target.length() - 1) == 'B') {
			String tmp = target.substring(0, target.length() - 1);
			StringBuffer sb = new StringBuffer(tmp);
			tmp = sb.reverse().toString();
			recursive(start, tmp);
		}
	}
}
