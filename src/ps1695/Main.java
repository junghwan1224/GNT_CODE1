package ps1695;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.acmicpc.net/problem/1695
 * 팰린드롬 만들기
 * */
public class Main {
	static int n;
	static int[] arr;
	static int[][] d;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		// dp [a][b] : a부터 b까지의 부분 수열을 팰린드롬으로 만들기 위해 끼워 넣어야 할 숫자의 최소 개수
		d = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			Arrays.fill(d[i], -1);
		}
		
//		for(int i = 0; i < n - 1; i++) {
//			for(int j = 1; j < n; j++) {
//				dfs(i, j);				
//			}
//		}
		dfs(0, n - 1);
		
		System.out.println(d[0][n - 1]);
	}

	public static int dfs(int a, int b) {
		// a보다 b가 큰 경우에 대해서 예외 처리
		// a와 b가 같으면 0으로 초기화 
		if(a >= b) {
			return d[a][b] = 0;
		}
		
		// d[a][b]가 -1이 아니면 이미 연산을 했다는 의미이므로, d[a][b]값을 리턴
		if(d[a][b] != -1)
			return d[a][b];
		
		// 양 끝 값이 다르면, a번째 값에 대응하여 값을 넣는 경우와, b번째 값에 대응하여 값을 넣는 경우 중 최솟값에 1을 더한 값을 넣어준다
		if(arr[a] != arr[b]) {
			d[a][b] = Math.min(dfs(a, b - 1), dfs(a + 1, b)) + 1;
		}
		// 양 끝 값이 같으면, 범위를 줄여서 다시 탐색한다 
		else {
			d[a][b] = dfs(a + 1, b - 1);
		}
		
		return d[a][b];
	}
}
