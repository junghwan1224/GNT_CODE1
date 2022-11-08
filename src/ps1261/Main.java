package ps1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1261
 * 알고스팟
 * */
class Node{
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
	static int[][] miro;
	static int MAX = 987654321;
	
	static Queue<Node> que;
	static int[][] wall;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		miro = new int[M][N];
		wall = new int[M][N];
		for(int i = 0; i < M; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				miro[i][j] = Integer.parseInt(s.substring(j, j + 1));
				wall[i][j] = MAX;
			}
		}

		que = new LinkedList<Node>();
		que.add(new Node(0, 0));
		wall[0][0] = 0;
		
		while(! que.isEmpty()) {
			Node cur = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if(0 <= ny && ny < M && 0 <= nx && nx < N) {
					if(miro[ny][nx] == 1) {
						if(wall[ny][nx] > wall[cur.y][cur.x] + 1) {
							wall[ny][nx] = wall[cur.y][cur.x] + 1;
							que.add(new Node(ny, nx));
						}
							
					}
					else {
						if(wall[ny][nx] > wall[cur.y][cur.x]) {
							wall[ny][nx] = wall[cur.y][cur.x];
							que.add(new Node(ny, nx));
						}
					}
				}
			}
		}
		
		System.out.println(wall[M - 1][N - 1]);
	}

}
