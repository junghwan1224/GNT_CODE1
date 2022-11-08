package ps2240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2240
 * 자두나무
 * */
public class Main {
	static int T;
	static int W;
	static int[] tree;
	static int[][][] d;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		tree = new int[T + 1];
		for(int i = 1; i <= T; i++)
			tree[i] = Integer.parseInt(br.readLine());
		
		/*
		 	d[자두나무 위치][떨어지는 시간][최대 움직일 수 있는 횟수]
			d[L][T][W]
			
			다시 풀어보자 
		 * */
		d = new int[3][1010][35];
		
		for(int i = 1; i <= T; i++) {
			for(int j = 1; j <= W + 1; j++) {
				if(tree[i] == 1) {
					d[1][i][j] = Math.max(d[1][i - 1][j], d[2][i - 1][j - 1]) + 1;
					d[2][i][j] = Math.max(d[2][i - 1][j], d[1][i - 1][j - 1]);
				}
				else {
					if(i == 1 && j == 1)
						continue;
					d[1][i][j] = Math.max(d[1][i - 1][j], d[2][i - 1][j - 1]);
					d[2][i][j] = Math.max(d[2][i - 1][j], d[1][i - 1][j - 1]) + 1;
				}
			}
		}
		
		int result = 0;
		for(int i = 1; i <= W + 1; i++)
			result = Math.max(d[1][T][i], d[2][T][i]);
		System.out.println(result);
	}

}
