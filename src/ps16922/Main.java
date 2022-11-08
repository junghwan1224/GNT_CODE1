package ps16922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
 * https://www.acmicpc.net/problem/16922
 * 로마 숫자 만들기
 * */
public class Main {
	static int N;
	static int[] list = {1, 5, 10, 50};
	static Set<Integer> set;
	static boolean[] visit;
	static int sum;
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		set = new HashSet<Integer>();
		visit = new boolean[10000];
		
		dfs(0, 0);
		
		System.out.println(result);
	}

	public static void dfs(int cnt, int idx) {
		if(cnt == N) {
			if(! visit[sum]) {
				result++;
				visit[sum] = true;
			}
			return;
		}
		
		for(int i = idx; i < 4; i++) {
			sum += list[i];
			dfs(cnt + 1, i);
			sum -= list[i];
		}
	}
}
