package ps2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2805
 * 나무 자르기
 * 소요시간: 1시간 20분.
 * */
public class Main {
	static int n;
	static long m;
	static long maxH; // 입력받은 값 중 최대 높이값.
	static long result;
	static long[] tree;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Long.parseLong(st.nextToken());
		
		tree = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++ ) {
			tree[i] = Long.parseLong(st.nextToken());
			maxH = Math.max(maxH, tree[i]); // 최댓값 추출.
		}
		
		long left = 0;
		long right = maxH;
		
		// 투 포인터.
		while(left <= right) {
			// 0과 최댓값의 중간 값을 기준으로 탐색 시작.
			long mid = (left + right) / 2;
			long diff = 0;
			
			for(int i = 0; i < n; i++) {
				// 기준값보다 높이가 낮은 나무면 계산에서 제외.
				diff += (tree[i] - mid < 0 ? 0 : tree[i] - mid);
			}
			
			// 도출된 값이 구하고자 하는 높이보다 더 크면 자르는 높이를 높여서 도달할 수 있는 최댓값 도출.
			if(diff >= m) {
				result = mid;
				left = mid + 1;
			}
			
			// 도출된 값이 구하고자 하는 높이보다 낮으면 자르는 높이를 낮춰서 도달할 수 있는 최댓값 도출.
			else {
				right = mid - 1;
			}
		}
		
		System.out.println(result);
	}

}
