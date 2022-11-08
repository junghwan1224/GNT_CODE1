package no2045;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2045
 * 마방진
 * */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[3][3];
		
		try {
			for(int i = 0; i < 3; i ++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				arr[i][2] = Integer.parseInt(st.nextToken());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		int zeroCnt = 0; // 탐색시 0의 갯수.
		int zeroX = 0; // 0이 위치한 x 좌표.
		int zeroY = 0; // 0이 위치한 y 좌표.
		int maxValue = 0; // 가로 or 세로 or 대각선이 빈 값이 아닐 때 모두 더한 값.
		int rest = 0; // 한 줄에서 0인 값을 제외한 나머지 값들의 합.
		
		/* maxValue 구하기. */
		
		// 대각선이 모두 0일 경우, 모든 값을 다 더해서 2로 나눠준다.
		if( (arr[0][0] + arr[1][1] + arr[2][2] == 0) || (arr[0][2] + arr[1][1] + arr[2][0]) == 0 ) {
			for (int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					maxValue += arr[i][j];
				}
			}
			
			maxValue /= 2;
		}
		
		// 그 외의 경우, 가로, 세로, 대각선 값을 더해서 maxValue 값 도
		else {
			// 가로 체크.
			for(int i = 0; i < 3; i++) {
				if(arr[i][0] != 0 && arr[i][1] != 0 && arr[i][2] != 0) {
					maxValue = arr[i][0] + arr[i][1] + arr[i][2];
				}
			}
			
			// 세로 체크.
			for(int i = 0; i < 3; i++) {
				if(arr[0][i] != 0 && arr[1][i] != 0 && arr[2][i] != 0) {
					maxValue = arr[0][i] + arr[1][i] + arr[2][i];
				}
			}
			
			// 대각선 체크.
			if(arr[0][0] != 0 && arr[1][1] != 0 && arr[2][2] != 0) {
				maxValue = arr[0][0] + arr[1][1] + arr[2][2];
			}
			
			if(arr[2][0] != 0 && arr[1][1] != 0 && arr[0][2] != 0) {
				maxValue = arr[2][0] + arr[1][1] + arr[0][2];
			}
		}
		
		/* 지워진 값 채우기. */
		
		// 가로
		for(int i = 0 ; i < 3; i++) {
			zeroCnt = 0;
			rest = 0;
			zeroX = 0;
			for(int j = 0; j < 3; j++) {
				// 0인 값이 있다면 해당 x좌표 저장 및 cnt++
				if(arr[i][j] == 0) {
					zeroCnt++;
					zeroX = j;
				}
				// 나머지 값 구하기.
				rest += arr[i][j];
			}
			
			// 해당 가로줄에 0이 한개만 있다면.
			if(zeroCnt == 1) {
				// maxValue에서 나머지 값 빼준게 지워진 값이므로, 해당 값 채워줌.
				arr[i][zeroX] = maxValue - rest;
			}
		}
		
		// 세로.
		for(int i = 0 ; i < 3; i++) {
			zeroCnt = 0;
			rest = 0;
			zeroY = 0;
			for(int j = 0; j < 3; j++) {
				if(arr[j][i] == 0) {
					zeroCnt++;
					zeroY = j;
				}
				rest += arr[j][i];
			}
			
			if(zeroCnt == 1 && arr[zeroY][i] == 0) {
				arr[zeroY][i] = maxValue - rest;
			}
		}
		
		zeroX = 0;
		zeroY = 0;
		zeroCnt = 0;
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					bw.write(arr[i][j] + " ");
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
