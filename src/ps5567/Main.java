package ps5567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/5567
 * 결혼식
 * 소요시간: 1시간 
 * 왜 틀렸는가... 나와 같은 접근을 하고 왜 틀렸는지에 대한 설명이 적힌 블로그 
 * https://ilmiodiario.tistory.com/122
 * */

/*
 * 예외 테스트 케이스 
 * 6
	5
	1 2
	1 3
	3 4
	2 4
	4 5
 * */
public class Main {
	
	static int n;
	static int m;
	static ArrayList<Integer>[] list; // 양방향 그래프 설정을 위한 리스트 
	static boolean[] visit; // 방문 여부 
	static int depthLimit = 2; // 최대 탐색 깊이. 친구의 친구까지 포함이므로 깊이는 2로 초기화 
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n + 1];
		for(int i = 0; i < n + 1; i++)
			list[i] = new ArrayList<Integer>();
		visit = new boolean[n + 1];
		
		while(m > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 그래프 양방향으로 설정 
			list[a].add(b);
			list[b].add(a);
			m--;
		}
		
		visit[1] = true;
		dfs(1, 0);
		
		// 1번은 주인공 본인이기 때문에 2번부터 체크
		// 방문 가능한 노드를 모두 체크하면 true인 노드의 수가 정답 
		for(int i = 2; i < n + 1; i++) {
			if(visit[i])
				result++;
		}
		
		System.out.println(result);
	}
	
	public static void dfs(int num, int depth) {
		if(depth == depthLimit) {
			return;
		}
		
		for(Integer i: list[num]) {
			// 이미 방문했으면 더이상 확인을 안하는 것이 아니라,
			// 깊이가 2까지 도달하면서 방문할 수 있는 노드를 모두 체크해야 한다.
			// if(! visit[i]) {
				visit[i] = true;
				System.out.println(i + ", depth: " + depth);
				dfs(i, depth + 1);
			// }
		}
	}

}
