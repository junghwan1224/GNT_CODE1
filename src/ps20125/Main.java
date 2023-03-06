package ps20125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/20125
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] arr = new char[n][n];
		for(int i = 0; i < n; i++)
			arr[i] = br.readLine().toCharArray();
		
		int heartY = 0;
		int heartX = 0;
		
		int leftArm = 0;
		int rightArm = 0;
		int waist = 0;
		int leftLeg = 0;
		int rightLeg = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(0 <= (i - 1) && (i + 1) < n && 0 <= (j - 1) && (j + 1) < n) {
					// 본인, 위, 아래, 좌, 우 모두 * 이면 심장
					if(arr[i][j] == '*' && arr[i - 1][j] == '*' && arr[i + 1][j] == '*' && arr[i][j - 1] == '*' && arr[i][j + 1] == '*') {
						heartY = i;
						heartX = j;
					}
				}
			}
		}
		
		int idx = heartX - 1;
		while(idx >= 0 && arr[heartY][idx] == '*' ) {
			leftArm++;
			idx--;
		}
		
		idx = heartX + 1;
		while(idx < n && arr[heartY][idx] == '*' && idx < n) {
			rightArm++;
			idx++;
		}
		
		idx = heartY + 1;
		while(idx < n && arr[idx][heartX] == '*') {
			waist++;
			idx++;
		}
		
		int leftLegIdx = idx;
		int rightLegIdx = idx;
		idx = heartX - 1;
		
		while(leftLegIdx < n && arr[leftLegIdx][idx] == '*') {
			leftLeg++;
			leftLegIdx++;
		}
		
		idx = heartX + 1;
		while(rightLegIdx < n && arr[rightLegIdx][idx] == '*') {
			rightLeg++;
			rightLegIdx++;
		}
		
		System.out.println((heartY + 1) + " " + (heartX + 1));
		System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
	}

}
