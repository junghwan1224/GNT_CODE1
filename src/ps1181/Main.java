package ps1181;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

/*
 * https://www.acmicpc.net/problem/1181
 * 단어 정렬
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String[] str = new String[n];
		
		for(int i = 0; i < n; i++)
			str[i] = br.readLine();
		
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				// 길이가 같으면 사전순 정렬 
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				// 그 외에는 길이순 정렬 
				else
					return s1.length() - s2.length();
			}
		});
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append(str[0] + "\n");
		String before = str[0];
		for(int i = 1; i < n; i++) {
			if(before.equals(str[i]))
				continue;
			bw.append(str[i] + "\n");
			before = str[i];
		}
		
		bw.flush();
		
		br.close();
		bw.close();
	}

}
