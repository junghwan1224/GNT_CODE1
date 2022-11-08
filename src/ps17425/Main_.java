package ps17425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/17425
 * 약수의 합
 * 
 * ref: https://velog.io/@lamknh/C-%EB%B0%B1%EC%A4%80-17425-%EC%95%BD%EC%88%98%EC%9D%98-%ED%95%A9
 * ex)
 * 1	2	3	4	5	6	7
 * 1	1	1	1	1	1	1 (1의 배수 dp값 더해줌)
 *		2		2		2	  (2의 배수 dp값 더해줌)
 *			3			3	  (3의 배수 dp값 더해줌)
 * */
public class Main_ {
	static int T;
	static int MAX = 1000001;
	static long[] d;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		d = new long[MAX];
		
		for(int i = 1; i < MAX; i++) {
			for(int j = i; j < MAX; j += i) {
				d[j] += i;
			}
		}
		
		for(int i = 2; i < MAX; i++)
			d[i] += d[i - 1];
		
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(d[n]).append("\n");
		}
		
		System.out.println(sb);
	}

}
