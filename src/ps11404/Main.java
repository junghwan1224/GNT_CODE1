package ps11404;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/11404
 * 플로이드
 * */
public class Main {
	
	public static int INF = 10000001;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] map = new int[101][101];
		
		for(int i = 1; i <= 100; i++)
			for(int j = 1; j <= 100; j++)
				map[i][j] = INF;
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			// 시작 도시와 도착 도시의 노선이 한개가 아닐 수 있으므로, 최솟값 갱신을 하면서 값 세팅.
			map[a][b] = Math.min(map[a][b], c);
		}
		
		// 플로이드-와샬 알고리즘을 통해 각 노드간 최소 비용 추출.
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					// 시작 도시와 도착 도시가 같은 경우는 없다고 했으므로 해당 조건에서는 비용 계산 하지 않음.
					if(i == j)
						continue;
					
					// 최소 비용 도출.
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				// 노선이 존재하지 않는 경우 0으로 출력.
				if(map[i][j] >= INF)
					bw.write(0 + " ");
				else
					bw.write(map[i][j] + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		
		br.close();
		bw.close();
	}

}
