package ps10825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/10825
 * 국영수
 * */
class Score {
	String name;
	int kor;
	int eng;
	int math;
	
	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
}

public class Main {
	static int N;
	static ArrayList<Score> list;
	static Comparator<Score> comp = new Comparator<Score>() {
		@Override
		public int compare(Score a, Score b) {
			if(a.kor < b.kor)
				return 1;
			else if(a.kor == b.kor) {
				if(a.eng > b.eng)
					return 1;
				else if(a.eng == b.eng) {
					if(a.math < b.math)
						return 1;
					else if(a.math == b.math) {
						return a.name.compareTo(b.name);
					}
				}
			}
			return -1;
		}
	};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList<Score>();
		StringTokenizer st = null;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			
			list.add(new Score(name, kor, eng, math));
		}
		
		Collections.sort(list, comp);
		
		StringBuffer sb = new StringBuffer();
		for(Score s: list)
			sb.append(s.name).append("\n");
		
		System.out.println(sb);
	}

}
