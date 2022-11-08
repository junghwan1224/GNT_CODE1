package ps1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1238
 * 파티
 * */
class Node implements Comparable<Node> {
	int to;
	int time;
	
	public Node(int to, int time) {
		this.to = to;
		this.time = time;
	}
	
	@Override
	public int compareTo(Node node) {
		return this.time - node.time;
	}
}

public class Main {
	static int N;
	static int M;
	static int X;
	static ArrayList<Node>[] list;
	static ArrayList<Node>[] reverseList;
	static int[] dist;
	static int[] revDist;
	static boolean[] visit;
	static int MAX = 987654321;
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		reverseList = new ArrayList[N + 1];
		dist = new int[N + 1];
		revDist = new int[N + 1];
		
		for(int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<Node>();
			reverseList[i] = new ArrayList<Node>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			// 단방향이므로 다시 돌아오는 경우를 계산하기 위해 리스트 두 개 선언 
			list[from].add(new Node(to, time));
			reverseList[to].add(new Node(from, time));
		}
		
		int[] tmpList = new int[N + 1];
		for(int i = 1; i <= N; i++) {			
			bfs(list, dist, i);
			tmpList[i] = dist[X];
		}
		
		bfs(list, dist, X);
		for(int i = 1; i <= N; i++) {
			result = Math.max(result, tmpList[i] + dist[i]);
		}
		
//		int[] d2 = bfs2(reverseList, X);
//		for(int i = 1; i <= N; i++) {
//			int[] d1 = bfs2(list, X);
//			result = Math.max(result, d1[i] + d2[i]);
//		}
		
//		// x 마을에서 각자의 마을로 가는 다익스트라 
//		int[] d1 = bfs2(list, X);
//		// 각자의 마을에서 x로 가는 다익스트라 
//		/*
//		 * reverseList는 방향을 바꾼 리스트이므로, 
//		 * x마을에 대해 각 마을로의 경로 탐색을 하면, 곧 마을에서 x마을로 가는 최소 경로를 탐색한다는 뜻이다 
//		 * */
//		int[] d2 = bfs2(reverseList, X);
//		for(int i = 1; i <= N; i++)
//			result = Math.max(result, d1[i] + d2[i]);
		
		System.out.println(result);
	}

	public static void bfs(ArrayList<Node>[] nodeList, int[] distance, int start) {
		PriorityQueue<Node> pque = new PriorityQueue<Node>();
		visit = new boolean[N + 1];
		
		Arrays.fill(distance, MAX);

		pque.add(new Node(start, 0));
		distance[start] = 0;
		visit[start] = true;
		
		while(! pque.isEmpty()) {
			Node cur = pque.poll();
			
			for(Node node: nodeList[cur.to]) {
				int next = node.to;
				int nTime = node.time;
				
				int totTime = nTime + distance[cur.to];
				if(! visit[next] && totTime < distance[next]) {
					distance[next] = totTime;
					//visit[next] = true;
					pque.add(new Node(next, totTime));
				}
			}
		}
		
	}
	
	public static int[] bfs2(ArrayList<Node>[] nodeList, int start) {
		PriorityQueue<Node> pque = new PriorityQueue<Node>();
		visit = new boolean[N + 1];
		int[] distance = new int[N + 1];
		
		Arrays.fill(distance, MAX);

		pque.add(new Node(start, 0));
		distance[start] = 0;
		visit[start] = true;
		
		while(! pque.isEmpty()) {
			Node cur = pque.poll();
			
			for(Node node: nodeList[cur.to]) {
				int next = node.to;
				int nTime = node.time;
				
				int totTime = nTime + distance[cur.to];
				if(! visit[next] && totTime < distance[next]) {
					distance[next] = totTime;
					//visit[next] = true;
					pque.add(new Node(next, totTime));
				}
			}
		}
		
		return distance;
	}
}
