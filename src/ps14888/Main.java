package ps14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/14888
 * 연산자 끼워넣기
 * */
public class Main {
	static int N;
	static int minVal = 100000000;
	static int maxVal = -100000000;
	static int[] arr;
	static int[] op; // 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수
	static int index;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		op = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		index = 0;
		dfs(arr[index]);
		
		System.out.println(maxVal);
		System.out.println(minVal);
	}

	public static void dfs(int val) {
		if(index == N - 1) {
			maxVal = Math.max(maxVal, val);
			minVal = Math.min(minVal, val);
			return;
		}
		
		if(op[0] > 0) {
			op[0]--;
			index++;
			dfs(val + arr[index]);
			index--;
			op[0]++;
		}
		
		if(op[1] > 0) {
			op[1]--;
			index++;
			dfs(val - arr[index]);
			index--;
			op[1]++;
		}
		
		if(op[2] > 0) {
			op[2]--;
			index++;
			dfs(val * arr[index]);
			index--;
			op[2]++;
		}
		
		if(op[3] > 0) {
			op[3]--;
			index++;
			dfs(val / arr[index]);
			index--;
			op[3]++;
		}
	}
}
