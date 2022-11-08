package ps11655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/11655
 * ROT13
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toString();
		
		for(int i = 0; i < str.length(); i++) {
			if( 'a' <= str.charAt(i) && str.charAt(i) <= 'z') {
				int n = (str.charAt(i) - 'a' + 13) % 26;
				System.out.print((char)(n + 'a'));
			}
			else if( 'A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
				int n = (str.charAt(i) - 'A' + 13) % 26;
				System.out.print((char)(n + 'A'));
			}
			else
				System.out.print(str.charAt(i));
		}
	}

}
