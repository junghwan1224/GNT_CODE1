package ps2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/2193
 * 이친수
 * */
public class Main {
	
	// int로 선언했을시, n = 90 일 때, int 값 초과로 인하여 정상적인 값 출력X
	static long[][] d;
	static long[] d2;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// d[n][0] = n자릿수이고, 끝자리가 0인 이친수의 갯수.
		// d[n][1] = n자릿수이고, 끝자리가 1인 이친수의 갯수.
		d = new long[n+1][2];
		
		d2 = new long[n+1];
		
		// 한자릿수인 이친수는 1뿐이므로 d[1][1]만 1로 초기화 해준다.
		d[1][0] = 0;
		d[1][1] = 1;
		
		d2[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			// (i-1)자릿수의 이친수의 끝자리가 0이라면, 뒤에 0/1 둘 다 붙일 수 있으므로.
			// (i-1)자릿수이고 끝자리가 0인 이친수의 갯수와 1인 이친수의 갯수를 더해준다.
			// d[i][0] = d[i - 1][0] + d[i - 1][1];
			
			// 끝자리에 1이 오기 위해서는 앞자릿수가 무조건 0이어야 하므로 (i-1)자릿수이고 끝자리가 0인 이친수의 갯수를 그대로 저장.
			// d[i][1] = d[i - 1][0];
			
			d2[i] = d2[i - 2] + d2[i - 1];
		}
		
		// n자릿수의 이친수의 갯수 출력.
		// System.out.println(d[n][0] + d[n][1]);
		System.out.println(d2[n]);
		// 2880067194370816120
	}

}
