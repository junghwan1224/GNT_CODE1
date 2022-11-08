package ps25344;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.acmicpc.net/problem/25344
 * 행성 정렬
 * */
public class Main {
	static int n;
	static long[] arr;
	static long result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new long[n - 2];
		arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		
		result = arr[0];
		if(n > 1) {
			for(int i = 1; i < n - 2; i++) {
				result = lcm(result, arr[i]);
			}
		}
		
		System.out.println(result);
	}

	public static long gcd(long a, long b) {
		long aa = Math.max(a, b);
		long bb = Math.min(a, b);
		
		while(bb != 0) {
			long tmp = aa % bb;
			aa = bb;
			bb = tmp;
		} 
		
		return aa;
	}
	
	public static long lcm(long a, long b) {
		return (a * b) * gcd(a, b);
	}
}
