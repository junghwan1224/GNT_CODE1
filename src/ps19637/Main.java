package ps19637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/19637
 * */
class Grade implements Comparable<Grade> {
	int point;
	String title;
	
	public Grade(int point, String title) {
		this.point = point;
		this.title = title;
	}
	
	@Override
	public int compareTo(Grade g) {
		return this.point - g.point;
	}
}

public class Main {
	static int N, M;
	static ArrayList<Grade> list;
	static int MAX = 1000000001;
	static StringBuffer sb;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<Grade>();
		sb = new StringBuffer();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String t = st.nextToken();
			int p = Integer.parseInt(st.nextToken());
			list.add(new Grade(p, t));
		}
		
		Collections.sort(list);
		
		for(int i = 0; i < M; i++) {
			int n = Integer.parseInt(br.readLine());
		}
	}

}
