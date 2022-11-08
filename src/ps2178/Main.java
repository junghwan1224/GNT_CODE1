package ps2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2178
 * 미로 탐색
 * */
class Node {
	int y;
	int x;
	int cnt;
	
	public Node(int y, int x, int cnt) {
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
}

public class Main {
	static int n;
	static int m;
	static char[][] arr;
	static Queue<Node> que;
	static boolean[][] visit;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new char[n][m];
		visit = new boolean[n][m];
		for(int i = 0; i < n; i++)
			arr[i] = br.readLine().toCharArray();
		
		que = new LinkedList<Node>();
		que.add(new Node(0, 0, 1));
		visit[0][0] = true;
		
		while(! que.isEmpty()) {
			Node cur = que.poll();
			
			if(cur.y == n - 1 && cur.x == m - 1) {
				result = cur.cnt;
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if(0 <= ny && ny < n && 0 <= nx && nx < m && ! visit[ny][nx]) {
					if(arr[ny][nx] == '0')
						continue;
					visit[ny][nx] = true;
					que.add(new Node(ny, nx, cur.cnt + 1));
				}
			}
		}
		
		System.out.println(result);
	}

}
