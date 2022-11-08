package ps11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/11724
 * 연결 요소의 개수
 * */
public class Main {
	static int N;
	static int M;
	static boolean[] visit;
	static ArrayList<Integer>[] list;
	static int cnt;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N + 1];
		list = new ArrayList[N + 1];
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
				dfs(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	public static void dfs(int n) {
		visit[n] = true;
		
		for(Integer i: list[n]) {
			if(! visit[i]) {
				dfs(i);
			}
		}
	}
}
