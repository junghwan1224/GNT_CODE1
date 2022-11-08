package ps2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2206
 * 벽 부수고 이동하기 
 * https://www.acmicpc.net/board/view/27386
 * */
class Node {
	int y;
	int x;
	int cnt;
	int wall; // 벽 부쉈는지 여부 
	
	public Node(int y, int x, int cnt, int wall) {
		this.y = y;
		this.x = x;
		this.cnt = cnt;
		this.wall = wall;
	}
}

public class Main {
	static int N, M;
	static char[][] arr;
	static boolean[][][] visit;
	static Queue<Node> que;
	static int dy[] = {1, -1, 0, 0};
	static int dx[] = {0, 0, 1, -1};
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		// visit[n][m][i] = (n, m) 까지 오는데 
		// i = 0 벽을 뚫지 않고 왔을 경우, 1 벽을 한 번이라도 뚫고 온 경우
		visit = new boolean[N][M][2]; 
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		que = new LinkedList<Node>();
		que.add(new Node(0, 0, 1, 0));
		visit[0][0][0] = true;
		result = -1;
		
		while(! que.isEmpty()) {
			Node cur = que.poll();
			
			if(cur.y == N - 1 && cur.x == M - 1) {
				result = cur.cnt;
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if(0 <= ny && ny < N && 0 <= nx && nx < M) {
					// 벽이 아니고 이동 가능하다면 
					if(arr[ny][nx] == '0' && ! visit[ny][nx][cur.wall]) {
						visit[ny][nx][cur.wall] = true;
						que.add(new Node(ny, nx, cur.cnt + 1, cur.wall));
					}
					// 벽이고 지금까지 벽을 부순 적이 없다면 
					else if(arr[ny][nx] == '1' && cur.wall == 0) {
						// 벽을 부순 경우에 대한 방문처리 및 다음 위치 큐에 저장 
						visit[ny][nx][cur.wall + 1] = true;
						que.add(new Node(ny, nx, cur.cnt + 1, cur.wall + 1));
					}
				}
			}
		}
		
		System.out.println(result);
	}

}
