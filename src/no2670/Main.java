package no2670;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/2670
 * 연속부분최대곱
 * */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double[] arr = null;
		int n = 0;
		// d[i] = i번째 까지의 연속곱 최댓값.
		double[] d = null;
		double result = 1; // 결과값.
		
		try {
			n = Integer.parseInt(br.readLine());
			arr = new double[n];
			d = new double[n];
			
			for(int i = 0; i < n; i++) {
				arr[i] = Double.parseDouble(br.readLine());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		d[0] = arr[0];
		result = d[0];
		
		for(int i = 1; i < n; i++) {
			// 현재값과 이전의 연속곱 최댓값과 현재 값을 곱한 값을 비교하여 큰 값을 d[i]에 저장.
			d[i] = Math.max(arr[i], d[i-1] * arr[i]);
		}
		
		for(int i = 1; i < n; i++) {
			result = Math.max(result, d[i]);
		}
		
		// System.out.println(Math.round(result * 1000) / 1000.0);
		// 소수 셋째자리까지 출력.
		System.out.printf("%.3f", result);
	}

}
