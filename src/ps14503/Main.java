package ps14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/14503
 * 로봇 청소기
 * */
class Node {
	int r;
	int c;
	int d;
	
	public Node(int r, int c, int d) {
		this.r = r;
		this.c = c;
		this.d = d;
	}
}

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static Queue<Node> que;
	static boolean[][] visit;
	static int result;
	
	// d가 0인 경우에는 북쪽을, 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽을
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visit = new boolean[N][M];
		que = new LinkedList<Node>();
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		que.add(new Node(r, c, d));
		visit[r][c] = true;
		result += 1;
		
		while(! que.isEmpty()) {
			Node cur = que.poll();
			
			int turnCnt = 0;
			int curDir = cur.d;
			// 2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행
			for(int i = 0; i < 4; i++) {
				int nextDir = rotate(curDir);
				int ny = cur.r + dy[nextDir];
				int nx = cur.c + dx[nextDir];
				
				// 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행
				if(0 <= ny && ny < N && 0 <= nx && nx < M && ! visit[ny][nx] && arr[ny][nx] != 1) {		
					// 왼쪽 방향에 아직 청소하지 않은 공간 청소
					result++;
					visit[ny][nx] = true;
					que.add(new Node(ny, nx, nextDir));
					break;
				}
				
				// 2.2 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
				curDir = nextDir;
				turnCnt++;
			}
			
			// 2.3 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
			if(turnCnt == 4) {
				int backDir = goBack(curDir);
				int ny = cur.r + dy[backDir];
				int nx = cur.c + dx[backDir];
				
				if(0 <= ny && ny < N && 0 <= nx && nx < M && arr[ny][nx] != 1) {
					que.add(new Node(ny, nx, curDir));
				}
			}
		}
		
		System.out.println(result);
	}

	// d가 0인 경우에는 북쪽을, 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽을
	public static int rotate(int dir) {
		if(dir == 0)
			return 3;
		else if(dir == 1)
			return 0;
		else if(dir == 2)
			return 1;
		else
			return 2;
	}
	
	public static int goBack(int dir) {
		if(dir == 0)
			return 2;
		else if(dir == 1)
			return 3;
		else if(dir == 2)
			return 0;
		else
			return 1;
	}
}
