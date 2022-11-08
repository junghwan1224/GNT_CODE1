package ps11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/11399
 * ATM
 * */
public class Main {
	static int n;
	static int atm[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		atm = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			atm[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(atm);
		
		int result = atm[0];
		
		for(int i = 1; i < n; i++) {
			result += atm[i];
			for(int j = 0; j < i; j++)
				result += atm[j];
		}
		
		System.out.println(result);
	}

}
