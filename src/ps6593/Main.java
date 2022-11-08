package ps6593;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/6593
 * 상범 빌딩
 * */
class Node {
	int x;
	int y;
	int z;
	int t;
	
	public Node(int x, int y, int z, int t) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.t = t;
	}
}

public class Main {
	static int L, R, C;
	static char[][][] arr;
	static StringBuffer sb;
	static Queue<Node> que;
	static boolean[][][] visit;
	static int[] dx = {1, -1, 0, 0, 0, 0};
	static int[] dy = {0, 0, 1, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		sb = new StringBuffer();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			if(L == 0 && R == 0 && C == 0) {
				break;
			}
			
			arr = new char[L][R][C];
			visit = new boolean[L][R][C];
			int sx = -1;
			int sy = -1;
			int sz = -1;
			
			for(int i = 0; i < L; i++) {
				for(int j = 0; j < R; j++) {
					arr[i][j] = br.readLine().toCharArray();
					for(int k = 0; k < C; k++) {
						if(arr[i][j][k] == 'S') {
							sx = i; sy = j; sz = k;
						}
					}
				}
				br.readLine();
			}
			
			bfs(sx, sy, sz);
		}
		
		System.out.println(sb);
	}

	public static void bfs(int sx, int sy, int sz) {
		que = new LinkedList<Node>();
		que.add(new Node(sx, sy, sz, 0));
		visit[sx][sy][sz] = true;
		
		while(! que.isEmpty()) {
			Node cur = que.poll();
			
			if(arr[cur.x][cur.y][cur.z] == 'E') {
				sb.append("Escaped in ").append(cur.t).append(" minute(s).").append("\n");
				return;
			}
			
			for(int i = 0; i < 6; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				int nz = cur.z + dz[i];
				
				if(0 <= nx && nx < L && 0 <= ny && ny < R && 0 <= nz && nz < C) {
					if(arr[nx][ny][nz] != '#' && ! visit[nx][ny][nz]) {
						visit[nx][ny][nz] = true;
						que.add(new Node(nx, ny, nz, cur.t + 1));
					}
				}
			}
		}
		
		sb.append("Trapped!").append("\n");
		return;
	}
}
