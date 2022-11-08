package ps2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/2579
 * 계단 오르기
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] stair = new int[n + 1];
		for(int i = 1; i <= n; i++)
			stair[i] = Integer.parseInt(br.readLine());
		
		int[] d = new int[n + 1];
		
		if(n == 1)
			d[1] = stair[1];
		else if(n == 2)
			d[2] = stair[1] + stair[2];
		// 계단의 수가 3개일 때, 마지막 계단은 무조건 밟아야 하므로 최댓값은 첫번째 + 세번째, 두번째 + 세번째 값 중 최댓값이다.
		else if(n == 3)
			d[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);
		// 계단의 수가 4개 이상인 경우 
		else {
			d[1] = stair[1];
			d[2] = stair[1] + stair[2];
			d[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);
			
			/*
			 * 마지막 계단은 반드시 밟아야 하므로 마지막 이전 계단을 밟았을 경우와 밟지 않았을 경우로 나뉜다.
			 * 1. 마지막 이전 계단을 밟았을 때 
			 * d[i - 3] + stair[i - 1] + stair[i]
			 * 마지막 이전 계단을 밟은 상태이므로 전전 계단은 밟지 못한다.
			 * 그래서 3번째 전 계단까지 밟은 상태에서의 최댓값인 d[i - 3]에 마지막 이전 계단의 값 stair[i - 1]과 마지막 계단인 stair[i] 값을 더한다.
			 * 
			 * 2. 마지막 이전 계단을 밟지 않았을 때 
			 * d[i - 2] + stair[i]
			 * 
			 * 해당 경우의 수 중 최댓값이 정답이다.
			 * */ 
			for(int i = 3; i <= n; i++) {
				d[i] = Math.max(d[i - 3] + stair[i - 1] + stair[i], d[i - 2] + stair[i]);
			}
		}
		
		
		System.out.println(d[n]);
	}

}
