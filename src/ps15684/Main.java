package ps15684;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/15684
 * 사다리 조작
 * https://www.acmicpc.net/status?user_id=aorwn212&problem_id=15684&from_mine=1
 * https://baby-ohgu.tistory.com/3
 * */
public class Main {
	static int N;
	static int M;
	static int H;
	static boolean[][] visit;
	static int MAX = 987654321;
	static int result = MAX;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		visit = new boolean[15][35];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			visit[b][a] = true;
		}
		
		dfs(1, 0);
		
		result = (result == MAX) ? -1 : result;
		System.out.println(result);
	}

	/*
	 * 사다리 조작의 결과가 성공적인지 확인 
	 * */
	public static boolean check() {
		for(int i = 1; i <= N; i++) {
			// 사다리 게임을 시작하는 위치 
			int cur = i;
			for(int j = 1; j <= H; j++) {
				// 가로선이 있을 경우 이동 
				if(visit[cur][j])
					cur++;
				// 반대쪽에 가로선이 있을 경우 이동 
				else if(visit[cur - 1][j])
					cur--;
			}
			
			// 이동을 마친 후 시작과 끝의 위치가 다르면 조작이 실패했다는 뜻이므로 false 반환 
			if(cur != i)
				return false;
		}
		return true;
	}
	
	public static void dfs(int idx, int cnt) {
		// 3보다 큰 값인 경우는 바로 종료 
		if(cnt > 3)
			return;
		
		// 사다리 조작에 성공했으면 최솟값 갱신 
		if(check()) {
			result = Math.min(result, cnt);
			return;
		}
		
		for(int i = idx; i <= H; i++) {
			for(int j = 1; j < N; j++) {
				// 이미 가로선이 놓여져 있으면 넘어감 
				if(visit[j][i])
					continue;
				
				// 가로선을 연달아서 붙일 수는 없으므로 옆에 있으면 넘어감 
				if(visit[j - 1][i])
					continue;
				
				// 위 조건과 마찬가지로 연달아 붙일 수 없기 때문에 반대쪽에 가로선 놓여져 있으면 넘어감 
				if(visit[j + 1][i])
					continue;
				
				// 탐색 
				visit[j][i] = true;
				dfs(i, cnt + 1);
				visit[j][i] = false;
			}
		}
	}
}
