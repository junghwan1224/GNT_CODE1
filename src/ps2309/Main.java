package ps2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * https://www.acmicpc.net/problem/2309
 * 일곱 난쟁이
 * */
public class Main {
	static int n = 9;
	static int[] arr;
	static boolean[] visit;
	static ArrayList<Integer> list;
	static StringBuffer sb;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[n];
		visit = new boolean[n];
		
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		list = new ArrayList<Integer>();
		sb = new StringBuffer();
		
		dfs(0, 0);
		
		System.out.println(sb);
	}

	public static void dfs(int cnt, int total) {
		if(cnt == 7) {
			if(total == 100) {
				Collections.sort(list);
				for(Integer i: list)
					sb.append(i).append("\n");
				
				flag = true;
				return;
			}
		}
		
		for(int i = 0; i < n; i++) {
			if(flag)
				break;
			
			if(! visit[i]) {
				visit[i] = true;
				list.add(arr[i]);
				dfs(cnt + 1, total + arr[i]);
				list.remove(list.size() - 1);
				visit[i] = false;
			}
		}
		
		return;
	}
}
