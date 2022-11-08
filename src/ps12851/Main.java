package ps12851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/12851
 * 숨바꼭질 2
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
	static int MAX = 100000;
	static int LIMIT_VAL = 987654321;
	
	static boolean[] visit;
	static Queue<Node> que;
	
	static int resultTime = LIMIT_VAL; // 동생을 찾는 가장 빠른 시간 
	static int resultCnt = 0; // 동생을 찾는 방법의 수 

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visit = new boolean[MAX + 1];
		
		que = new LinkedList<Node>();
		que.add(new Node(N, 0));
		
		while(! que.isEmpty()) {
			Node cur = que.poll();
			
			visit[cur.pos] = true; 
			
			// 가장 빠른 시간을 찾았고, 그 이후에 다른 경로지만 기존에 찾았던 가장 빠른 시간으로 동생을 찾았을 경우 
			if(resultTime == cur.time && cur.pos == K) {
				resultCnt++;
			}
			
			// 최초로 동생한테 도달했을 때 시간 저장한다. 이 경우 가장 빠른 시간이기 때문.
			// 방법의 수도 1 더해준다.
			if(resultTime == LIMIT_VAL && cur.pos == K) {
				resultTime = cur.time;
				resultCnt++;
			}
			
			if(cur.pos - 1 >= 0 && ! visit[cur.pos - 1]) {
				que.add(new Node(cur.pos - 1, cur.time + 1));
			}
			
			if(cur.pos + 1 <= MAX && ! visit[cur.pos + 1]) {
				que.add(new Node(cur.pos + 1, cur.time + 1));
			}
			
			if(cur.pos * 2 <= MAX && ! visit[cur.pos * 2]) {
				que.add(new Node(cur.pos * 2, cur.time + 1));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(resultTime);
		sb.append("\n");
		sb.append(resultCnt);
		
		System.out.println(sb);
	}

}
