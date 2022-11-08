package ps2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2589
 * 보물섬
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
	static char[][] arr;
	static int[][] dist;
	static boolean[][] visit;
	static Queue<Node> que;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		
		for(int i = 0; i < N; i++)
			arr[i] = br.readLine().toCharArray();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 'L') {
					visit = new boolean[N][M];
					dist = new int[N][M];
					que = new LinkedList<Node>();
					que.add(new Node(i, j));
					visit[i][j] = true;
					
					result = Math.max(result, bfs());
				}
			}
		}
		
		System.out.println(result);
	}

	public static int bfs() {
		int maxVal = 0;
		
		while(! que.isEmpty()) {
			Node cur = que.poll();
			
			maxVal = Math.max(maxVal, dist[cur.y][cur.x]);
			
			for(int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if(0 <= ny && ny < N && 0 <= nx && nx < M && ! visit[ny][nx] && arr[ny][nx] == 'L') {
					dist[ny][nx] = dist[cur.y][cur.x] + 1;
					visit[ny][nx] = true;
					que.add(new Node(ny, nx));
				}
			}
		}
		
		return maxVal;
	}
}
