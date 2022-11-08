package ps17087;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/17087
 * 숨바꼭질 6
 * 소요시간: 
 * */
public class Main {
	
	static int n;
	static int s;
	static int result;
	static int[] loc; // 동생 위치.
	static int[] diff; // 주인공 위치에서 동생 위치 차이의 절댓값.

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		loc = new int[n];
		diff = new int[n];
		result = 1000000000;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			loc[i] = Integer.parseInt(st.nextToken());
			diff[i] = Math.abs(loc[i] - s);
		}
		
		// 차의 최대공약수 도출.
		int result = diff[0];
		for(int i = 1; i < n; i++) {
			result = GCD(result, diff[i]);
		}
		
		System.out.println(result);
	}
	
	static int GCD(int n1, int n2) {
		System.out.println(n1 + " , " + n2);
		if(n2 == 0) return n1;
		else return GCD(n2, n1 % n2);
	}

}
