package ps16936;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/16936
 * 나3곱2
 * */
public class Main {
	static int N;
	static ArrayList<Long> A;
	static ArrayList<Long> B;
	static boolean[] visit;
	static boolean flag;
	static StringBuffer sb;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		B = new ArrayList<Long>();
		A = new ArrayList<Long>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			B.add(Long.parseLong(st.nextToken()));
		}
		
		flag = true;
		visit = new boolean[N];
		A = new ArrayList<Long>();
		sb = new StringBuffer();
		for(int i = 0; i < N; i++) {
			A.add(B.get(i));
			visit[i] = true;
			//dfs2(1, B.get(i));
			dfs(1, B.get(i));
			visit[i] = false;
			A.remove(A.size() - 1);
		}
		
	}

	public static void dfs(int cnt, long x) {
		if(cnt == N) {
			for(Long l: A)
				sb.append(l).append(" ");
			System.out.println(sb);
			return;
		}
		
		int gob2Idx = getIdx(x * 2);
		if(gob2Idx != -1) {
			if(! visit[gob2Idx]) {
				visit[gob2Idx] = true;
				A.add(B.get(gob2Idx));
				dfs(cnt + 1, x * 2);
				A.remove(A.size() - 1);
				visit[gob2Idx] = false;
			}
		}
		
		if(x % 3 == 0) {
			int na3Idx = getIdx(x / 3);
			if(na3Idx != -1) {
				if(! visit[na3Idx]) {
					visit[na3Idx] = true;
					A.add(B.get(na3Idx));
					dfs(cnt + 1, x / 3);
					A.remove(A.size() - 1);
					visit[na3Idx] = false;
				}
			}
		}
	}
	
	public static void dfs2(int cnt, long x) {
		if(cnt == N) {
			for(Long l: A)
				sb.append(l).append(" ");
			System.out.println(sb);
			return;
		}
		
		int gob2Idx = getIdx(x * 2);
		//System.out.println(gob2Idx);
		if(gob2Idx != -1) {
			A.add(B.get(gob2Idx));
			dfs2(cnt + 1, x * 2);
			A.remove(A.size() - 1);
		}
		
		if(x % 3 == 0) {
			int na3Idx = getIdx(x / 3);
			if(na3Idx != -1) {
				A.add(B.get(na3Idx));
				dfs2(cnt + 1, x / 3);
				A.remove(A.size() - 1);
			}
		}
	}
	
	public static int getIdx(long val) {
		for(int i = 0; i < N; i++) {
			if(B.get(i) == val) {
				return i;
			}
		}
		
		return -1;
	}
}
