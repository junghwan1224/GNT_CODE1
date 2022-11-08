package ps15651;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/15651
 * N과 M (3)
 * */
public class Main {
	static int n;
	static int m;
	static ArrayList<Integer> list;
	// 한번에 출력하기 위해 사용 
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<Integer>();
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 1; i <= n; i++) {
			list.add(i);
			dfs(1);
			list.clear();
		}
		
		// 모든 데이터를 다 저장 후 한번에 출력 
		bw.flush();
		
		br.close();
		bw.close();
	}

	public static void dfs(int cnt) throws IOException {
		if(cnt == m) {
			for(Integer i: list)
				bw.write(i.toString() + " ");
			bw.write("\n");
			
			// 그때그때 출력하려고 flush 호출하면, BufferedWriter를 사용한 의미가 없다.
			// bw.flush();
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			list.add(i);
			dfs(cnt + 1);
			list.remove(list.size() - 1);
		}
	}
}
