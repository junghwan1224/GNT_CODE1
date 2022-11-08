package ps6064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/6064
 * 카잉 달력
 * */
public class Main {
	static int T;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int a = 1;
			int b = 1;
			int year = 1;
			boolean flag = false;
			int result = -1;
			
			while(true) {
				//System.out.println(a + " " + b);
				if(a == x && b == y) {
					flag = true;
					break;
				}
				
				if(year > 40000)
					break;
				
				a = a < M ? a + 1 : 1;
				b = b < N ? b + 1 : 1;
				year++;
			}
			
			result = flag ? year : -1;
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}

}
