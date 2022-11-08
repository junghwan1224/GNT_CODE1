package ps1080;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1080
 * 행렬
 * */
public class Main {
	static int N;
	static int M;
	static char[][] arr1;
	static char[][] arr2;
	static boolean[][] check;
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr1 = new char[N][M];
		arr2 = new char[N][M];
		check = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			arr1[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < N; i++) {
			arr2[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				// 값 다른건 true로 체크 
				if(arr1[i][j] != arr2[i][j]) {
					check[i][j] = true;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				// 3*3 크기로 연산을 실행하므로 끝 점이 행렬 크기를 넘어서지 않는지 확인 
				if(i + 2 >= N || j + 2 >= M)
					continue;
				
				// 탐색하고자 하는 칸의 값이 다르면 
				if(check[i][j]) {
					// 뒤집기 연산 실행 
					reverse(i, j);
					// 연산횟수 1 더해줌 
					result++;
				}
				
				// 두 행렬이 같다면 반복문 종료 
				if(isArrSame())
					break;
			}
		}
		
		// 두 행렬이 같으면 연산횟수 출력 
		if(isArrSame())
			System.out.println(result);
		// 그렇지 않으면 -1 출력 
		else
			System.out.println(-1);
	}

	public static void reverse(int y, int x) {
		for(int i = y; i < y + 3; i++) {
			for(int j = x; j < x + 3; j++) {
				check[i][j] = check[i][j] ? false : true;
			}
		}
	}
	
	public static boolean isArrSame() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(check[i][j])
					return false;
			}
		}
		
		return true;
	}
}
