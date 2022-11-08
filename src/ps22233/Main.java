package ps22233;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/22233
 * 가희와 키워드
 * */
public class Main {
	static int n;
	static int m;
	static Set<String> set;
	static StringBuffer sb;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		set = new HashSet<String>();
		sb = new StringBuffer();
		for(int i = 0; i < n; i++) {
			set.add(br.readLine());
		}
		
		for(int i = 0; i < m; i++) {
			String[] str = br.readLine().split(",");
			
			for(int j = 0; j < str.length; j++) {
				if(set.contains(str[j])) {
					set.remove(str[j]);
				}
			}
			
			//System.out.println(Arrays.toString(set.toArray()));
			sb.append(set.size()).append("\n");
		}
		
		System.out.println(sb);
	}

}
