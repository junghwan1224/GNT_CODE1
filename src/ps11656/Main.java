package ps11656;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

/*
 * https://www.acmicpc.net/problem/11656
 * 접미사 배열
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int len = str.length();
		ArrayList<String> list = new ArrayList<String>();
		
		int idx = 1;
		String str2 = str;
		while(len >= idx) {
			list.add(str2);
			str2 = str.substring(idx++);
		}
		
		Collections.sort(list);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(String s: list) {
			bw.write(s);
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
