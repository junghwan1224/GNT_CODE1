package ps3036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/3036
 * 링
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < n; i++) {
			sb.append(arr[0] / gcd(arr[0], arr[i])).append("/").append(arr[i] / gcd(arr[0], arr[i])).append("\n");
		}
		
		System.out.println(sb);
	}

	public static int gcd(int a, int b) {
		int aa = Math.max(a, b);
		int bb = Math.min(a, b);
		int tmp = 0;
		
		while(bb != 0) {
			tmp = aa % bb;
			aa = bb;
			bb = tmp;
		}
		
		return aa;
	}
}
