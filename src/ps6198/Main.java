package ps6198;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * https://www.acmicpc.net/problem/6198
 * 옥상 정원 꾸미기
 * */
public class Main {
	static int N;
	static int[] arr;
	static int[] result;
	static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		result = new int[N];
		stack = new Stack<Integer>();
		long sum = 0;
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < N; i++) {
			// 현재 기준이 되는 건물(arr[i])을 바라볼 수 있는 건물들의 수를 계산한다. 
			/*
			 * ex)
			 * 10 3 7 4 12 2
			 *  0 1 1 2  0 1
			 *  
			 *  스택에 들어있는 건물의 높이보다 현재 탐색중인 건물(arr[i])의 높이가 더 크거나 같으면,
			 *  바라볼 수 없는 건물이므로 스택에서 뺀다. 
			 * */
			while(! stack.isEmpty() && stack.peek() <= arr[i]) {
				stack.pop();
			}
			
			// 스택에 남아있는 건물 수가 현재 탐색중인 건물을 바라볼 수 있는 건물의 수 
			sum += stack.size();
			
			// 탐색이 끝났으면 본인도 스택에 추가 
			stack.push(arr[i]);
		}
		
		System.out.println(sum);
	}

}
