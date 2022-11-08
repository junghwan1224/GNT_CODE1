package ps4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * https://www.acmicpc.net/problem/4485
 * 녹색 옷 입은 애가 젤다지? 
 * */
class Node {
	int y;
	int x;
	int cost;
	
	public Node(int y, int x, int cost) {
		this.y = y;
		this.x = x;
		this.cost = cost;
	}
}

public class Main {
	static int N;
	static int[][] arr;
	static int[][] rupee;
	static Queue<Node> que;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static StringBuffer sb;
	static int MAX = 987654321;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		sb = new StringBuffer();
		
		int idx = 1;
		while(N != 0) {
			arr = new int[N][N];
			rupee = new int[N][N];
			for(int i = 0; i < N; i++)
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			for(int i = 0; i < N; i++)
				Arrays.fill(rupee[i], MAX);
			
			bfs();
			
			sb.append("Problem ").append(idx++).append(": ").append(rupee[N - 1][N - 1]).append("\n");
			
			N = Integer.parseInt(br.readLine());
		}
		
		System.out.println(sb);
	}

	public static void bfs() {
		que = new LinkedList<Node>();
		
		que.add(new Node(0, 0, arr[0][0]));
		rupee[0][0] = arr[0][0];
		
		while(! que.isEmpty()) {
			Node cur = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if(0 <= ny && ny < N && 0 <= nx && nx < N) {
					int curCost = rupee[cur.y][cur.x] + arr[ny][nx];
					if(rupee[ny][nx] > curCost) {
						rupee[ny][nx] = curCost;
						que.add(new Node(ny, nx, curCost));
					}
				}
			}
		}
	}
}
