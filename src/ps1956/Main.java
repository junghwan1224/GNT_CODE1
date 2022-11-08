package ps1956;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1956
 * 운동
 * 플로이드 와샬 알고리즘 관련 문제.
 * 플로이드 와샬 알고리즘 설명 링크: https://blog.naver.com/ndb796/221234427842
 * */
public class Main {
	
	public static int INF = 4000001;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[401][401];
		
		for(int i = 0; i <= 400; i++) {
			for(int j = 0; j <= 400; j++) {
				map[i][j] = INF;
			}
		}

		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			map[x][y] = d;
		}
		
		/*
		 * 플로이드 와샬 알고리즘.
		 * k = 거쳐가는 노드.
		 * i = 출발 노드.
		 * j = 도착 노드.
		 * */
		for(int k = 1; k <= 400; k++) {			
			for(int i = 1; i <= 400; i++) {
				for(int j = 1; j <= 400; j++) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		int result = INF;
		/*
		 * 플로이드 와샬 알고리즘을 통해.
		 * 각 노드를 거쳐 도착 노드까지의 최소 비용이 구해졌으므로.
		 * 사이클이 성립될 수 있는지 확인.
		 * */
		for(int i = 1; i <= 400; i++) {
			for(int j = 1; j <= 400; j++) {
				// 출발 노드와 도착 노드가 각각 i,j / j,i 인 경우
				// 해당 거리의 값이 INF가 아니라면 사이클이 형성될 수 있는 조건이므로.
				// 거리의 값을 더하여 최솟값을 갱신.
				if(map[i][j] != INF && map[j][i] != INF) {
					result = Math.min(result, map[i][j] + map[j][i]);
				}
			}
		}
		
		// result 값이 INF라는 것은 사이클이 형성된 도로가 없다는 뜻이므로 -1 출력.
		if(result == INF)
			System.out.println(-1);
		// 사이클이 형성되었으면 result 출력.
		else
			System.out.println(result);
		
	}

}
