package ps2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2493
 * 탑
 * */
class Node {
	int idx;
	int height;
	
	public Node(int idx, int height) {
		this.idx = idx;
		this.height = height;
	}
}

public class Main {
	static int N;
	static int[] arr;
	static int[] result;
	static Stack<Node> stack;
	static Stack<Node> tmp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		result = new int[N];
		stack = new Stack<Node>();
		tmp = new Stack<Node>();
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			//stack.add(new Node(i, arr[i]));
		}
		//stack.pop(); // 맨 마지막부터 탐색하니까 마지막 원소는 본인의 값을 볼 필요가 없으므로 제거 
		
//		for(int i = N - 1; i >= 0; i--) {
//			while(! stack.isEmpty()) {
//				Node cur = stack.peek();
//				if(arr[i] <= cur.height) {
//					result[i] = cur.idx + 1;
//					break;
//				}
//				else {
//					tmp.add(stack.pop());
//				}
//			}
//			
//			while(! tmp.isEmpty())
//				stack.add(tmp.pop());
//			
//			// 본인의 값을 볼 필요가 없으므로 제거 
//			if(! stack.isEmpty())
//				stack.pop();
//		}
		
		for(int i = 0; i < N; i++) {
			while(! stack.isEmpty()) {
				Node cur = stack.peek();
				if(arr[i] <= cur.height) {
					result[i] = cur.idx + 1;
					break;
				}
				else {
					stack.pop();
				}
			}
			
			stack.push(new Node(i, arr[i]));
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < N; i++)
			sb.append(result[i]).append(" ");
		System.out.println(sb);
	}
}
