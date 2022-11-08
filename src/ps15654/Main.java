package ps15654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/15654
 * N과 M (5)
 * */
public class Main {
	static int N;
	static int M;
	static Set<Integer> set;
	static ArrayList<Integer> list;
	static StringBuffer sb;
	static ArrayList<String> result;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		set = new HashSet<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			set.add(Integer.parseInt(st.nextToken()));
		list = new ArrayList<Integer>(set);
		Collections.sort(list);
		
		sb = new StringBuffer();
		result = new ArrayList<String>();
		visit = new boolean[10001];
		
		for(Integer i: list) {
			result.add(Integer.toString(i));
			visit[i] = true;
			dfs(1);
			visit[i] = false;
			result.clear();
		}
		
		System.out.println(sb);
	}

	public static void dfs(int cnt) {
		if(cnt == M) {
			String s = String.join(" ", result);
			sb.append(s).append("\n");
			return;
		}
		
		for(Integer i: list) {
			if(! visit[i]) {
				result.add(Integer.toString(i));
				visit[i] = true;
				dfs(cnt + 1);
				visit[i] = false;
				result.remove(result.size() - 1);
			}
		}
	}
}
