package ps1633;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1633
 * 최고의 팀 만들기
 * */
public class Main {
	static int[][] player;
	static int[][][] d;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// player[i][0] => i번째 입력한 선수의 백 능력치
		// player[i][1] => i번째 입력한 선수의 흑 능력치
		player = new int[1001][2];
		// d[i][j][k] = i번째 참가자까지 참여했을 때, 백 j명, 흑 k명을 뽑았을 때의 능력치 최댓값 
		d = new int[1001][16][16];
		
		int cnt = 0;
		int playerIdx = 15;
		
		while(st.hasMoreTokens()) {
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			player[cnt][0] = a;
			player[cnt][1] = b;
			cnt++;
			
			st = new StringTokenizer(br.readLine());
			if(! st.hasMoreElements())
				break;
		}
		
		int result = -1;
		d[0][1][0] = player[0][0];
		d[0][0][1] = player[0][1];
		
		for(int i = 1; i < cnt; i++) {
			for(int j = 1; j <= playerIdx; j++) {
				for(int k = 1; k <= playerIdx; k++) {
					int tmp = 0;
					
					if(j > 0) {
						// (i-1)명 까지 뽑고 i번째는 백으로 뽑을 때, 현재 탐색중인 백의 능력치 더한 값 저장 
						tmp = d[i - 1][j - 1][k] + player[i][0];
					}
					
					if(k > 0) {
						// (i-1)명 까지 뽑고 i번째는 흑으로 뽑을 때, 현재 탐색중인 흑의 능력치 더한 값 저장 후 최댓값 갱신 
						tmp = Math.max(tmp, d[i - 1][j][k - 1] + player[i][1]);
					}
					
					// 현재 탐색중인 플레이어의 흑,백 능력치를 더한 값의 최댓값과, 현재 탐색중인 플레이어를 뽑지 않았을 경우의 최댓값 갱신 
					d[i][j][k] = Math.max(d[i - 1][j][k], tmp);
					
					// 흑, 백 모두 15명 뽑았으면 능력치가 최대가 이루어진 팀으로 되어있는지 확인 후 최댓값 갱신 
					if(j == playerIdx && k == playerIdx) {
						result = Math.max(result, d[i][j][k]);
					}
				}
			}
		}
		
		System.out.println(result);
	}

}
