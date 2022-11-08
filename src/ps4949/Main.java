package ps4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * https://www.acmicpc.net/problem/4949
 * 균형잡힌 세상
 * [()][.
 * ([)]).
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuffer sb = new StringBuffer();
		while(! str.equals(".")) {
			String ans = "yes";
			Stack<Character> stack = new Stack<Character>();
			
			for(int i = 0; i < str.length() - 1; i++) {
				if(str.charAt(i) == '(' || str.charAt(i) == '[') {
					stack.push(str.charAt(i));
				}
				else if(str.charAt(i) == ')') {
					if(! stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					}
					else {
						ans = "no";
						break;
					}
				}
				else if(str.charAt(i) == ']') {
					if(! stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					}
					else {
						ans = "no";
						break;
					}
				}
				
				if(i == str.length() - 2) {
					if(stack.isEmpty())
						ans = "yes";
					else
						ans = "no";
				}
			}
			
//			if(! stack.isEmpty())
//				ans = "no";
			sb.append(ans).append("\n");
			
			str = br.readLine();
		}
		
		System.out.println(sb);
	}

}
