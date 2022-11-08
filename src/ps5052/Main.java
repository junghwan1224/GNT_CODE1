package ps5052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.acmicpc.net/problem/5052
 * 전화번호 목록 
 * https://mygumi.tistory.com/219
 * */
public class Main {
	
	static int T;
	static int n;
	static String[] nums; // 번호 목록 저장 배열.

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			nums = new String[n];
			
			for(int i = 0; i < n; i++)
				nums[i] = br.readLine();
			
			// 번호 오름차순 정렬.
			Arrays.sort(nums);
			
			// 일관성 있는지 여부 체크하는 변수.
			boolean flag = true;
			for(int i = 0; i < n - 1; i++) {
				// 현재 번호의 길이가 다음 번호의 길이보다 길다면,
				// 일관성 여부를 확인할 필요가 없으므로 패스.
				// 정렬된 상태에서 현재 탐색 기준이 되는 번호의 길이가 더 길면 다음 번호의 접두어가 될 수 없기 때문.
				if(nums[i].length() > nums[i + 1].length())
					continue;
				
				// 다음 번호의 접두어가 현재 번호와 일치한다면, 일관성 없으므로 flag 값 false로 바꾼 후 반복문 탈출.
				// 번호 배열을 오름차순으로 정렬했기 때문에, 다음 번호(numA[i+1])의 접두어가 현재 번호와 일치하지 않다면,
				// 그 이후 번호(numA[i+2] 이후)들은 numA[i+1]보다 더 크기 때문에 일관성이 유지되는 것이 보장된다.
				if(nums[i + 1].substring(0, nums[i].length()).equals(nums[i])) {
					flag = false;
					break;
				}
			}
			
			if(flag)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
