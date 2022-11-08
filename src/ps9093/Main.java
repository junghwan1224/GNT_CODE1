package ps9093;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/9093
 * 단어 뒤집기
 * */
public class Main {
	static int T;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		for(int t = 0; t < T; t++) {
			String str = br.readLine();
			String[] arr = str.split(" ");
			
			for(int i = 0; i < arr.length; i++) {
				for(int j = arr[i].length() - 1; j >= 0; j--) {
					sb.append(arr[i].substring(j, j + 1));
				}
				sb.append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
