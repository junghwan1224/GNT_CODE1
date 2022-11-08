package ps2607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * https://www.acmicpc.net/problem/2607
 * 비슷한 단어
 * ref: https://m.blog.naver.com/occidere/221095055060
 * */
public class Main {
	static int n;
	static String[] arr;
	static Map<Character, Integer> map;
	static Map<Character, Integer> tmpMap;
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new String[n];
		map = new HashMap<Character, Integer>();
		
		for(int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}
		
		char[] chr = arr[0].toCharArray();
		for(int i = 0; i < chr.length; i++)
			map.put(chr[i], map.getOrDefault(chr[i], 0) + 1);
		
		for(int i = 1; i < n; i++) {
			tmpMap = new HashMap<Character, Integer>();
			chr = arr[i].toCharArray();
			for(int j = 0; j < chr.length; j++)
				tmpMap.put(chr[j], tmpMap.getOrDefault(chr[j], 0) + 1);
			
			if(isSimilar(tmpMap))
				result++;
		}
		
		System.out.println(result);
	}

	public static boolean isSimilar(Map<Character, Integer> compMap) {
		int diff = 0;
		int stdLen = 0;
		int compLen = 0;
		
		for(char c = 'A'; c <= 'Z'; c++) {
			int stdCnt = map.getOrDefault(c, 0);
			int compCnt = compMap.getOrDefault(c, 0);
			
			// 단어의 전체 길이 구하기 
			stdLen += stdCnt;
			compLen += compCnt;
			// 기준이 되는 문자열과 비교 대상 문자열의 알파벳 갯수 차이 구하기
			// 알파벳 갯수 차이가 2개 이하여야 빼거나 더하거나 변형해서 비슷한 단어로 만들 수 있다 
			diff += Math.abs(stdCnt - compCnt);
		}
		
		return ((Math.abs(stdLen - compLen) <= 1) && (diff <= 2));
	}
}
