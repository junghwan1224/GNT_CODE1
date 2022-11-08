package ps7662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/7662
 * 이중 우선순위 큐
 * https://loosie.tistory.com/314
 * 우선순위 큐 버전
 * */

public class Main {
	static int T;
	//static PriorityQueue<MaxNode> maxQ;
	//static PriorityQueue<MinNode> minQ;
	static PriorityQueue<Integer> maxQ;
	static PriorityQueue<Integer> minQ;
	static Map<Integer, Integer> map;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		while(T > 0) {
			int k = Integer.parseInt(br.readLine());
			int resMax = 0;
			int resMin = 0;
			
			maxQ = new PriorityQueue<>(Collections.reverseOrder());
			minQ = new PriorityQueue<>();
			map = new HashMap<Integer, Integer>();
			for(int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				
				if(cmd.equals("I")) {
					maxQ.add(n);
					minQ.add(n);
					map.put(n, map.getOrDefault(n, 0) + 1);
				}
				else {
					if(map.size() == 0)
						continue;
					if(n == 1) {
						delete(maxQ);
					}
					else {
						delete(minQ);
					}
				}
			}
			
			if(map.size() > 0) {
				int res = delete(maxQ);
                sb.append(res).append(" ");
				if(map.size() > 0)
					res = delete(minQ);
				sb.append(res).append("\n");
			}
			else
				sb.append("EMPTY").append("\n");
			
			/*if (map.size() == 0) {
				sb.append("EMPTY\n");
			} else {
				int res = delete(maxQ);
				sb.append(res + " "); // 최댓값
				if (map.size() > 0)
					res = delete(minQ);
				sb.append(res + "\n"); // 최솟값
			}*/
			
			T--;
		}
		
		System.out.println(sb);
	}

	public static int delete(PriorityQueue<Integer> que) {
		int res = 0;
		while(! que.isEmpty()) {
			res = que.poll();
			
			int cnt = map.getOrDefault(res, 0);
			if(cnt == 0)
				continue;
			
			if(cnt == 1)
				map.remove(res);
			else
				map.put(res, cnt - 1);
			break;
		}
		return res;
	}
}
