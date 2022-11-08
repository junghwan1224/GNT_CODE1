package ps5427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/5427
 * 불
 * */

// 주인공의 위치 및 걸리는 시간 관리하는 노드 
class Node {
	int y;
	int x;
	int t;
	
	public Node(int y, int x, int t) {
		this.y = y;
		this.x = x;
		this.t = t;
	}
}

// 불의 위치 관리하는 노드
class FireNode {
	int y;
	int x;
	
	public FireNode(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static int T;
	static Queue<Node> que;
	static Queue<FireNode> fireQue;
	static int h, w, time;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static char[][] map;
	static int[][] fire; // 불이 몇 초 뒤에 해당 지점에 퍼지는 지에 대한 정보 저장 
	static boolean[][] visit;
	static int MAX = 987654321;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			visit = new boolean[h][w];
			map = new char[h][w];
			fire = new int[h][w];
			
			for(int i = 0; i < h; i++)
				map[i] = br.readLine().toCharArray();
			
			for(int i = 0; i < h; i++)
				for(int j = 0; j < w; j++)
					fire[i][j] = MAX;
			
			time = MAX;
			que = new LinkedList<Node>();
			fireQue = new LinkedList<FireNode>();
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == '@') {
						que.add(new Node(i, j, 0));
						visit[i][j] = true;
					}
				}
			}
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == '*') {
						fireQue.add(new FireNode(i, j));
						fire[i][j] = 0;
					}
				}
			}
			
			spreadFire();
			escapeBFS();
			
			String s = (time == MAX) ? "IMPOSSIBLE" : Integer.toString(time + 1);
			sb.append(s).append("\n");
		}
		
		System.out.println(sb);
	}

	// 불이 번지고 각 위치마다 몇 초 뒤에 번지는지 업데이트 
	public static void spreadFire() {
		while(! fireQue.isEmpty()) {
			FireNode cur = fireQue.poll();
			
			for(int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if(0 <= ny && ny < h && 0 <= nx && nx < w) {
					// 벽이 아니고, 번지지 않았거나 더 빨리 번지는 경우에 값 업데이트 및 큐에 위치 추가 
					if(map[ny][nx] != '#' && fire[ny][nx] > fire[cur.y][cur.x] + 1) {
						fire[ny][nx] = fire[cur.y][cur.x] + 1;
						fireQue.add(new FireNode(ny, nx));
					}
				}
			}
		}
	}
	
	// 주인공이 도망치면서 걸린 시간 구하기 
	public static void escapeBFS() {
		while(! que.isEmpty()) {
			Node cur = que.poll();
			
			int y = cur.y;
			int x = cur.x;
			
			// 벽에 도달했을 경우 걸린 시간 리턴 
			if(y == 0 || y == (h - 1) || x == 0 || x == (w - 1)) {
				time = cur.t;
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(0 <= ny && ny < h && 0 <= nx && nx < w) {
					// 다음 이동할 위치가 빈 공간이고, 이동할 때 걸릴 시간이 불이 번지기 전이면 다음 위치로 이동 
					if(! visit[ny][nx] && map[ny][nx] == '.' && fire[ny][nx] > cur.t + 1) {
						visit[ny][nx] = true;
						que.add(new Node(ny, nx, cur.t + 1));
					}
				}
			}
		}
		
		time = MAX;
		return;
	}
}
