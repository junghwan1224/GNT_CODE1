package ps20955;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/20955
 * 민서의 응급 수술
 * */
public class Main {
	static int N;
	static int M;
	static int[] parent;
	static int cycle;
	static int answer;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		
		for(int i = 1; i <= N; i++)
			parent[i] = i;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			if(find(u) != find(v))
				union(u, v);
			// 합치기 전인데 부모가 같다면 싸이클이 존재한다는 뜻이므로 싸이클 갯수 증가 
			else
				cycle++;
		}
		
		for(int i = 1; i <= N; i++) {
			// 루트 노드의 수 구하기, 루트 노드의 수 == 연결된 그룹의 수
			if(find(i) == i)
				answer++;
		}
		
		// answer - 1 => 연결하기 위해 필요한 수 == 연결된 그룹의 수 - 1
		System.out.println(answer - 1 + cycle);
	}

	public static int find(int x) {
		if (x==parent[x]){
		    return x;
		  }
		else{
		    int y = find(parent[x]);
		    parent[x] = y;
		    return y;
		}
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x > y)
			parent[x] = y;
		else
			parent[y] = x;
	}
}
