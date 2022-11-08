package ps6087;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/6087
 * 레이저 통신
 * 2/2 6시간 소요 
 * https://www.acmicpc.net/board/view/32677
 * https://www.acmicpc.net/board/view/30941
 * 
 * 반례 케이스 
 * https://bingorithm.tistory.com/2
 * https://www.acmicpc.net/board/view/74494
 * */

// BFS에 사용되는 클래스 
class Point {
	int w; // 열 
	int h; // 행 
	int turn; // 방향이 전환되는 횟수 
	int dir; // 방향
	
	public Point(int h, int w, int turn, int dir) {
		this.h = h;
		this.w = w;
		this.turn = turn;
		this.dir = dir;
	}
}

public class Main {
	
	static int W;
	static int H;
	static String[] map;
	static int[] dh = {1, -1, 0, 0};
	static int[] dw = {0, 0, 1, -1};
	static int MAX = 2147483647;
	
	static Queue<Point> que; // BFS를 위한 큐 
	static Queue<Point> laser; // 레이저 시작점, 도착점 좌표 저장 큐 
	static int[][] turnCount; // 각 위치에서의 회전 횟수를 저장하는 배열 

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new String[101];
		que = new LinkedList<Point>();
		laser = new LinkedList<Point>();
		turnCount = new int[101][101];
		
		for(int i = 0; i < H; i++) {
			map[i] = br.readLine().toString();
		}
		
		// 최소 회전수 값을 찾는 것이므로 최댁값으로 값 초기화 
		for(int i = 0; i < H; i++)
			for(int j = 0; j < W; j++)
				turnCount[i][j] = MAX;
		
		// 레이저가 있는 두 좌표를 저장.
		// 첫 번째 입력된 좌표를 출발점, 두 번째 입력된 좌표를 도착점으로 지정 
		for(int i = 0; i < H; i++)
			for(int j = 0; j < W; j++)
				if(map[i].charAt(j) == 'C')
					laser.add(new Point(i, j, 0, 0));
		
		// 출발점 레이저는 회전수가 0이므로 값 초기화 후, 레이저 큐에서 제거 후 BFS용 큐에 저장
		turnCount[laser.peek().h][laser.peek().w] = 0;
		Point firstLaser = laser.poll();
		// 출발점 레이저에 대해 네 방향에 대한 데이터를 큐에 추가 
		// 출발점에서 출발하는 것이므로 방향이 꺾이는게 아니다. 그래서 회전수는 0
		for(int i = 0; i < 4; i++) {
			int nh = firstLaser.h + dh[i];
			int nw = firstLaser.w + dw[i];
			if(0 <= nh && nh < H && 0 <= nw && nw < W && map[nh].charAt(nw) != '*')
				que.add(new Point(nh, nw, 0, i));
		}
		
		while(! que.isEmpty()) {
			Point p = que.poll();
			int h = p.h;
			int w = p.w;
			int turn = p.turn;
			int dir = p.dir;
			
			// 현재 탐색중인 좌표가 도착점 좌표와 일치할 경우 
			if(laser.peek().h == h && laser.peek().w == w) {
				// 현재 탐색중인 도착점 좌표의 회전수 데이터가 기존에 저장된 회전수 데이터보다 클 경우
				// 현재 탐색중인 좌표에 대해 다음 방향에 대해서 탐색을 진행하지 않는다 
				// why??
				if(turnCount[laser.peek().h][laser.peek().w] < turn)
					continue;
			}
			
			for(int i = 0; i < 4; i++) {
				int nh = h + dh[i];
				int nw = w + dw[i];
				
				// 다음 이동할 좌표가 입력한 높이/너비 범위 안이고 벽이 아닐 경우 
				if(0 <= nh && nh < H && 0 <= nw && nw < W && map[nh].charAt(nw) != '*') {
					// 현재 방향이 다음 이동할 방향과 다를 경우 
					if(dir != i)  {
						// 거울을 설치해서 방향을 전환해야 하므로 현재 위치에서의 회전수에 1을 더한다.
						// 회전수 + 1 값이 다음 위치의 회전수 값보다 작으면 값 갱신 후 큐에 위치 및 회전수, 방향 데이터 저장 
						if(turnCount[nh][nw] >= turn + 1) {		
							turnCount[nh][nw] = turn + 1;
							que.add(new Point(nh, nw, turn + 1, i));
						}
					}
					// 현재 방향과 다음 이동할 방향이 같은 경
					else {
						// 현재 회전수 값으로 다음 위치 회전수 값 비교 
						// 더 작으면 갱신 및 큐에 데이터 삽입 
						if(turnCount[nh][nw] >= turn) {		
							turnCount[nh][nw] = turn;
							que.add(new Point(nh, nw, turn, i));
						}
					}
				}
			}
		}
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				System.out.print(turnCount[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(turnCount[laser.peek().h][laser.peek().w]);
	}
	
	// 안씀 
	// 반대편 방향에 대해서는 고려할 필요가 없다.
	// 다음 방향에서 탐색할땐 turn + 1 값으로 비교를 하는데, 이 경우 이미 turn + 1 값이 더 크므로 비교 대상이 되지 않기 때문 
	public static int getNoTurnDir(int dir) {
		if(dir == 0)
			return 1;
		else if(dir == 1)
			return 0;
		else if(dir == 2)
			return 3;
		else
			return 2;
	}

}
