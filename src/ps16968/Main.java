package ps16968;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/16968
 * 차량 번호판 1
 * */
public class Main {
	static char[] chr;
	static int c = 26;
	static int d = 10;
	static int result = 1;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		chr = br.readLine().toCharArray();
		
		if(chr[0] == 'c')
			result *= c;
		else
			result *= d;
		
		for(int i = 1; i < chr.length; i++) {
			if(chr[i] == 'c') {
				if(chr[i - 1] == 'c') {
					result *= (c - 1);
				}
				else {
					result *= c;
				}
			}
			else {
				if(chr[i - 1] == 'd') {
					result *= (d - 1);
				}
				else {
					result *= d;
				}
			}
		}
		
		System.out.println(result);
	}

}
