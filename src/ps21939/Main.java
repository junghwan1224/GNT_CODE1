package ps21939;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/21939
 * 문제 추천 시스템 Version 1
 * ref: https://emoney96.tistory.com/319
 * */
class Test implements Comparable<Test> {
	int p;
	int l;
	
	public Test(int p, int l) {
		this.p = p;
		this.l = l;
	}
	
	@Override
	public int compareTo(Test t) {
//		if(this.l > t.l) {
//			return -1;
//		}
//		else if(this.l == t.l) {
//			if(this.p > t.p)
//				return 1;
//		}
//		else
//			return 1;
//		return 1;
		
		if (this.l == t.l) {
            return Integer.compare(this.p ,t.p);
        }
        return Integer.compare(this.l, t.l);
	}
}

class MinTest implements Comparable<MinTest> {
	int p;
	int l;
	
	public MinTest(int p, int l) {
		this.p = p;
		this.l = l;
	}
	
	@Override
	public int compareTo(MinTest t) {
//		if(this.l > t.l) {
//			return 1;
//		}
//		else if(this.l == t.l) {
//			if(this.p > t.p)
//				return 1;
//		}
//		else
//			return -1;
//		return 1;
		
		if (this.l == t.l) {
            return Integer.compare(this.p ,t.p);
        }
        return Integer.compare(this.l, t.l);
	}
}

public class Main {
	static int N;
	static int M;
	static StringBuffer sb;
	static PriorityQueue<Test> maxQue;
	static PriorityQueue<MinTest> minQue;
	static int MAX = 100001;
	static int[] list;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sb = new StringBuffer();
		list = new int[MAX]; // 문제의 번호가 추천 문제 리스트에 있는지 확인하는 배열
		maxQue = new PriorityQueue<Test>(Collections.reverseOrder());
		minQue = new PriorityQueue<MinTest>();
		
		StringTokenizer st = null;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			maxQue.add(new Test(p, l));
			minQue.add(new MinTest(p, l));
			list[p] = l;
		}
		
		M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int p = -1;
			int l = -1;
			
			if(cmd.equals("add")) {
				p = Integer.parseInt(st.nextToken());
				l = Integer.parseInt(st.nextToken());
				
				maxQue.add(new Test(p, l));
				minQue.add(new MinTest(p, l));
				list[p] = l;
			}
			else if(cmd.equals("recommend")) {
				p = Integer.parseInt(st.nextToken());
				
				int result = 0;
				if(p == 1) {
					while(! maxQue.isEmpty()) {
						Test cur = maxQue.peek();
						if(list[cur.p] == cur.l) {
							result = cur.p;
							break;
						}
						else
							maxQue.poll();
					}
				}
				else {
					while(! minQue.isEmpty()) {
						MinTest cur = minQue.peek();
						if(list[cur.p] == cur.l) {
							result = cur.p;
							break;
						}
						else
							minQue.poll();
					}
				}
				sb.append(result).append("\n");
			}
			else { // cmd == solved
				p = Integer.parseInt(st.nextToken());
				list[p] = 0; // 해당 번호의 문제를 제거해야 하므로 false로 변경 
			}
		}
		
//		while(! maxQue.isEmpty()) {
//			Test t = maxQue.poll();
//			System.out.println(t.p + ", " + t.l);
//		}
//		
//		System.out.println();
//		
//		while(! minQue.isEmpty()) {
//			MinTest t = minQue.poll();
//			System.out.println(t.p + ", " + t.l);
//		}
		
		System.out.println(sb);
	}

}
