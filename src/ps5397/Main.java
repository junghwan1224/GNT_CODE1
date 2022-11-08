package ps5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * https://www.acmicpc.net/problem/5397
 * 키로거
 * */
public class Main {
	static int T;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for (int t = 0; t < T; t++) {
			//String str = br.readLine();
			char[] str = br.readLine().toCharArray();
			
			Stack<Character> left = new Stack<Character>();
			Stack<Character> right = new Stack<Character>();

			for (int i = 0; i < str.length; i++) {
				//String s = str.substring(i, i + 1);
				char s = str[i];
				if (s == '<') {
					if(! left.isEmpty()) {
						right.push(left.pop());
					}
				} else if (s == '>') {
					if(! right.isEmpty()) {
						left.push(right.pop());
					}
				} else if (s == '-') {
					if(! left.isEmpty())
						left.pop();
				} else {
					
					left.push(s);
				}

			}
			
			while(!left.isEmpty()) { right.push(left.pop()); }
    		while(!right.isEmpty()) { sb.append(right.pop()); }
			
			sb.append("\n");

		}
		System.out.println(sb);
	}

}
