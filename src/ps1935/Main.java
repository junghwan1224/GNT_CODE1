package ps1935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * https://www.acmicpc.net/problem/1935
 * 후위 표기식2
 * */
public class Main {
	static int N;
	static char[] chr;
	static Map<Integer, Integer> map;
	static Stack<Double> stack;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		chr = br.readLine().toCharArray();
		map = new HashMap<Integer, Integer>();
		stack = new Stack<Double>();
		
		for(int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			map.put(i, a);
		}
		
		for(int i = 0; i < chr.length; i++) {
			if(chr[i] == '+' || chr[i] == '-' || chr[i] == '*' || chr[i] == '/') {
				double a = stack.pop();
				double b = stack.pop();
				double c = 0.0;
				
				if(chr[i] == '+')
					c = b + a;
				else if(chr[i] == '-')
					c = b - a;
				else if(chr[i] == '*')
					c = b * a;
				else
					c = b / a;
				
				stack.push(c);
			}
			else {
				//System.out.println(map.get(chr[i] - 65));
				stack.push((double)map.get(chr[i] - 65));
			}
		}
		
		System.out.printf("%.2f", stack.peek());
	}

}
