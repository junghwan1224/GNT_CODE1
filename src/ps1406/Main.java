package ps1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1406
 * 에디터
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		int M = Integer.parseInt(br.readLine());
		
		Stack<Character> front = new Stack<Character>();
		Stack<Character> back = new Stack<Character>();
		
		for(int i = 0; i < str.length; i++)
			front.add(str[i]);
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			String s = "";
			if(cmd.equals("P"))
				s = st.nextToken();
			
			if(cmd.equals("L")) { 
				if(! front.isEmpty()) {
					char c = front.pop();
					back.add(c);
				}
			}
			
			else if(cmd.equals("D")) {
				if(! back.isEmpty()) {
					char c = back.pop();
					front.add(c);
				}
			}
			
			else if(cmd.equals("B")) {
				if(! front.isEmpty()) {
					front.pop();
				}
			}
			
			else {
				front.add(s.charAt(0));
			}
		}
		
		while(! front.isEmpty()) {
			back.add(front.pop());
		}
		
		StringBuffer sb = new StringBuffer();
		while(! back.isEmpty())
			sb.append(back.pop());
		
		System.out.println(sb);
	}

}
