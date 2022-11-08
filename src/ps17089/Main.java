package ps17089;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/17089
 * 세 친구
 * */
public class Main {
	static int N;
	static int M;
	static ArrayList<Integer>[] list; // 각 노드의 친구 저장할 리스트 
	static boolean[] visit; // 방문 여부
	static boolean[][] isFriend; // 서로 친구 관계인지 표시 
	static int[] friendCnt; // 각 노드의 친구 수 저장 
	static int MAX = 987654321;
	static int result = MAX;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		isFriend = new boolean[N + 1][N + 1];
		friendCnt = new int[N + 1];
		
		for(int i = 0; i <= N; i++)
			list[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
			
			isFriend[a][b] = true;
			isFriend[b][a] = true;
			
			friendCnt[a]++;
			friendCnt[b]++;
		}
		
		// 각 노드별로 dfs 탐색을 통해 친구 수 구하기 
		for(int i = 1; i <= N; i++) {
			if(visit[i])
				continue;
			visit[i] = true;
			dfs(i, i, 1, friendCnt[i]);
		}
		
		result = (result == MAX) ? -1 : result;
		System.out.println(result);
	}

	// Params => 현재 위치, 시작한 위치, 선택된 친구 갯수, 선택된 친구들의 친구 수 합
	public static void dfs(int idx, int start, int cnt, int friendSum) {
		if(cnt == 3) {
			// 세 사람은 모두 친구여야 하므로 마지막에 도달했을 때의 사람이 처음 탐색을 시작했을 때의 사람과 친구가 아니면 조건에 안맞으므로 함수 종료 
			if(! isFriend[idx][start])
				return;
			
			// 최솟값 갱신
			// 서로 친구이기 때문에 각 사람당 나머지 두 사람에 대한 인원수 제거 
			result = Math.min(result, friendSum - 6);
			return;
		}
		
		for(Integer i: list[idx]) {
			if(visit[i])
				continue;
			visit[i] = true;
			dfs(i, start, cnt + 1, friendSum + friendCnt[i]);
			visit[i] = false;
		}
	}
}
