package ps1991;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1991
 * 트리 순회
 * */
public class Main {
	static int n;
	static BufferedWriter bw;
	// Key: 노드의 값
	// Value: 0 index => 왼쪽 자식 노드  1 index => 오른쪽 자식 노드 
	static Map<String, ArrayList<String>> tree;
	
	static ArrayList<String> preorderResult; // 전위순회 결과 리스트 
	static ArrayList<String> inorderResult; // 중위순회 결과 리스트 
	static ArrayList<String> postorderResult; // 후위순회 결과 리스트 

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		tree = new HashMap<String, ArrayList<String>>();
		
		preorderResult = new ArrayList<String>();
		inorderResult = new ArrayList<String>();
		postorderResult = new ArrayList<String>();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String root = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			
			ArrayList<String> child = new ArrayList<String>();
			child.add(left);
			child.add(right);
			tree.put(root, child);
		}
		
		preorderTraversal("A");
		inorderTraversal("A");
		postorderTraversal("A");
		
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.append(String.join("", preorderResult) + "\n");
		bw.append(String.join("", inorderResult) + "\n");
		bw.append(String.join("", postorderResult));
		
		bw.flush();
		bw.close();
		br.close();
	}

	// 전위 순회 
	public static void preorderTraversal(String node) {
		preorderResult.add(node);
		if(! tree.get(node).get(0).equals("."))
			preorderTraversal(tree.get(node).get(0));
		
		if(! tree.get(node).get(1).equals("."))
			preorderTraversal(tree.get(node).get(1));
	}
	
	// 중위 순회 
	public static void inorderTraversal(String node) {
		if(! tree.get(node).get(0).equals("."))
			inorderTraversal(tree.get(node).get(0));
		
		inorderResult.add(node);
		
		if(! tree.get(node).get(1).equals("."))
			inorderTraversal(tree.get(node).get(1));
	}
	
	// 후위 순회 
	public static void postorderTraversal(String node) {
		if(! tree.get(node).get(0).equals("."))
			postorderTraversal(tree.get(node).get(0));
		
		if(! tree.get(node).get(1).equals("."))
			postorderTraversal(tree.get(node).get(1));
		
		postorderResult.add(node);
	}
}
