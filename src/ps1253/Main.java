package ps1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/*
 * https://www.acmicpc.net/problem/1253
 * 좋다
 * */
public class Main {
	static int N;

	public static int n, cnt;
	public static long[] arr;
	public static HashMap<Long, Boolean> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		
		Arrays.sort(arr);
		
		for(int i = 0; i < n; i++) {
			int left = 0;
			int right = n - 1;
			
			while(left < right) {
				long sum = arr[left] + arr[right];
				
				if(sum == arr[i]) {
					if(left != i && right != i) {
						cnt++;
						break;
					}
					else if(left == i)
						left++;
					else if(right == i)
						right--;
				}
				
				else if(sum > arr[i]) {
					right--;
				}
				else {
					left++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
