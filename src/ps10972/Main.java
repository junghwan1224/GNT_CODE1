package ps10972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/10972
 * 다음 순열
 * */
public class Main {
	static int n;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int idx = n - 1;
		// 내림차순이 꺾이는 지점을 찾는다 
		while(idx > 0) {
			if(arr[idx - 1] < arr[idx])
				break;
			idx -= 1;
		}
		
		if(idx <= 0)
			System.out.println("-1");
		else {
			System.out.println(idx);
			idx -= 1;
			
			// 내림차순이 되어야 하는 부분에서의 두 번째 최댓값과 인덱스 추출 
			int maxIdx = 0;
			int maxVal = 987654321;
			for(int i = idx + 1; i < n; i++) {
				if(arr[idx] < arr[i]) {
					if(maxVal > arr[i]) {
						maxIdx = i;
						maxVal = arr[i];
					}
				}
			}
			System.out.println(maxIdx + ", " + maxVal);
			
			// 내림차순이 꺾이는 위치의 값과 내림차순이 유지된 곳 까지 중의 최댓값의 위치를 바꿔준다. 
			swap(idx, maxIdx);
			
			for(int i = 0; i < n; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
			
			// 내림차순이 유지되고 있던 곳을 다시 오름차순으로 정렬 
			for(int i = idx + 1; i < n; i++) {
				for(int j = i + 1; j < n; j++) {
					if(arr[i] > arr[j]) {
						int tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;
					}
				}
			}

			/*
7
4 6 5 7 3 2 1

6
6 1 5 4 3 2
			*/
			
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < n; i++)
				sb.append(arr[i]).append(" ");
			System.out.println(sb);
		}
	}

	public static void swap(int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
