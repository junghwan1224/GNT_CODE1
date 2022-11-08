package ps11729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/11729
 * 하노이 탑 이동 순서
 * */
public class Main {
	static int K;
	static int cnt;
	static StringBuffer sb;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		sb = new StringBuffer();
		hanoi(K, 1, 2, 3);
		
		System.out.println(cnt);
		System.out.println(sb);
	}

	/*
	 * hanoi => start에서 mid를 거쳐 end로 원반을 이동시킬 때의 이동 과정 
	 * n: 원판의 갯수 
	 * start: 시작점 
	 * mid: 경유지 
	 * end: 도착점 
	 * */
	public static void hanoi(int n, int start, int mid, int end) {
		// 원판이 한개 남았을 땐, 중간에 장대 거치지 않고 바로 도착점으로 옮긴다 
		if(n == 1)
			move(1, start, end);
		else {
			hanoi(n - 1, start, end, mid);
			move(n, start, end);
			hanoi(n - 1, mid, start, end);
		}
	}
	
	public static void move(int n, int start, int end) {
		// System.out.println(start + " " + end);
		sb.append(start).append(" ").append(end).append("\n");
		cnt++;
	}
}
