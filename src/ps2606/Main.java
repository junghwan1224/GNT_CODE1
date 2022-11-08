package ps2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
 * https://www.acmicpc.net/problem/2606
 * 바이러스
 * */
public class Main {
	/* 인접한 노드를 저장할 리스트. */
	static ArrayList<Integer>[] NodeList;
	/* 방문 여부. */
	static boolean[] visit;
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		NodeList = new ArrayList[n+1];
		visit = new boolean[n + 1];
		
		for(int i = 0; i <= n; i++) {
			NodeList[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st = null;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 양방향이기 때문에 시작점과 도착점 바꿔서 그래프 초기화.
			NodeList[a].add(b);
			NodeList[b].add(a);
		}
		
		// BFS 사용 위해 큐 선언.
		Queue<Integer> q = new LinkedList<Integer>();
		
		// 시작점은 1이므로 큐에 초기값으로 1 추가.
		q.add(1);
		// 1번 노드 방문처리.
		visit[1] = true;
		while(! q.isEmpty()) {
			int cur = q.poll();
			// 진행될때마다 값 1씩 추가.
			result++;
			
			// 현재 노드의 인접 리스트 순회.
			for(Integer node: NodeList[cur]) {
				// 아직 방문하지 않은 노드면.
				if(! visit[node]) {
					// 큐에 추가 및 방문 처리.
					q.add(node);
					visit[node] = true;
				}
			}
		}
		
		// 1번 노드를 제외한 나머지 감염 노드를 찾아야 하므로 1 빼줌.
		System.out.println(result - 1);
	}

}
