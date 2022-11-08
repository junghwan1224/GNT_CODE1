package ps1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1780
 * 종이의 개수
 * */
public class Main {
	static int N;
	static int[][] paper;
	static int[] result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		paper = new int[2500][2500];
		result = new int[3];
		
		StringTokenizer st = null;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				// result 배열의 인덱스 값으로 관리하기 위해 -1, 0, 1 값에 1을 더해줌 
				paper[i][j] = Integer.parseInt(st.nextToken()) + 1;
			}
		}
		
		divide(0, 0, N);
		
		StringBuffer sb = new StringBuffer();
		sb.append(result[0]).append("\n");
		sb.append(result[1]).append("\n");
		sb.append(result[2]).append("\n");
		
		System.out.println(sb);
	}

	// 종이가 같은 수로 되어 있는지 확인 
	public static boolean check(int row, int col, int num) {
		int start = paper[row][col];
		for(int i = row; i < row + num; i++) {
			for(int j = col; j < col + num; j++) {
				if(paper[i][j] != start)
					return false;
			}
		}
		return true;
	}
	
	// 종이 9개로 나누기 
	public static void divide(int row, int col, int num) {
		// 종이가 모두 같은 수로 이루어져 있다면 현재 크기의 종이 그대로 사용 
		if(check(row, col, num)) {
			result[paper[row][col]]++;
		}
		
		// 그렇지 않다면 
		else {
			// 종이 9개로 나누기 
			int size = num / 3;
			
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					// 9개로 나누어진 종이에 대해서 같은 수로 되어 있는지 확인
					divide(row + size * i, col + size * j, size);
				}
			}
		}
	}
}
