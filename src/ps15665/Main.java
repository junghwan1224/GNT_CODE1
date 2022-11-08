package ps15665;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/15665
 * N과 M (11)
 * */
public class Main {
	
	static int N;
	static int M;
	static Set<Integer> set;
	static List<Integer> list;
	static List<Integer> result;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		set = new HashSet<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		list = new ArrayList<Integer>(set);
		Collections.sort(list);
		
		result = new ArrayList<Integer>();
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(Integer i: list) {
			result.add(i);
			dfs(1);
			result.clear();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int cnt) throws IOException {
		if(cnt == M) {
			for(Integer i: result)
				bw.write(i + " ");
			bw.write("\n");
			return;
		}
		
		for(Integer i: list) {
			result.add(i);
			dfs(cnt + 1);
			result.remove(result.size() - 1);
		}
	}
}
