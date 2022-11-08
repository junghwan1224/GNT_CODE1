package ps11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/11723
 * 집합
 * */
public class Main {
	static int M;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine());
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		StringTokenizer st = null;
		
		//StringBuffer sb = new StringBuffer();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int val = -1;
			if(! cmd.equals("all") && ! cmd.equals("empty"))
				val = Integer.parseInt(st.nextToken());
			
			if(cmd.equals("add")) {
				map.put(val, 1);
			}
			else if(cmd.equals("remove")) {
				map.put(val, 0);
			}
			else if(cmd.equals("check")) {
				int cnt = map.getOrDefault(val, 0);
				if(cnt > 0) {
					System.out.println(1);
					//sb.append(1).append("\n");
				}
				else {
					System.out.println(0);
					//sb.append(0).append("\n");
				}
			}
			else if(cmd.equals("toggle")) {
				int cnt = map.getOrDefault(val, 0);
				if(cnt > 0) {
					map.put(val, 0);
				}
				else {
					map.put(val, 1);
				}
			}
			else if(cmd.equals("all")) {
				map = new HashMap<Integer, Integer>();
				for(int j = 1; j <= 20; j++)
					map.put(j, 1);
			}
			else { // empty
				map = new HashMap<Integer, Integer>();
			}
		}
		
		//System.out.println(sb);
	}

}
