package ps14426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/14426
 * 접두사 찾기
 * */
public class Main {
	static int N;
	static int M;
	static String[] words;
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		words = new String[N];
		for(int i = 0; i < N; i++)
			words[i] = br.readLine();
		
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			int slen = str.length();
			
			for(int j = 0; j < N; j++) {
				if(words[j].substring(0, slen).equals(str)) {
					result++;
					break;
				}
			}
		}
		
		System.out.println(result);
	}

}
