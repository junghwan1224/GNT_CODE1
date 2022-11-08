package ps7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/7576
 * 토마토
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
	static int[][] arr;
	static Queue<Node> que;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		que = new LinkedList<Node>();
		for(int i = 0; i < N; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 1) {
					que.add(new Node(i, j));
				}
			}
		}
		
		while(! que.isEmpty()) {
			Node cur = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if(0 <= ny && ny < N && 0 <= nx && nx < M) {
					if(arr[ny][nx] == 0) {
						que.add(new Node(ny, nx));
						arr[ny][nx] = arr[cur.y][cur.x] + 1; 
					}
				}
			}
		}
		
		result = -1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 0) {
					System.out.println(- 1);
					return;
				}
				else if(arr[i][j] > 0)
					result = Math.max(result, arr[i][j]);
			}
		}
		
		System.out.println(result - 1);
	}

}
