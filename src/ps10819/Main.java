package ps10819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/10819
 * 차이를 최대로
 * */
public class Main {
	static int N;
	static int[] A;
	static boolean[] visit;
	static ArrayList<Integer> list;
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		list = new ArrayList<Integer>();
		visit = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		
		System.out.println(result);
	}

	public static void dfs(int idx) {
		if(idx == N) {
			result = Math.max(result, getSum());
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visit[i])
				continue;
			visit[i] = true;
			list.add(A[i]);
			dfs(idx + 1);
			list.remove(list.size() - 1);
			visit[i] = false;
		}
	}
	
	public static int getSum() {
		int sum = 0;
		for(int i = 1; i < N; i++) {
			sum += Math.abs(list.get(i) - list.get(i - 1));
		}
		return sum;
	}
}
