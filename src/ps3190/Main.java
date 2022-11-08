package ps3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/3190
 * 뱀
 * */
class Node {
	int y;
	int x;
	
	public Node(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

class MoveNode {
	int t;
	String d;
	
	public MoveNode(int t, String d) {
		this.t = t;
		this.d = d;
	}
}

public class Main {
	static int N;
	static int K;
	static int L;
	static int[][] map;
	static int[] dy = {1, -1, 0 ,0};
	static int[] dx = {0, 0, 1, -1};
	static int dirIdx;
	static Deque<Node> deq;
	static Queue<MoveNode> mque;
	static int time;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		deq = new LinkedList<Node>();
		map[0][0] = 2; // 뱀은 2로 표시 
		deq.add(new Node(0, 0));
		dirIdx = 2; // 처음에는 오른쪽 방향을 보고 있으므로 dy, dx 초기화 값 기준 오른쪽 방향으로 설정 
		
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		if(K > 0) {
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				map[a - 1][b - 1] = 1; // 사과는 1로 표시 
			}
		}
		
		L = Integer.parseInt(br.readLine());
		mque = new LinkedList<MoveNode>();
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int moveCnt = Integer.parseInt(st.nextToken());
			String moveDir = st.nextToken();
			mque.add(new MoveNode(moveCnt, moveDir));
		}
		
		while(true) {
			
			if(deq.isEmpty())
				break;
			
			Node cur = deq.peekFirst();
			
			int ny = cur.y + dy[dirIdx];
			int nx = cur.x + dx[dirIdx];
			
			time++;
			
			// 범위 벗어나면 종료 
			if(! (0 <= ny && ny < N && 0 <= nx && nx < N))
				break;
			
			// 자기 몸하고 만나면 종료 
			if(map[ny][nx] == 2)
				break;
			// 다음 위치에 사과가 있을 경우 
			else if(map[ny][nx] == 1) {
				map[ny][nx] = 2;
				deq.addFirst(new Node(ny, nx));
			}
			// 빈 공간일 경우 
			else if(map[ny][nx] == 0) {
				// 다음 위치를 머리로 
				map[ny][nx] = 2;
				// 꼬리 위치는 빈공간으로 
				Node tail = deq.pollLast();
				map[tail.y][tail.x] = 0;
				deq.addFirst(new Node(ny, nx));
			}
			
			if(! mque.isEmpty()) {
				MoveNode mn = mque.peek();
				if(time == mn.t) {
					mn = mque.poll();
					dirIdx = turn(dirIdx, mn.d);
				}
			}
		}
		
		System.out.println(time);
	}

	public static int turn(int dir, String s) {
		if(s.equals("L")) {
			if(dir == 0)
				return 2;
			else if(dir == 1)
				return 3;
			else if(dir == 2)
				return 1;
			else
				return 0;
		}
		else { // s == "D"
			if(dir == 0)
				return 3;
			else if(dir == 1)
				return 2;
			else if(dir == 2)
				return 0;
			else
				return 1;
		}
	}
}
