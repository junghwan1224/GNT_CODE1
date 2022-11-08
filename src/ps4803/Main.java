package ps4803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/4803
 * 트리
 * */
public class Main {
	static int N;
	static int M;
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static int cnt;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuffer sb = new StringBuffer();
		int caseCnt = 1;
		
		StringTokenizer st = null;
		while(true) {
			// 다음 테스트 케이스 입력 
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			if(N == 0 && M == 0)
				break;
			
			list = new ArrayList[N + 1];
			visit = new boolean[N + 1];
			cnt = 0;
			
			for(int i = 0; i <= N; i++)
				list[i] = new ArrayList<Integer>();
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list[a].add(b);
				list[b].add(a);
			}
			
			for(int i = 1; i <= N; i++) {
				if(! visit[i]) {
					flag = true;
					dfs(i, -1);
					if(flag) //사이클이 없었으면 트리임
						cnt++;
				}
			}
			
			String answer = "Case " + Integer.toString(caseCnt++) + ": ";
			
			if(cnt == 0) answer += "No trees.";
			else if(cnt == 1) answer += "There is one tree.";
			else answer += "A forest of " + Integer.toString(cnt) + " trees.";
			
			sb.append(answer).append("\n");
			
		}
		
		System.out.println(sb);
	}

	public static void dfs(int cur, int before) {
		if(visit[cur]) { //사이클 형성
			flag = false;
			return;
		}
		
		visit[cur] = true;
		
		for(Integer i: list[cur]) { //단방향 탐색
			int next = i;
			
			if(next != before) { //1->2로 탐색했었다면 2->1은 탐색하지 않도록
				dfs(next, cur);
			}
		}
	}
}
