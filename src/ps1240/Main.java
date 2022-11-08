package ps1240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1240
 * 노드사이의 거리
 * https://blog.naver.com/PostView.naver?blogId=adamdoha&logNo=221968153442&parentCategoryNo=&categoryNo=67&viewDate=&isShowPopularPosts=false&from=postView
 * https://loosie.tistory.com/517
 * */
class Node {
	int to;
	int dist;
	
	public Node(int to, int dist) {
		this.to = to;
		this.dist = dist;
	}
}
public class Main {

	/* 노드와 거리 값을 저장할 리스트. */
	static ArrayList<Node>[] NodeList;
	public static int answer;
	
	/* 플로이드 와샬 알고리즘 구현시 사용되는 배열. graph[i][j] = i에서 출발하여 j까지의 거리. */
	public static int[][] graph;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		/* 리스트 초기화. */
		NodeList = new ArrayList[n+1];
		for(int i = 1; i <= n; i++) {
			NodeList[i] = new ArrayList<Node>();
		}
		
		/*
		 * 플로이드 와샬 알고리즘 로직, 그래프 최댓값으로 초기화.
		graph = new int[1001][1001];
		
		for(int i = 1; i <= 1000; i++)
			for(int j = 1; j <= 1000; j++)
				graph[i][j] = 100000001;
		*/
		
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			/* 노드의 데이터와 거리 저장. */
			/* 양방향이므로 시작점, 도착점 바꿔서 저장. */
			NodeList[n1].add(new Node(n2, d));
			NodeList[n2].add(new Node(n1, d));
			 
			/*
			 * 플로이드 와샬 알고리즘 로직, 노드간 거리 초기화.
			 * */
			// graph[n1][n2] = d;
			// graph[n2][n1] = d;
		}
		
		/*
		 * 플로이드 와샬 알고리즘. 시작점(i)와 도착점(j)사이의 거리를 거쳐가는 지점(k)를 거쳐갈 때의 거리 비교 및 최솟값 갱신.
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(graph[i][j] > graph[i][k] + graph[k][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
		}
		*/
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			dfs(n1, 0, n2, 0);
			System.out.println(answer);
		}
	}
	
	/*
	 * @Integer start 시작 노드.
	 * @Integer prev 이전 노드.
	 * @Integer dest 목적지 노드.
	 * @Integer distance 시작 노드부터 현재 위치 노드까지의 거리.
	 * */
	public static void dfs(int start, int prev, int dest, int distance) {
		/* 목적지에 도달했으면 answer에 계산된 거리 저장 후 dfs 종료. */
		if(start == dest) {
			answer = distance;
			return;
		}
		
		/* 노드 순회하면서 탐색. */
		for(Node next: NodeList[start]) {
			/* 다음 탐색 노드가 이전 노드면 DFS를 하지 않는다. */
			if(next.to == prev)
				continue;
			/* 다음 노드를 시작으로 해서 다음 노드의 거리를 더해준 상태로 새롭게 탐색 시작. */
			dfs(next.to, start, dest, distance + next.dist);
		}
	}

}
