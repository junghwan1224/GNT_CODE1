package ps16974;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/16974
 * 레벨 햄버거
 * 접근법만 참고해보자: https://100100e.tistory.com/261
 * */
public class Main {
	static int N;
	static long X;
	static long[] bugger;
	static long[] patty;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		X = Long.parseLong(st.nextToken());
		
		bugger = new long[51];
		patty = new long[51];
		
		bugger[0] = 1;
		patty[0] = 1;
		
		for(int i = 1; i <= N; i++) {
			bugger[i] = 3 + (2 * bugger[i - 1]);
			patty[i] = 1 + (2 * patty[i - 1]);
		}
		
		System.out.println(getPattyCount(N, X));
	}

	public static long getPattyCount(int n, long x) {
		// 레벨이 0인 햄버거일 경우 
		if(n == 0) {
			// 햄버거 0장 먹었을 때 먹은 패티수는 0이다 
			if(x == 0)
				return 0;
			// 햄버거 1장 먹었을 때 먹은 패티수는 1이다 
			else if(x == 1)
				return 1;
		}
		
		// 한장만 먹었으면 햄버거 번만 먹은 것이므로 0 반환
		if(x == 1) 
			return 0;
		
		// 딱 절반까지 먹었을 때
		// 처음 햄버거번 1 + 가운데 패티 1 + 번과 패티 사이 레벨(n-1) 버거까지 먹은 것이므로 가운데 패티와 레벨(n-1)버거의 패티 수 더한 값 반환 
		else if(x == 2 + bugger[n - 1])
			return 1 + patty[n - 1];
		
		// 절반보다 조금 먹었을 때(가운데 페티 제외)
		// 레벨(n - 1)버거에서 먹은 패티 수를 찾아낸다.
		else if(x <= 1 + bugger[n - 1])
			return getPattyCount(n - 1, x - 1);
		
		// 절반보다 많이 먹고 다 먹은건 아닐 때
		// 위 조건에서의 반환 값에다가 절반보다 더 먹은 만큼 더해준다 
		// x - (bugger[n - 1] + 2) => 절반보다 더 먹은 길이 x - (앞에 햄버거 번 1 + 가운데 패티 1 + 패티 수 계산한 레벨n-1버거 길이) 
		else if(x <= 1 + bugger[n - 1] + 1 + bugger[n - 1])
			return 1 + patty[n - 1] + getPattyCount(n - 1, x - (bugger[n - 1] + 2));
		
		// 그 외는 다 먹은 경우, 가운데 패티와 레벨(n-1)버거 2개의 패티수 더해줌
		else
			return 1 + (2 * patty[n - 1]);
		
	}
}
