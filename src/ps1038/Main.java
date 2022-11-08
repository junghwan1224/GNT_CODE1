package ps1038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * https://www.acmicpc.net/problem/1038
 * 감소하는 수
 * */
public class Main {
	static int N;
	static Queue<Long> que;
	static long[] arr;
	static int idx;
	static int MAX = 1000001;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new long[MAX];
		que = new LinkedList<Long>();
		for(int i = 0; i < 10; i++) {
			arr[i] = i;
			que.add((long)i);
		}
		idx = 10;
		
		while(idx < MAX && ! que.isEmpty()) {
			long cur = que.poll();
			long last = cur % 10;
			
			for(int i = 0; i < last; i++) {
				long next = cur * 10 + (long)i;
				arr[idx++] = next;
				que.add(next);
			}
		}
		
		if(arr[N] == 0 && N >= 1023)
			System.out.println(-1);
		else
			System.out.println(arr[N]);
	}

}
