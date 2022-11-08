package ps1062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1062
 * 가르침
 * */
public class Main {
	static int n;
	static int k;
	static String[] words;
	static boolean[] alphabet; // 읽을 수 있는 문자인지 판별하는 배열 
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		words = new String[n];
		alphabet = new boolean[26];
		for(int i = 0; i < n; i++)
			words[i] = br.readLine();
		
		/*
		 * 'anta' 'tica'에 해당하는 문자는 모두 읽을 수 있어야 하기 때문에 해당 값에 대한 값을 미리 true로 세팅 
		 * */
		alphabet['a' - 'a'] = true;
		alphabet['n' - 'a'] = true;
		alphabet['t' - 'a'] = true;
		alphabet['i' - 'a'] = true;
		alphabet['c' - 'a'] = true;
		
		/*
		 * 읽을 수 있는 글자가 5개보다 적다면, 'anta', 'tica'를 읽을 수 없다는 뜻이므로 결과값은 무조건 0이다.
		 * */
		if(k < 5)
			result = 0;
		else {
			// 'anta', 'tica'에서 사용되는 문자 5개를 제외한 나머지 갯수만큼 문자의 조합을 구성해야 하므로 5를 빼준다.
			k -= 5;
			dfs(0, 0);
		}
		
		System.out.println(result);
	}

	// (k-5)개만큼의 문자 조합 뽑아내기 
	public static void dfs(int idx, int cnt) {
		if(cnt == k) {
			// 조합 뽑았으면 읽을 수 있는 최대 단어 수 업데이트 
			result = Math.max(result, readPossibleCnt());
			return;
		}
		
		for(int i = idx; i < 26; i++) {
			if(alphabet[i])
				continue;
			
			alphabet[i] = true;
			dfs(i, cnt + 1);
			alphabet[i] = false;
		}
	}
	
	// (k-5)개의 문자를 조합으로 뽑아서 읽을 수 있는 문자로 판단했을 때, 읽을 수 있는 단어의 수 구하기
	public static int readPossibleCnt() {
		int cnt = 0;
		boolean flag = true;
		
		for(int i = 0; i < words.length; i++) {
			String s = words[i];
			flag = true;
			for(int j = 0; j < s.length(); j++) {
				if(! alphabet[s.charAt(j) - 'a']) {
					flag = false;
					break;
				}
			}
			
			if(flag)
				cnt++;
		}
		
		return cnt;
	}
}
