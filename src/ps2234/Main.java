package ps2234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2234
 * 성곽
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
	static int M;
	static int[][] A;
	static boolean[][] visit;
	static Queue<Node> que;
	static int[] dy = {0, -1, 0, 1};
	static int[] dx = {-1, 0, 1, 0};
	static int roomCnt = 0;
	static int roomSize = 0;
	static int maxRoomSize = 0;
	static int maxRoomSizeRemoveWall = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(! visit[i][j]) {
					roomSize = 0;
					bfs(i, j);
					roomCnt++;
					maxRoomSize = Math.max(maxRoomSize, roomSize);
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				// 벽 순회 (서, 북, 동, 남 순서로) 
				for(int wall = 1; wall <= 8; wall *= 2) {
					// 해당 방향에 벽이 있는 경우 
					if((A[i][j] & wall) == wall) {
						roomSize = 0;
						// 방문을 초기화 한다.
						visit = new boolean[N][M];
						// 벽 제거 
						A[i][j] -= wall;
						// 벽 제거 후 탐색 시작 
						bfs(i, j);
						// 탐색을 마쳤으면 다른 벽을 제거하고 결과를 봐야하므로 다시 벽 설치 
						A[i][j] += wall;
						maxRoomSizeRemoveWall = Math.max(maxRoomSizeRemoveWall, roomSize);
					}
				}
			}
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append(roomCnt).append("\n");
		sb.append(maxRoomSize).append("\n");
		sb.append(maxRoomSizeRemoveWall).append("\n");
		
		System.out.println(sb);
	}

	public static void bfs(int a, int b) {
		que = new LinkedList<Node>();
		que.add(new Node(a, b));
		visit[a][b] = true;
		roomSize++;
		
		while(! que.isEmpty()) {
			Node cur = que.poll();
			
			int wall = 1;
			for(int k = 0; k < 4; k++) {
				// & 연산을 통해 해당 방향에 벽이 있는지 확인 
				/*
				 * 11 & 1 = 1011 & 0001 = 0001
				 * 11 & 2 = 1011 & 0010 = 0010
				 * 11 & 4 = 1011 & 0100 = 0000
				 * 11 & 8 = 1011 & 1000 = 1000
				 * */
				if((A[cur.y][cur.x] & wall) != wall) {
					int ny = cur.y + dy[k];
					int nx = cur.x + dx[k];
					
					if(0 <= ny && ny < N && 0 <= nx && nx < M) {
						if(! visit[ny][nx]) {
							que.add(new Node(ny, nx));
							visit[ny][nx] = true;
							roomSize++;
						}
					}
				}
				
				wall *= 2;
			}
		}
	}
}
