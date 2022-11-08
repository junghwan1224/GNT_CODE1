package ps11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/11725
 * 트리의 부모 찾기
 * */
public class Main {
	static int n;
	static ArrayList<Integer>[] list;
	static int[] parent;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n + 1];
		parent = new int [n + 1];
		visit = new boolean[n + 1];
		
		for(int i = 0; i < n + 1; i++)
			list[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		dfs(1);
		
		StringBuffer sb = new StringBuffer();
		for(int i = 2; i <= n; i++)
			sb.append(parent[i]).append("\n");
		
		System.out.println(sb);
	}

	public static void dfs(int node) {
		visit[node] = true;
		
		for(int i = 0; i < list[node].size(); i++) {
			int next = (int)list[node].get(i);
			
			if(! visit[next]) {
				parent[next] = node;
				dfs(next);
			}
		}
	}
}
