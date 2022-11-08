package ps20922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/20922
 * 겹치는 건 싫어
 * */
public class Main {
	static int N;
	static int K;
	static int[] A;
	static Map<Integer, Integer> map;
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		A = new int[N];
		map = new HashMap<Integer, Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			map.put(A[i], 0);
		}
		
		int start = 0;
		int end = 0;
		boolean flag = true; // 시작점이 움직였는지, 끝점이 움직였는지 판단하는 변수, true면 끝점이 움직였다는 뜻 
		
		while(start <= end && end < N) {
			// 끝점이 한칸 오른쪽으로 이동했으면, 끝점의 갯수를 1 더해준다 
			if(flag)
				map.put(A[end], map.getOrDefault(A[end], 0) + 1);
			
			// 끝점에 해당하는 정수의 갯수가 K개 이하인 경우, 길이의 최댓값 갱신 
			if(map.get(A[end]) <= K) {
				result = Math.max(result, end - start + 1);			
			}
			
			// 끝점에 해당하는 정수의 갯수가 K보다 크면, 시작점을 움직인다 
			if(map.get(A[end]) > K) {
				// 시작점에 해당하는 정수의 갯수 
				int startCnt =  map.getOrDefault(A[start], 0);
				// 시작점을 오른쪽으로 옮기므로 원래 시작점에 있던 정수의 갯수는 하나 빼준다 
				map.put(A[start], startCnt == 0 ? 0 : startCnt - 1);
				// 시작점을 움직였으므로 flag는 false로 바꾸어 끝점의 갯수가 1 더해지지 않게 막는다 
				flag = false;
				// 시작점 이동 
				start++;
				
			}
			else if(map.get(A[end]) <= K) {
				flag = true;
				end++;				
			}
			
		}
		
		System.out.println(result);
	}

}
