package ps1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1107
 * 리모컨
 * */
public class Main {
	static int N;
	static int M;
	static boolean[] broken; // 고장났으면 true
	static int MAX = 1000001;
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		broken = new boolean[10];
		
		if(M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				int a = Integer.parseInt(st.nextToken());
				broken[a] = true;
			}
		}
		
		// 초기 채널(100)에서 +, - 버튼으로만 이동할 때 누르는 횟수 
		result = Math.abs(N - 100);
		
		for(int i = 0; i < MAX; i++) {
			// 채널별로 순회하면서 숫자 버튼 클릭 횟수를 찾아낸다. 
			int clickCnt = check(i);
			
			// 숫자버튼을 클릭할 수 있다면 
			if(clickCnt > 0) {
				// 현재 채널(i)에서 이동하고자 하는 채널(N)으로 이동할 때 눌러야 하는 +,- 버튼 횟수 
				int plusMinus = Math.abs(N - i);
				// 숫자버튼 누른 횟수와 +,- 버튼 누른 횟수 더한 값을 가지고 최솟값 갱신 
				result = Math.min(result, plusMinus + clickCnt);
			}
		}
		
		System.out.println(result);
	}

	// 리모컨 누른 횟수 반환 
	public static int check(int n) {
		int cnt = 0;
		
		// 0번 한자리만 누를 경우 
		if(n == 0) {
			// 고장나면 누르지 못하므로 0 반환 
			if(broken[n])
				return 0;
			// 고장나지 않았으면 0번 누르면 되므로 1 반환 
			else
				return 1;
		}
		
		// 한 자릿수씩 뽑아서 해당 버튼이 고장났는지 여부 확인 후, 고장 안났으면 cnt값을 1씩 더하여 버튼 누른 횟수 반환 
		while(n > 0) {
			if(broken[n % 10])
				return 0;
			
			cnt++;
			n /= 10;
		}
		
		return cnt;
	} 
}
