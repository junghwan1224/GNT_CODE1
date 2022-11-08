package ps2531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2531
 * 회전 초밥
 * */
public class Main {
	static int n;
	static int d;
	static int k;
	static int c;
	static int[] dish;
	static Map<Integer, Integer> map;
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		dish = new int[n * 2];
		map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < n; i++) {
			dish[i] = Integer.parseInt(br.readLine());
			dish[i + n] = dish[i];
		}
		
		int start = 0;
		int end = 0;
		map.put(c, 1);
		
		while(start <= end && end < 2 * n) {
			
			int len = end - start + 1;
			
			if(len <= k) {
				map.put(dish[end], map.getOrDefault(dish[end], 0) + 1);
				
				if(len == k) {
					int cnt = 0;
					for(Integer i: map.keySet()) {
						if(map.get(i) > 0) {
							cnt++;
						}
					}
					result = Math.max(result, cnt);
				}
				
				end++;
			}
			else {
				
				map.put(dish[start], map.getOrDefault(dish[start], 0) - 1);
				start++;
			}
		}
		
		System.out.println(result);
	}

	public static void printMap() {
		for(Integer i: map.keySet()) {
			System.out.println(i + ": " + map.get(i));
		}
	}
}
