package no2304;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2304
 * 창고 다각형
 * */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		int[] arr = new int[1001]; // 인덱스: x 좌표, 값: 기둥의 높이.
		int longest = 0; // 가장 높은 기둥의 x 좌표.
		int start = 1001; // 기둥이 있는 가장 낮은 x 좌표.
		int end = 0; // 기둥이 있는 가장 마지막 x좌표.
		int area = 0; // 결과
		Stack<Integer> stack = new Stack<Integer>(); // 기둥 높이 값을 담을 스택.
		
		try {
			n = Integer.parseInt(br.readLine());
			int k = 0;
			while(k < n) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				arr[x] = y;
				if(start > x) start = x; // 시작점 좌표 구하기.
				if(end < x) end = x; // 끝점 좌표 구하기.
				if(y > arr[longest]) longest = x; // 가장 높은 기둥의 좌표 구하기.
				k++;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		// 시작점부터 가장 높은 기둥의 좌표까지.
		for(int i = start; i <= longest; i++) {
			// 기둥이 있을 경우.
			if(arr[i] > 0) {
				// 스택이 비어있으면 기둥 높이값 추가.
				if(stack.isEmpty())
					stack.push(arr[i]);
				else {
					// 현재 기둥의 높이가 스택 최상단에 위치한 기둥 높이보다 클 경우.
					if(arr[i] > stack.peek())
						// 스택에 새로 추가.
						stack.push(arr[i]);
				}
			}
			// 스택 최상단 값을 더해준다.
			area += stack.peek();
		}
		
		// 끝점부터 작업을 다시 해야하기 때문에 스택 비우기.
		while(! stack.isEmpty()) stack.pop();
		
		// 끝점부터 가장 높은 기둥의 좌표까지.
		for(int i = end; i > longest; i--) {
			// 기둥이 있을 경우.
			if(arr[i] > 0) {
				// 스택이 비어있으면 기둥 추가.
				if(stack.isEmpty())
					stack.push(arr[i]);
				else {
					// 현재 기둥의 높이가 스택 최상단에 위치한 기둥 높이보다 클 경우.
					if(arr[i] > stack.peek())
						// 스택에 새로 추가.
						stack.push(arr[i]);
				}
			}
			// 스택 최상단 값을 더해준다.
			area += stack.peek();
		}
		
		System.out.println(area);
	}

}
