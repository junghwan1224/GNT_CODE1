package ps4948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/4948
 * 베르트랑 공준
 * */
public class Main {
	static int MAX = 300000;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] p = new int[MAX];
		for(int i = 2; i < MAX; i++) {
			p[i] = i;
		}
		
		for(int i = 2; i < MAX; i++) {
			if(p[i] == 0)
				continue;
			for(int j = i + i; j < MAX; j += i) {
				p[j] = 0;
			}
		}
		
		StringBuffer sb = new StringBuffer();
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				break;
			
			int cnt = 0;
			for(int i = n + 1; i <= 2 * n; i++) {
				if(p[i] != 0)
					cnt++;
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}

}
