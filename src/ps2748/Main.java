package ps2748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/2748
 * 피보나치 수 2 
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long[] d = new long[100];
		
		d[0] = 0;
		d[1] = 1;
		for(int i = 2; i < 91; i++) {
			d[i] = d[i - 1] + d[i - 2];
		}
		
		System.out.println(d[n]);
	}

}
