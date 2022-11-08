package ps1956;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1956
 * 운동
 * */
public class Main_ {
	static int V;
	static int E;
	static int[][] map;
	static int MAX = 987654321;
	static int result = MAX;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		map = new int[V + 1][V + 1];
		
		for(int i = 1; i <= V; i++)
			Arrays.fill(map[i], MAX);
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			map[a][b] = c;
		}
		
		for(int i = 1; i <= V; i++) {
			for(int j = 1; j <= V; j++) {
				for(int k = 1; k <= V; k++) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		for(int i = 1; i <= V; i++) {
			for(int j = 1; j <= V; j++) {
				if(map[i][j] != MAX && map[j][i] != MAX) {
					result = Math.min(result, map[i][j] + map[j][i]);
				}
			}
		}
		
		result = (result == MAX) ? -1 : result;
		System.out.println(result);
	}

}
