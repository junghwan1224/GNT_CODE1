package ps13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/13549
 * 숨바꼭질 3
 * */
class Node {
	int pos;
	int time;
	
	public Node(int pos, int time) {
		this.pos = pos;
		this.time = time;
	}
}

public class Main {
	static int N;
	static int K;
	static Deque<Node> que;
	static int MAX = 100001;
	static boolean[] visit;
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		que = new LinkedList<Node>();
		visit = new boolean[MAX];
		visit[N] = true;
		que.addFirst(new Node(N, 0));
		
		while(! que.isEmpty()) {
			Node cur = que.pollFirst();
			
			if(cur.pos == K) {
				result = cur.time;
				break;
			}
			
			if(cur.pos * 2 < MAX && ! visit[cur.pos * 2]) {
				visit[cur.pos * 2] = true;
				que.addFirst(new Node(cur.pos * 2, cur.time));
			}
			
			if(cur.pos - 1 >= 0 && ! visit[cur.pos - 1]) {
				visit[cur.pos - 1] = true;
				que.addLast(new Node(cur.pos - 1, cur.time + 1));
			}
			
			if(cur.pos + 1 < MAX && ! visit[cur.pos +1]) {
				visit[cur.pos + 1] = true;
				que.addLast(new Node(cur.pos + 1, cur.time + 1));
			}
		}
		
		System.out.println(result);
	}

}
