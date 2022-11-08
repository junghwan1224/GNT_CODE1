package ps1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1260
 * DFS와 BFS
 * */
public class Main {
	static int N;
	static int M;
	static int V;
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static Queue<Integer> que;
	static StringBuffer sb;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		for(int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i = 1; i < N + 1; i++)
			Collections.sort(list[i]);
		
		sb = new StringBuffer();
		
		visit = new boolean[N + 1];
		dfs(V);
		sb.append("\n");
		bfs();
		
		System.out.println(sb);
	}

	public static void bfs() {
		que = new LinkedList<Integer>();
		visit = new boolean[N + 1];
		
		visit[V] = true;
		que.add(V);
		sb.append(V).append(" ");
		
		while(! que.isEmpty()) {
			int cur = que.poll();
			
			for(Integer i: list[cur]) {
				if(! visit[i]) {
					visit[i] = true;
					que.add(i);
					sb.append(i).append(" ");
				}
			}
		}
	}
	
	public static void dfs(int node) {
		visit[node] = true;
		sb.append(node).append(" ");
		
		for(Integer i: list[node]) {
			if(! visit[i]) {
				dfs(i);
			}
		}
	}
}
