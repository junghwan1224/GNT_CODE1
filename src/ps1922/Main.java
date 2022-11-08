package ps1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1922
 * 네트워크 연결
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
	static int N;
	static int M;
	static int MAX = 987654321;
	static Node[] nodeList;
	static int[] parent; // i 노드의 부모 노드 
	static int answer;
	
	static Comparator<Node> comp = new Comparator<Node>() {
		@Override
		public int compare(Node n1, Node n2) {
			return n1.c - n2.c;
		}
	};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		nodeList = new Node[M];
		parent = new int[1001];
		
		for(int i = 1; i < 1001; i++)
			parent[i] = i; // 부모노드는 자기 자신으로 초기화 
		
		StringTokenizer st = null;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			nodeList[i] = new Node(a, b, c);
		}
		
		Arrays.sort(nodeList, comp);
		
		for(int i = 0; i < M; i++) {
			// 부모가 다르면 
			if(! isSameParent(nodeList[i].a, nodeList[i].b)) {
				// 두 노드를 합친다 
				union(nodeList[i].a, nodeList[i].b);
				
				// 합치고 난 후 결과값에 비용 더해줌 
				answer += nodeList[i].c;
			}
		}
		
		System.out.println(answer);
	}

	// 부모노드 찾기 
	public static int find(int x) {
		if(parent[x] == x)
			return x;
		else
			return parent[x] = find(parent[x]);
	}
	
	// 부모가 다를 경우 두 노드를 연결
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y)
			parent[y] = x;
	}
	
	// 부모가 같은 노드인지 확인 
	public static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y)
			return true;
		else
			return false;
	}
}
