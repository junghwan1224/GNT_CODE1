package ps4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/4179
 * */
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

class Fire {
	int y;
	int x;
	
	public Fire(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	
	static int R, C;
	static char[][] arr;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static int[][] fire;
	static boolean[][] visit;
	static Queue<Node> que;
	static Queue<Fire> fireQue;
	static int MAX = 987654321;
	static boolean flag;
	static int result = MAX;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		fire = new int[R][C];
		visit = new boolean[R][C];
		
		for(int i = 0; i < R; i++)
			arr[i] = br.readLine().toCharArray();
		
		for(int i = 0; i < R; i++)
			Arrays.fill(fire[i], MAX);

		que = new LinkedList<Node>();
		fireQue = new LinkedList<Fire>();
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				// ���ΰ� ��ġ ����
				if(arr[i][j] == 'J') {
					que.add(new Node(i, j, 0));
					visit[i][j] = true;
				}
				// ���� �� ��ġ ����
				else if(arr[i][j] == 'F') {
					fireQue.add(new Fire(i, j));
					fire[i][j] = 0;
				}
			}
		}
		
		spreadFire();
		escape();
		
		System.out.println(flag ? Integer.toString(result + 1) : "IMPOSSIBLE");
		
	}
	
	// �� �������� ���� �� �ð��� ����
	public static void spreadFire() {
		while(! fireQue.isEmpty()) {
			Fire cur = fireQue.poll();
			
			for(int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if(0 <= ny && ny < R && 0 <= nx && nx < C && arr[ny][nx] != '#') {
					if(fire[ny][nx] > fire[cur.y][cur.x] + 1) {
						fire[ny][nx] = fire[cur.y][cur.x] + 1;
						fireQue.add(new Fire(ny, nx));
					}
				}
			}
		}
	}
	
	// Ż�� ��� Ž��
	public static void escape() {
		while(! que.isEmpty()) {
			Node cur = que.poll();
			
			// �����ڸ��� �����ϸ� Ż��
			if(cur.y == 0 || cur.y == R - 1 || cur.x == 0 || cur.x == C - 1) {
				result = cur.t;
				flag = true;
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if(0 <= ny && ny < R && 0 <= nx && nx < C && arr[ny][nx] == '.') {
					// �湮���� ���� �����̰� ���� ��ġ�� �Ѿ �� �̹� ���� �� ������ �ƴϾ�� �̵� ����
					if(! visit[ny][nx] && fire[ny][nx] > cur.t + 1) {
						visit[ny][nx] = true;
						que.add(new Node(ny, nx, cur.t + 1));
					}
				}
			}
		}
	}

}
