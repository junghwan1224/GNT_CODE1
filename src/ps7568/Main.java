package ps7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/7568
 * */

class Node {
	int w;
	int h;
	
	public Node(int w, int h) {
		this.w = w;
		this.h = h;
	}
}

public class Main {
	static int N;
	static Node[] arr;
	static int[] result;
	static StringBuffer sb;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new Node[N];
		result = new int[N];
		sb = new StringBuffer();
		
		StringTokenizer st = null;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			arr[i] = new Node(w, h);
		}
		
		for(int i = 0; i < N; i++) {
			int cnt = 0;
			for(int j = 0; j < N; j++) {
				if(i == j)
					continue;
				
				if(arr[i].w < arr[j].w && arr[i].h < arr[j].h) {
					cnt++;
				}
			}
			result[i] = cnt + 1;
		}
		
		for(int i = 0; i < N; i++)
			sb.append(result[i]).append(" ");
		
		System.out.println(sb);
	}

}
