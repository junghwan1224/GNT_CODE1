package ps2529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2529
 * 부등호
 * */
public class Main {
	static int k; // 부등호 갯수.
	static String[] g; // 입력받은 부등호 저장.
	static boolean[] visit; // 0 ~ 9 까지 수의 방문 여부 체크.
	// static ArrayList<String> result; // 0 ~ 9 까지 조합된 값들 저장.
	static String minVal; // 결과값중 최솟값.
	static String maxVal; // 결과값중 최댓값.

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		g = new String[k];
		visit = new boolean[10];
		// result = new ArrayList<String>();
		maxVal = "0000000000";
		minVal = "9999999999";
		
		for(int i = 0; i < k; i++) {
			g[i] = st.nextToken();
		}
		
		// 각 수에 대하여 탐색 시작.
		for(int i = 0; i <= 9; i++) {
			visit[i] = true;
			dfs(Integer.toString(i), 0, i);
			visit[i] = false;
		}
		
		/* for(String s: result) {
			// 최솟값 갱신.
			if(minVal.compareTo(s) > 0)
				minVal = s;
			
			// 최댓값 갱신.
			if(maxVal.compareTo(s) < 0)
				maxVal = s;
		} */
		
		System.out.println(maxVal);
		System.out.println(minVal);
	}

	/*
	 * @String str 현재까지 조합된 문자열.
	 * @Integer gIndx 현재 부등호의 인덱스.
	 * @Integer curNum 현재 탐색중인 정수.
	 * */
	public static void dfs(String str, int gIdx, int curNum) {
		// 0 ~ 9 까지 (k+1) 자리의 조합을 완성했을 경우 리스트에 값 추가 후 함수 종료.
		if(str.length() == (k + 1)) {
			// result.add(str);
			// 최솟값 갱신.
			if(minVal.compareTo(str) > 0)
				minVal = str;
			
			// 최댓값 갱신.
			if(maxVal.compareTo(str) < 0)
				maxVal = str;
			return;
		}
		
		for(int i = 0; i <= 9; i++) {
			// 아직 방문하지 않은 정수라면.
			if(! visit[i]) {
				// 부등호가 > 일 때.
				if(g[gIdx].equals(">")) {
					if(curNum > i) {
						visit[i] = true;
						gIdx++;
						dfs(str + Integer.toString(i), gIdx, i);
						gIdx--;
						visit[i] = false;
					}
				}
				
				// 부등호가 < 일 때.
				else { // g[gIdx].equals("<")
					if(curNum < i) {
						visit[i] = true;
						gIdx++;
						dfs(str + Integer.toString(i), gIdx, i);
						gIdx--;
						visit[i] = false;
					}
				}
			}
		}
	}
}
