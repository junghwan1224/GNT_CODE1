package ps15666;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/15666
 * N과 M (12) 
 * */
public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int[] chk;
	static ArrayList<String> list;
	static StringBuffer sb;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		chk = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		list = new ArrayList<String>();
		sb = new StringBuffer();
		
		for(int i = 0; i < N; i++) {
			chk[0] = arr[i];
			dfs(1, i);
		}
		
		for(String s: list)
			sb.append(s).append("\n");
		
		System.out.println(sb);
	}

	public static void dfs(int cnt, int idx) {
		if(cnt == M) {
			String s = "";
			for(int i = 0; i < M; i++) {
				s += Integer.toString(chk[i]) + " ";
			}
			
			if(! list.contains(s))
				list.add(s);
			return;
		}
		
		for(int i = idx; i < N; i++) {
			chk[cnt] = arr[i];
			dfs(cnt + 1, i);
		}
		
		return;
	}
}
