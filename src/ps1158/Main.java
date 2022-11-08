package ps1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1158
 * 요세푸스 문제
 * */
public class Main {
	static int N;
	static int K;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q1 = new LinkedList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for(int i = 1; i <= N; i++)
			q1.add(i);
		
		while(! q1.isEmpty()) {
			int tmp = 1;
			while(tmp < K) {
				q1.add(q1.poll());
				tmp++;
			}
			
			if(! q1.isEmpty())
				result.add(q1.poll());
		}
		
		String ans = "<";
		for(Integer i: result) {
			ans += i.toString() + ", ";
		}
		ans = ans.substring(0, ans.length() - 2);
		ans += ">";
		System.out.println(ans);
	}

}
