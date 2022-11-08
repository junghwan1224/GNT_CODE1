package ps10807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/10807
 * 개수 세기
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int e = Integer.parseInt(st.nextToken());
			int val = map.getOrDefault(e, 0);
			map.put(e, val + 1);
		}
		
		int m = Integer.parseInt(br.readLine());
		int result = map.get(m) == null ? 0 : map.get(m);
		System.out.println(result);
	}

}
