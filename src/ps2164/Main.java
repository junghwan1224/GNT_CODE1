package ps2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/*
 * https://www.acmicpc.net/problem/2164
 * 카드2
 * */
public class Main {
	static int n;
	static Deque<Integer> deq;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		deq = new LinkedList<Integer>();
		
		for(int i = 1; i <= n; i++)
			deq.add(i);
		
		while(! deq.isEmpty()) {
			if(deq.size() == 1)
				break;
			
			deq.pollFirst();
			deq.add(deq.pollFirst());
		}
		
		System.out.println(deq.pollFirst());
	}

}
