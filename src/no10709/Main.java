package no10709;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/10709
 * 기상캐스터
 * */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int h = 0;
		int w = 0;
		String[] arr = null;
		int[][] res = null; // 결과값.
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			arr = new String[h];
			res = new int[h][w];
			
			for(int i = 0; i < h; i++) {
				arr[i] = br.readLine();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		int cnt = 0; // 구름이 뜨는 시각.
		
		// 구름이 뜰 수 없는 경우에는 -1이므로, -1로 초기화.
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				res[i][j] = -1;
			}
		}
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				// 현재 위치에 구름이 있으면.
				if(arr[i].charAt(j) == 'c') {
					// 0으로 값 세팅.
					res[i][j] = 0;
					// 시간 초기화.
					cnt = 0;
					// 구름이 존재하면 다음 칸부터 시간 1씩 증가.
					for(int k = j + 1; k < w; k++) {
						// 시간 증가하다가 구름 나타나면 반복문 종료.
						if(arr[i].charAt(k) == 'c')
							break;
						res[i][k] = ++cnt;
					}
				}
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					bw.write(res[i][j] + " ");
				}
				bw.write("\n");
			}
			
			bw.flush();
			
			br.close();
			bw.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
