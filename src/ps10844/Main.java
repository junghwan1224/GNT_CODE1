package ps10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/10844
 * 쉬운 계단 수
 * */
public class Main {
	static int N;
	static int[][] d; // d[i][j] = i자리 수의 일의 자리 수가 j일 때, 쉬운 계단수의 갯수 
	static int MAX = 1000000000;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		d = new int[N + 1][10];
		
		for(int i = 1; i < 10; i++)
			d[1][i] = 1;
		
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 10; j++) {
				if(j > 0) {
					d[i][j] += d[i - 1][j - 1];
					d[i][j] %= MAX;
				}
				
				if(j < 9) {
					d[i][j] += d[i - 1][j + 1];
					d[i][j] %= MAX;
				}
				
			}
		}
		
		int result = 0;
		for(int i = 0; i < 10; i++) {
			result += d[N][i];
			result %= MAX;
		}
		
		System.out.println(result);
	}

}
