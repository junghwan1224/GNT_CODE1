package ps9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * https://www.acmicpc.net/problem/9012
 * 괄호
 * */
public class Main {
	static int T;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		for(int t = 0; t < T; t++) {
			String str = br.readLine();
			String answer = "YES";
			Stack<Character> stack = new Stack<Character>();
			
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if(ch == '(')
					stack.push(ch);
				else if(ch == ')')
					if(stack.isEmpty()) {
						answer = "NO";
					}
					else
						stack.pop();
			}
			
			if(! stack.isEmpty())
				answer = "NO";
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
	}

}
