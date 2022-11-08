package ps13913;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/13913
 * 숨바꼭질 4
 * */
class Node {
	int pos;
	int time;
	ArrayList<String> trace; // 이동 경로 
	
	public Node(int pos, int time, ArrayList<String> trace) {
		this.pos = pos;
		this.time = time;
		this.trace = trace;
	}
}

class Node2 {
	int pos; // 현재 위치 
	int time; // 현재 위치까지 도달하는데 걸린 시간 
	
	public Node2(int pos, int time) {
		this.pos = pos;
		this.time = time;
	}
}
public class Main {
	static int n;
	static int k;
	static Queue<Node> que;
	static boolean[] visit;
	static int MAX = 100000;
	
	static Queue<Node2> q;
	// 주인공이 이동한 경로 
	static ArrayList<String> path;
	// 방문 여부 및 경로 저장 
	// visited[다음 위치] = 현재 위치 
	static int[] visited;
	static int time;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
//		que = new LinkedList<Node>();
//		visit = new boolean[MAX + 1];
		
		q = new LinkedList<Node2>();
		visited = new int[MAX + 1];
		
		for(int i = 0; i <= MAX; i++)
			visited[i] = -1; // 0번째 인덱스도 이동 가능한 위치이기에 -1로 초기화 
		
		path = new ArrayList<String>();
		q.add(new Node2(n, 0));
		
//		ArrayList<String> initList = new ArrayList<String>();
//		initList.add(Integer.toString(n));
//		visit[n] = true;
//		que.add(new Node(n, 0, initList));
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(! q.isEmpty()) {
			Node2 cur = q.poll();
			
			// 현재 위치가 동생의 위치와 같으면 루프 종료 
			if(cur.pos == k) {
				time = cur.time;
				break;
			}
			
			if(cur.pos - 1 >= 0 && visited[cur.pos - 1] == - 1) {
				visited[cur.pos - 1] = cur.pos;
				q.add(new Node2(cur.pos - 1, cur.time + 1));
			}
			
			if(cur.pos + 1 <= MAX && visited[cur.pos + 1] == - 1) {
				visited[cur.pos + 1] = cur.pos;
				q.add(new Node2(cur.pos + 1, cur.time + 1));
			}
			
			if(cur.pos * 2 <= MAX && visited[cur.pos * 2] == - 1) {
				visited[cur.pos * 2] = cur.pos;
				q.add(new Node2(cur.pos * 2, cur.time + 1));
			}
		}
		
		bw.append(Integer.toString(time) + "\n");
		
		int start = k;
		path.add(Integer.toString(start));
		while(visited[start] != -1 && start != n) {
			path.add(Integer.toString(visited[start]));
			start = visited[start];
		}
		// 경로가 역순으로 저장되어 있으므로, reverse메서드로 정렬 순서 조정 
		Collections.reverse(path);
		for(String p: path)
			bw.append(p + " ");
		
		bw.flush();
		
//		while(! que.isEmpty()) {
//			Node cur = que.poll();
//			
//			if(cur.pos == k) {
//				bw.append(cur.time + "\n");
//				for(String c: cur.trace)
//					bw.append(c + " ");
//				bw.flush();
//				break;
//			}
//			
//			if(cur.pos - 1 >= 0 && ! visit[cur.pos - 1]) {
//				ArrayList<String> l1 = (ArrayList<String>) cur.trace.clone();
//				l1.add(Integer.toString((cur.pos - 1)));				
//				que.add(new Node(cur.pos - 1, cur.time + 1, l1));
//				visit[cur.pos - 1] = true;
//			}
//			
//			if(cur.pos + 1 <= MAX && ! visit[cur.pos + 1]) {
//				ArrayList<String> l2 = (ArrayList<String>) cur.trace.clone();
//				l2.add(Integer.toString((cur.pos + 1)));
//				que.add(new Node(cur.pos + 1, cur.time + 1, l2));
//				visit[cur.pos + 1] = true;
//			}
//			
//			if(cur.pos * 2 <= MAX && ! visit[cur.pos * 2]) {
//				ArrayList<String> l3 = (ArrayList<String>) cur.trace.clone();
//				l3.add(Integer.toString((cur.pos * 2)));
//				que.add(new Node(cur.pos * 2, cur.time + 1, l3));
//				visit[cur.pos * 2] = true;
//			}
//		}
		
		bw.close();
		br.close();
	}

}
