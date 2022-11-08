package ps1446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1446
 * 지름길
 * */
class Node {
	int start;
	int dist;
	
	public Node(int start, int dist) {
		this.start = start;
		this.dist = dist;
	}
}

public class Main {
	static int N;
	static int D;
	static int[] dist;
	static ArrayList<Node>[] list;
	static int MAX = 10010;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		dist = new int[MAX];
		list = new ArrayList[MAX];
		for(int i = 0; i < MAX; i++)
			list[i] = new ArrayList<Node>();
		
		// dist[i] = 길 i로 가는 최소 비용
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			// 도착지점이 D보다 크거나 지름길이 아닐 경우(목적지 - 시작점의 거리보다 입력받은 지름길 거리 값이 더 큰 경우)는 건너뛴다 
			if(end > D || end - start < dist)
				continue;
			
			list[end].add(new Node(start, dist));
		}
		
		for(int i = 1; i <= D; i++) {
			// 지름길 탐색하기 전, 거리 i까지 탐색했을 때 거리는 i-1까지 온 거리에 1 더한 거리 
			dist[i] = dist[i - 1] + 1;
			
			// 도착지에 대한 지름길이 있을 경우 거리 갱신 가능한지 확인 
			for(Node node: list[i]) {
				dist[i] = Math.min(dist[i], dist[node.start] + node.dist);
			}
		}
		
		System.out.println(dist[D]);
	}

}
 