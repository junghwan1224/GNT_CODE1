package ps16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/16953
 * A → B
 * */
class Node {
	int n; // 현재 수. 
	int cnt; // 현재까지의 연산 횟수.
	
	public Node(int n, int cnt) {
		this.n = n;
		this.cnt = cnt;
	}
}

public class Main {
	static int a;
	static int b;
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		// bfs();
		
		while(true) {
			// b가 a보다 작아지면 반복문 종료.
			if(a > b) {
				System.out.println(-1);
				break;
			}
			
			// a와 b가 일치하면, 연산횟수 출력.
			if(a == b) {
				System.out.println(result + 1);
				break;
			}
			
			// b의 일의 자리가 1인 경우, 1 제거.
			if(b % 10 == 1) {
				b /= 10;
			}
			
			// b가 짝수인 경우 2로 나눠줌.
			else if(b % 2 == 0) {
				b /= 2;
			}
			//  그 외의 경우는 성립할 수 없으므로 반복문 종료.
			// ex) a = 1, b = 3
			//    일때, else 조건 없을 경우 무한루프에 빠져 시간초과.
			else {
				System.out.println(-1);
				break;
			}
			
			result++;
		}
	}
	
	/*
	 * BFS => 메모리 초과.
	 * */
	public static void bfs() {
		// 홀수이고 일의 자리가 1이 아닌 경우는 결과가 도출될 수 없으므로 -1 출력.
		if(b % 2 == 1 && b % 10 != 1) {
			System.out.println(-1);
			return;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		
		Node node = new Node(a, 1);
		q.add(node);
		while(! q.isEmpty()) {
			Node cur = q.poll();
			int curNum = cur.n; // 현재 값.
			int curCnt = cur.cnt; // 현재 연산 횟수.
			
			// 다음 연산.
			int nextNum1 = curNum * 2; // 현재 값에 곱하기 2
			int nextNum2 = curNum * 10 + 1; // 끝에 1 붙이기.
			
			// 두가지 연산을 했을 때, 둘중에 하나라도 결과가 나왔을 경우 1 더하고 함수 종료.
			if(nextNum1 == b || nextNum2 == b) {
				System.out.println(curCnt + 1);
				return;
			}
			
			// 다음 연산 값들이 목표값(B)보다 낮을 경우 큐에 해당 값 및 횟수 1 더하여 추가.
			if(nextNum1 < b)
				q.add(new Node(nextNum1, curCnt + 1));
			
			if(nextNum2 < b)
				q.add(new Node(nextNum2, curCnt + 1));
		}
		
		// 큐에 있는 값들이 소진될 때까지 순회하여도 함수가 종료되지 않으면, a에서 b로 만들 수 없다는 뜻이므로 -1 출력 후 함수 종료.
		System.out.println(-1);
		return;
	}

}
