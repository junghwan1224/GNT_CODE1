package ps2718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/2718
 * 타일 채우기
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] d;
		
		while(T > 0) {
			int N = Integer.parseInt(br.readLine());
			d = new int[N + 1];
			d[0] = 1;
			d[1] = 1;
			if(N >= 2)
				d[2] = 5;
			for(int i = 3; i < N + 1; i++) {
				if(i % 2 == 1)
					d[i] = d[i - 1] * 2 + d[i - 2];
				else
					d[i] = d[i - 1] * 2 + d[i - 2] * d[i - 2] + d[i - 2];
			}
			
			System.out.println(d[N]);
			T--;
		}
	}

}
