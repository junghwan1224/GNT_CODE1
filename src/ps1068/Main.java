package ps1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1068
 * 좋다
 * */
public class Main {
	static int N;
	static int M;
	static ArrayList<Integer>[] list;
	static int root;
	static int cnt;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new ArrayList[N];
		
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(a != -1) {
				list[a].add(i);
			}
			else
				root = i;
		}
		
		M = Integer.parseInt(br.readLine());
		
		deleteNode(root, -1);
		dfs(root);
		
		System.out.println(cnt);
	}
	
	public static void deleteNode(int n, int idx) {
		if(idx != -1) {
			list[n].remove(idx);
			return;
		}
		
		for(int i = 0; i < list[n].size(); i++) {
			if(list[n].get(i) == M)
				deleteNode(n, i);
			else
				deleteNode(list[n].get(i), -1);
		}
	}

	public static void dfs(int n) {
		if(n == M)
			return;
		
		if(list[n].size() == 0) {
			cnt++;
			return;
		}
		
		for(Integer i: list[n]) {
			dfs(i);
		}
		
		return;
	}
}
