package ps2170;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2170
 * 선 긋기
 * */
class Node {
	int start;
	int end;
	
	public Node(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class Main {
	static int N;
	static ArrayList<Node> list;
	static Comparator<Node> comp = new Comparator<Node>() {
		@Override
		public int compare(Node n1, Node n2) {
			return n1.start - n2.start;
		}
	};
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<Node>();
		
		StringTokenizer st = null;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.add(new Node(x, y));
		}
		
		Collections.sort(list, comp);
		
		int curS = list.get(0).start;
		int curE = list.get(0).end;
		
		for(int i = 1; i < N; i++) {
			Node node = list.get(i);
			
			// 탐색중인 노드의 출발점이 현재 저장중인 도착점보다 작다면 => 한번에 이어지는 선분이란 뜻 
			if(node.start <= curE) {
				// 탐색중인 노드의 도착점이 현재 저장중인 도착점보다 크면 도착점 갱신 
				if(node.end > curE) {
					curE = node.end;
				}
			}
			// 탐색중인 노드의 출발점이 현재 저장중인 도착점보다 크다면 => 한번에 이어지는 선분이 아니라는 뜻 
			else {
				// 이전까지 이어진 선분의 길이를 더해주고 
				result += (curE - curS);
				// 현재 탐색중인 노드부터 새로 시작하기 위해 시작점, 도착점 저장 
				curS = node.start;
				curE = node.end;
			}
		}
		
		// 모든 탐색을 마치고나서 마지막으로 저장해놓은 시작점과 도착점의 경우 길이를 못구했으므로 한번 더 계산 
		result += (curE - curS);
		
		System.out.println(result);
	}

}
