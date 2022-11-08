package ps14658;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/14658
 * 하늘에서 별똥별이 빗발친다
 * https://velog.io/@dot2__/BOJ-14658%EB%B2%88-%ED%95%98%EB%8A%98%EC%97%90%EC%84%9C-%EB%B3%84%EB%98%A5%EB%B3%84%EC%9D%B4-%EB%B9%97%EB%B0%9C%EC%B9%9C%EB%8B%A4-Java
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
	static int N, M, L, K;
	static ArrayList<Node> list;
	static int cnt;
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<Node>();
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.add(new Node(y, x));
		}
		
		// 모서리에 별똥별을 배치되게끔 트램펄린 설치 
		for(Node n1: list) {
			for(Node n2: list) {
				cnt = 0;
				
				for(Node n3: list) {
					if(n1.x <= n3.x && n3.x <= n1.x + L && n2.y <= n3.y && n3.y <= n2.y + L)
						cnt++;
				}
				
				result = Math.max(result, cnt);
			}
		}
		
		System.out.println(K - result);
	}

}
