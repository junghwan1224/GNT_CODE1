package ps2482;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/2482
 * 색상환
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int[][] d = new int[1001][1001];
		for(int i = 4; i < N + 1; i++)
			d[i][1] = i;
		
		System.out.println(d[N][K]);
	}

}
