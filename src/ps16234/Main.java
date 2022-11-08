package ps16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/16234
 * 인구 이동
 * */
class Node {
	int y;
	int x;
	
	public Node(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static int N;
	static int L;
	static int R;
	static int[][] A;
	static boolean[][] visit;
	static int MAX = 55;
	static Queue<Node> que;
	static Queue<Node> cntQue; // 인구 이동이 일어날 수 있는 정점 저장 
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static int result;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		A = new int[MAX][MAX];
		visit = new boolean[MAX][MAX];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		} 
		
		flag = true;
		while(flag) {
			flag = false;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(! visit[i][j] && isOpenPossible(i, j)) {
						bfs(i, j);
						flag = true;
					}
				}
			}
			
			if(flag)
				result++;
			// 순회 끝났으니 방문 여부 초기화
			visit = new boolean[MAX][MAX];
		}
		
		System.out.println(result);
	}

	public static boolean isOpenPossible(int y, int x) {
		for(int k = 0; k < 4; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			
			// 국경이 하나라도 열려있으면 이동 가능하다고 판단 
			if(0 <= ny && ny < N && 0 <= nx && nx < N)
				if(L <= Math.abs(A[y][x] - A[ny][nx]) && Math.abs(A[y][x] - A[ny][nx]) <= R)
					return true;
		}
		return false;
	}
	
	public static boolean openCheck(int y, int x, int y2, int x2) {
		if(L <= Math.abs(A[y][x] - A[y2][x2]) && Math.abs(A[y][x] - A[y2][x2]) <= R)
			return true;
		return false;
	}
	
	public static void bfs(int i, int j) {
		que = new LinkedList<Node>();
		cntQue = new LinkedList<Node>();
		int sum = 0;
		int cnt = 0;
		visit[i][j] = true;
		que.add(new Node(i, j));
		cntQue.add(new Node(i, j));
		
		while(! que.isEmpty()) {
			Node cur = que.poll();
			
			sum += A[cur.y][cur.x];
			cnt++;
			
			for(int k = 0; k < 4; k++) {
				int ny = cur.y + dy[k];
				int nx = cur.x + dx[k];
				
				if(0 <= ny && ny < N && 0 <= nx && nx < N) {
					if(! visit[ny][nx] && openCheck(cur.y, cur.x, ny, nx)) {
						Node next = new Node(ny, nx);
						visit[ny][nx] = true;
						que.add(next);
						cntQue.add(next);
					}
				}
			}
		}
		
		int divValue = sum / cnt;
		while(! cntQue.isEmpty()) {
			Node cur = cntQue.poll();
			A[cur.y][cur.x] = divValue;
		}
	}
}
