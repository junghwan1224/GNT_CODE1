package ps2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2075
 * N번째 큰 수
 * */
class Node implements Comparable<Node> {
	int num;
	
	public Node(int num) {
		this.num = num;
	}
	
	@Override
	public int compareTo(Node a) {
		return this.num - a.num;
	}
}

public class Main {
	static int n;
	static PriorityQueue<Node> pque;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
//		int[] arr = new int[n * n];
//		for(int i = 0; i < n; i++) {
//			st = new StringTokenizer(br.readLine());
//			for(int j = i * n; j < (i * n) + n; j++) {
//				arr[j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		
//		Arrays.sort(arr);
//		
//		System.out.println(arr[(n * n - 1) - (n - 1)]);
		
		pque = new PriorityQueue<Node>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				pque.add(new Node(Integer.parseInt(st.nextToken())));
			}
			
			while(pque.size() > n)
				pque.poll();
		}
		
		System.out.println(pque.peek().num);
	}

}
