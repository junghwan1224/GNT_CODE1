package ps20920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/20920
 * 영단어 암기는 괴로워
 * */
class Node implements Comparable<Node> {
	String word;
	int cnt;
	
	public Node(String word, int cnt) {
		this.word = word;
		this.cnt = cnt;
	}
	
	@Override
	public int compareTo(Node a) {
		// 단어 갯수 많은 순서대로 내림차순 정렬
		if(this.cnt == a.cnt) {			
			if(this.word.length() == a.word.length()) {				
				return this.word.compareTo(a.word);
			}
			return a.word.length() - this.word.length();
		}
		return a.cnt - this.cnt;
	}
}

public class Main {
	static int n;
	static int m;
	static StringBuffer sb;
	static Map<String, Integer> map;
	static ArrayList<Node> list;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new HashMap<String, Integer>();
		list = new ArrayList<Node>();
		sb = new StringBuffer();
		
		for(int i = 0; i < n; i++) {
			String word = br.readLine();
			
			if(word.length() < m)
				continue;
			
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		
		for(String key: map.keySet()) {
			list.add(new Node(key, map.get(key)));
		}
		
		Collections.sort(list);
		
		for(Node node: list) {
			//System.out.println("key: " + node.word + "  cnt: " + node.cnt);
			sb.append(node.word).append("\n");
		}
		
		System.out.println(sb);
	}

}
