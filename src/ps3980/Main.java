package ps3980;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.acmicpc.net/problem/3980
 * 선발 명단 
 * */
public class Main {
	static int C;
	static int[][] stat;
	static boolean[][] visit;
	static boolean[] position;
	static int maxStat;
	static StringBuffer sb;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		C = Integer.parseInt(br.readLine());
		
		sb = new StringBuffer();
		for(int t = 0; t < C; t++) {
			stat = new int[11][11];
			visit = new boolean[11][11];
			position = new boolean[11];
			maxStat = 0;
			
			for(int i = 0; i < 11; i++)
				stat[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			dfs(0, 0);
			
			sb.append(maxStat).append("\n");
		}
		
		System.out.println(sb);
	}

	public static void dfs(int idx, int statSum) {
		if(idx == 11) {
			maxStat = Math.max(maxStat, statSum);
			return;
		}
		
		for(int i = 0; i < 11; i++) {
			if(! position[i] && ! visit[idx][i] && stat[idx][i] != 0) {
				visit[idx][i] = true;
				position[i] = true;
				dfs(idx + 1, statSum + stat[idx][i]);
				position[i] = false;
				visit[idx][i] = false;
			}
		}
		
		return;
	}
}
