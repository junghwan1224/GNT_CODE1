package ps2133;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/2133
 * 타일 채우기
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] d = new int[31];
		
		d[2] = 3;
		d[4] = 11; // d[2] * d[2] + 2
		for(int i = 6; i <= n; i++) {
			if(i % 2 != 0)
				continue;
			d[i] = d[i - 2] * d[2] + d[i - 4] * 2;
		}
		
		System.out.println(d[n]);
	}

}
