package ps15663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/15663
 * N과 M (9)
 * */
public class Main {
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visit;
	static StringBuffer sb;
	static int[] result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		visit = new boolean[8];
		result = new int[8];
		sb = new StringBuffer();
		
		dfs(0);
		
		System.out.println(sb);
	}

	public static void dfs(int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++)
				sb.append(result[i]).append(" ");
			sb.append("\n");
			return;
		}
		
		int prev = -1;
		
		for(int i = 0; i < N; i++) {
			if(! visit[i] && arr[i] != prev) {
				visit[i] = true;
				result[cnt] = arr[i];
				prev = arr[i];
				dfs(cnt + 1);
				visit[i] = false;
			}
		}
	}
}
