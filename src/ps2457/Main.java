package ps2457;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2457
 * 공주님의 정원
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
	static int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	static int[] arr;
	static Node[] list;
	static int result;
	static Comparator<Node> comp = new Comparator<Node>() {
		@Override
		public int compare(Node a, Node b) {
			if(a.start < b.start)
				return -1;
			else if(a.start == b.start) {
				if(a.end < b.end) {
					return -1;
				}
				else if(a.end == b.end) {
					return 0;
				}
				else
					return 1;
			}
			return 1;
		}
	};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[366];
		list = new Node[N];
		int left = 60; // 3.1
		int right = 335; // 12. 01
		
		StringTokenizer st = null;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int startMM = Integer.parseInt(st.nextToken());
			int startDD = Integer.parseInt(st.nextToken());
			int endMM = Integer.parseInt(st.nextToken());
			int endDD = Integer.parseInt(st.nextToken());
			
			int startAcc = 0;
			int endAcc = 0;
			
			for(int k = 1; k < startMM; k++)
				startAcc += month[k];
			
			for(int k = 1; k < endMM; k++)
				endAcc += month[k];
			
			list[i] = new Node(startAcc + startDD, endAcc + endDD);
		}
		
		Arrays.sort(list, comp);
		
		
		int today = 60; // 꽃을 탐색할지 판단하는 기준이 되는 일자, 시작은 60(03. 01)
		int endDay = 0; // 꽃이 지는 날짜 중, 제일 늦은 날짜를 저장하는 변수 
		int idx = 0; // 다음 꽃을 탐색할 시작 인덱스 
				
		// 기준일자가 335(12. 01)보다 작을때까지 반복문 순회 
		while(today < 335) {
			
			// 심을 수 있는 꽃이 있는지 확인 
			for(int i = idx; i < N; i++) {
				// 시작일이 기준일자보다 크면 중간에 꽃이 없는 기간이 있다는 뜻이므로 더 조사할 필요가 없다. 반복문 종료.
				if(list[i].start > today)
					break;
				
				// 현재 저장중인 꽃이 지는 제일 늦은 날짜보다 현재 탐색중인 꽃의 지는 날짜가 더 늦을 경우 
				if(list[i].end > endDay) {
					// 날짜 갱신 
					endDay = list[i].end;
					// 탐색 기준이 되는 인덱스 갱신 
					idx = i;
				}
			}
			
			// 기준일자와 꽃이 지는 일자의 값이 같다는 것은 탐색 중, 위 루프를 돌지 않았다는 뜻.
			// 즉, 3월 1일부터 11월 30일 사이에 꽃이 항상 피어있어야 한다는 조건이 성립하지 않는다는 뜻이므로 결괏값을 0으로 초기화 하고 반복문 종료 
			if(today == endDay) {
				result = 0;
				break;
			}
			// 탐색이 더 가능하면 기준일자를 꽃이 지는 일자로 갱신 
			else {
				today = endDay;
				result++;
			}
		}
		
		System.out.println(result);
	}
}
