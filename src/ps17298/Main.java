package ps17298;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/17298
 * 오큰수
 * */

class Node {
	int idx;
	int val;
	
	public Node(int idx, int val) {
		this.idx = idx;
		this.val = val;
	}
}

class Ascending implements Comparator<Node> {
	@Override
	public int compare(Node n1, Node n2) {
		return n1.idx - n2.idx;
	}
}

public class Main {
	
	static int N;
	static int[] A;
	static int[] result;
	static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		A = new int[N];
		result = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		// 오큰수가 없으면 -1이므로 처음부터 모든 원소를 -1로 초기화 
		for(int i = 0; i < N; i++)
			result[i] = -1;
		
		stack = new Stack<Integer>();
		
		for(int i = N - 1; i >= 0; i--) {
			// 스택이 비어있으면 비교할 수 없으므로 현재 탐색중인 원소 스택에 넣고 패스 
			if(stack.empty()) {
				stack.push(A[i]);
				continue;
			}
			
			// 스택이 비어있지 않으면 
			while(! stack.empty()) {
				// 스택의 top 값이 현재 원소보다 크면 
				if(stack.peek() > A[i]) {
					// 현재 원소의 오큰수이므로 result에 저장 
					result[i] = stack.peek();
					break;
				}
				
				// 스택의 top 값이 현재 원소보다 작으면 스택 top 제거 
				stack.pop();
			}
			// 오큰수 탐색 마치면 현재 비교하는 원소 스택에 추가 
			stack.push(A[i]);
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 0; i < N; i++) {
			bw.write(Integer.toString(result[i]));
			bw.write(" ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	
}
