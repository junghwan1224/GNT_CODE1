package ps19637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/19637
 * */
class Node {
	int point;
	String title;
	
	public Node(int point, String title) {
		this.point = point;
		this.title = title;
	}
}

public class Main {
	static int N, M;
	static Node[] arr;
	static String[] titles;
	static StringBuffer sb;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new Node[N + 1];
		titles = new String[M];
		sb = new StringBuffer();

		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			String t = st.nextToken();
			int p = Integer.parseInt(st.nextToken());

			arr[i] = new Node(p, t);
		}
		arr[0] = new Node(0, arr[1].title);
		
		for(int i = 0; i < M; i++) {
			int n = Integer.parseInt(br.readLine());

			int left = 0;
			int right = N;
			int idx = 0;

			while(left <= right) {
				int mid = (left + right) / 2;

				if(n <= arr[mid].point) {
					idx = mid;
					right = mid - 1;
				}
				else {
					left = mid + 1;
				}
			}

			titles[i] = arr[idx].title;
			sb.append(titles[i]).append("\n");
		}

		System.out.println(sb);
	}

}

