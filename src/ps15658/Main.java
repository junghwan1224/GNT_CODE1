package ps15658;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/15658
 * 연산자 끼워넣기 (2)
 * */
public class Main {
	static int N;
	static int[] arr;
	static int[] oper = {0, 0, 0, 0}; // +, -, *, /
	static int min = 1000000001;
	static int max = -1000000001;
	static int idx = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++)
			oper[i] = Integer.parseInt(st.nextToken());
			
		dfs(1, arr[0]);
		
		StringBuffer sb = new StringBuffer();
		sb.append(max).append("\n").append(min);
		System.out.println(sb);
	}

	public static void dfs(int numIdx, int sum) {
		if(numIdx == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}

		if(oper[0] > 0) {
			oper[0]--;
			dfs(numIdx + 1, sum + arr[numIdx]);
			oper[0]++;
		}
		
		if(oper[1] > 0) {
			oper[1]--;
			dfs(numIdx + 1, sum - arr[numIdx]);
			oper[1]++;
		}
		
		if(oper[2] > 0) {
			oper[2]--;
			dfs(numIdx + 1, sum * arr[numIdx]);
			oper[2]++;
		}
		
		if(oper[3] > 0) {
			oper[3]--;
			dfs(numIdx + 1, sum / arr[numIdx]);
			oper[3]++;
		}
	}
}
