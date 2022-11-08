package ps15558;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/15558
 * 점프 게임
 * */

class Point {
	int line; // 1 == left && 2 == right
	int pos;
	int time;
	
	public Point(int line, int pos, int time) {
		this.line = line;
		this.pos = pos;
		this.time = time;
	}
}

public class Main {

	static int n;
	static int k;
	static Queue<Point> que;
	
	static boolean[] leftVisit;
	static boolean[] rightVisit;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		String left = br.readLine();
		String right = br.readLine();
		
		int result = 0;
		leftVisit = new boolean[n];
		rightVisit = new boolean[n];
		que = new LinkedList<Point>();
		que.add(new Point(1, 0, 0));
		leftVisit[0] = true;
		
		while(! que.isEmpty()) {
			Point p = que.poll();
			
			if(p.pos >= n) {
				result = 1;
				break;
			}
			
			if(p.time > 0 && p.pos - 1 > p.time) {
				if(p.line == 1 && left.charAt(p.pos - 1) != '0' && ! leftVisit[p.pos - 1]) {
					leftVisit[p.pos - 1] = true;
					que.add(new Point(p.line, p.pos - 1, p.time + 1));
				}
				else if(p.line == 2 && right.charAt(p.pos - 1) != '0' && ! rightVisit[p.pos - 1]) {
					rightVisit[p.pos - 1] = true;
					que.add(new Point(p.line, p.pos - 1, p.time + 1));
				}
			}
			
			if(p.line == 1) {
				if(p.pos + 1 < n && left.charAt(p.pos + 1) != '0' && ! leftVisit[p.pos + 1]) {
					leftVisit[p.pos + 1] = true;
					que.add(new Point(p.line, p.pos + 1, p.time + 1));
				}
				if(p.pos + k < n && right.charAt(p.pos + k) != '0' && ! rightVisit[p.pos + k]) {
					rightVisit[p.pos + k] = true;
					que.add(new Point(2, p.pos + k, p.time + 1));
				}
				
				if(p.pos + 1 >= n) {
					result = 1;
					break;
				}
				
				if(p.pos + k >= n) {
					result = 1;
					break;
				}
			}
			
			if(p.line == 2) {
				if(p.pos + 1 < n && right.charAt(p.pos + 1) != '0' && ! rightVisit[p.pos + 1]) {
					rightVisit[p.pos + 1] = true;
					que.add(new Point(p.line, p.pos + 1, p.time + 1));
				}
				if(p.pos + k < n && left.charAt(p.pos + k) != '0' && ! leftVisit[p.pos + k]) {
					leftVisit[p.pos + k] = true;
					que.add(new Point(2, p.pos + k, p.time + 1));
				}
				
				if(p.pos + 1 >= n) {
					result = 1;
					break;
				}
				
				if(p.pos + k >= n) {
					result = 1;
					break;
				}
			}
		}
		
		System.out.println(result);
	}

}
