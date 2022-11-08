package ps16943;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/16943
 * 숫자 재배치
 * 소요시간: 50분.
 * */
public class Main {
	
	static int result;
	static int a, b;
	static int digit;
	static String[] numA; // 입력받은 a의 각 자릿수를 저장하는 배열.
	static ArrayList<Integer> per; // a의 순열 결과를 저장하는 리스트.
	static boolean[] visit; // 방문 체크.
	static String str; // 순열 값을 저장하기 위해 사용하는 임시 문자열 변수.

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		// a의 자릿수 추출.
		int tmp = a;
		while(tmp != 0) {
			digit++;
			tmp /= 10;
		}
		
		// a의 각 자릿수별 수를 numA에 저장.
		tmp = a;
		numA = new String[digit];
		for(int i = 0; i < digit; i++) {
			numA[i] = Integer.toString(tmp % 10);
			tmp /= 10;
		}
		
		// 전역변수 초기화.
		result = -1;
		per = new ArrayList<Integer>();
		visit = new boolean[digit];
		str = "";
		
		// a의 순열 구하기.
		dfs(0);
		// dfs2(0, "");
		
		// 순열을 통해 구한 결과 값 중, b보다 낮은 최댓값 도출.
		for(Integer n: per) {
			// System.out.println(n);
			if(n < b)
				result = Math.max(result, n);
			
			System.out.println(n);
		}
		
		System.out.println(result);
	}

	// a의 순열 구하기.
	public static void dfs(int step) {
		// 자릿수가 맞춰지면 per 리스트에 값 추가 후 함수 종료.
		// 맨 앞에 0으로 들어가선 안되는걸 보아 자릿수는 맞춰야 하는듯?
		if(step == digit) {
			per.add(Integer.parseInt(String.join("", str)));
			return;
		}
		
		for(int i = 0; i < digit; i++) {
			// 이미 방문한 숫자면 패스.
			if(visit[i])
				continue;
			
			// 처음(맨 앞)에 오는 숫자가 0이면 패스.
			if(step == 0 && numA[i].equals("0"))
				continue;  
			
			// 현재 숫자 방문처리 후 현재까지 만들어진 값에 현재 탐색 중인 수 붙이고 재귀 호출.
			visit[i] = true;
			str = str + numA[i];
			dfs(step + 1);
			
			// 재귀 호출하고나면 탐색중인 수 빼고 미방문 상태로 변경.
			str = str.substring(0, str.length() - 1);
			visit[i] = false;
		}
	}
	
	public static void dfs2(int step, String s) {
		// 자릿수가 맞춰지면 per 리스트에 값 추가 후 함수 종료.
		// 맨 앞에 0으로 들어가선 안되는걸 보아 자릿수는 맞춰야 하는듯?
		if(step == digit) {
			per.add(Integer.parseInt(String.join("", s)));
			return;
		}
		
		for(int i = 0; i < digit; i++) {
			// 이미 방문한 숫자면 패스.
			if(visit[i])
				continue;
			
			// 처음(맨 앞)에 오는 숫자가 0이면 패스.
			if(step == 0 && numA[i].equals("0"))
				continue;  
			
			// 현재 숫자 방문처리 후 현재까지 만들어진 값에 현재 탐색 중인 수 붙이고 재귀 호출.
			visit[i] = true;
			// s = s + numA[i];
			dfs2(step + 1, s + numA[i]);
			
			// 재귀 호출하고나면 탐색중인 수 빼고 미방문 상태로 변경.
			// str = str.substring(0, str.length() - 1);
			visit[i] = false;
		}
	}
}
