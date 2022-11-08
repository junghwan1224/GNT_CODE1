package no2531;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2531
 * 회전 초밥
 * */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		int d = 0;
		int k = 0;
		int c = 0;
		int[] sushi = {0, };
		int[] visit = new int[3001];
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			sushi = new int[n + k - 1];
			
			for(int i = 0; i < n; i++) {
				sushi[i] = Integer.parseInt(br.readLine());
			}
			
			for(int i = n; i < n + k -1; i++) {
				sushi[i] = sushi[i - n];
			}
			
			br.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		visit[c] = 1;
		int start = 0;
		int end = k - 1;
		int cnt = 1;
		int result = -1;
		
		for(int i = 0; i < k; i++) {
			visit[sushi[i]]++;
			if(visit[sushi[i]] == 1)
				cnt++;
		}
		
		while(start < n - 1) {
			result = Math.max(result, cnt);
			visit[sushi[start]]--;
			if(visit[sushi[start++]] == 0)
				cnt--;
			visit[sushi[++end]]++;
			if(visit[sushi[end]] == 1)
				cnt++;
		}
		
		System.out.println(result);
	}

}
