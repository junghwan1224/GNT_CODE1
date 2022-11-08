package ps1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.concurrent.CompletableFuture;

/*
 * https://www.acmicpc.net/problem/1197
 * 최소 스패닝 트리
 * */
class Node {
	int a;
	int b;
	int c;
	
	public Node(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
}

public class Main {
	static int V;
	static int E;
	static Node[] list;
	static int[] parent;
	static Comparator<Node> comp = new Comparator<Node>() {
		@Override
		public int compare(Node n1, Node n2) {
			return n1.c - n2.c;
		}
	}; 
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parent = new int[10001];
		list = new Node[E];
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[i] = new Node(a, b, c);
		}
		
		for(int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		Arrays.sort(list, comp);
		
		for(int i = 0; i < E; i++) {
			if(! isSameParent(list[i].a, list[i].b)) {
				union(list[i].a, list[i].b);
				result += list[i].c;
			}
		}
		
		System.out.println(result);
	}

	public static int find(int x) {
		if(parent[x] == x)
			return x;
		else
			return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y)
			parent[x] = y;
	}
	
	public static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y)
			return true;
		else
			return false;
	}
}
