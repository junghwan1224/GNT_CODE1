package ps2847;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/2847
 * 게임을 만든 동준이
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] level = new int[n];
		int result = 0;
		
		for(int i = 0; i < n; i++) {
			level[i] = Integer.parseInt(br.readLine());
		}
		
		// 마지막에서 두번째 레벨에서부터 점수를 1씩 낮게 세팅하면서 감소시키는 작업 횟수 카운트 
		for(int i = n - 2; i >= 0; i--) {
			// 현재 레벨이 다음 더 높은 레벨 점수보다 크거나 같을 경우 
			if(level[i + 1] <= level[i]) {
				// 감소 횟수 더해준다.
				// 작업 횟수 현재 레벨 - (높은 레벨의 스코어보다 1 낮춘 값)
				result += level[i] - (level[i + 1] - 1);
				// 더 높은 레벨보다 스코어 1 낮추게 세팅 
				level[i] = level[i + 1] - 1;
			}
		}
		
		System.out.println(result);
	}

}
