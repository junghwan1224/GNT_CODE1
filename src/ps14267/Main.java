package ps14267;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/14267
 * 회사 문화 1
 * */
public class Main {
	static int N;
	static int M;
	static ArrayList<Integer>[] list;
	static int[] point;
	static boolean[] visit;
	static int[] result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		point = new int[N + 1];
		visit = new boolean[N + 1];
		result = new int[N + 1];
		
		for(int i = 0; i <= N; i++)
			list[i] = new ArrayList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(a != -1)
				list[a].add(i); // a 직속 부하 리스트에 부하(i) 추가 
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 직원 a가 받은 칭찬 수치 b 
			point[a] += b;
		}
		
		for(int i = 1; i <= N; i++)
			if(! visit[i])
				dfs(i);
		
		StringBuffer sb = new StringBuffer();
		for(int i = 1; i <= N; i++)
			sb.append(result[i]).append(" ");
		System.out.println(sb);
	}

	public static void dfs(int n) {
		// 방문 처리 
		visit[n] = true;
		// 직원 n이 받은 누적 칭찬 수치에 입력받은 수치(point[n]) 더해줌 
		result[n] += point[n];
		
		// 직속 부하에게도 칭찬 점수 부여 
		for(Integer next: list[n]) {
			// 이미 점수를 부여한 부하면 패스 
			if(! visit[next]) {
				// 상사(n)가 받은 총 칭찬 점수를 부하에게 누적시킴 
				result[next] += result[n];
				dfs(next);
			}
		}
	}
}
