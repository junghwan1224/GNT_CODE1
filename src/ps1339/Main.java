package ps1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.acmicpc.net/problem/1339
 * 단어 수학
 * 참고: https://mygumi.tistory.com/156
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		/*
		 * ex)
		 * 각 알파벳의 가중치 
		 * ABC => 100A + 10B + C
		 * BCD => 100B + 10C + D
		 * 
		 * 가중치를 더하면 아래와 같다.
		 * ABC + BCD
		 * 100A + 110B + 10C + D
		 * 
		 * 가중치를 내림차순으로 정렬하면 아래와 같다.
		 * 해당 가중치에 해당하는 알파벳에 순서대로 9부터 할당 
		 * 110B + 100A + 10C + D
		 * */
		
		// 알파벳 별로 해당 가중치를 저장할 배열 
		int[] nums = new int[26];
		// 가중치가 가장 큰 알파벳부터 할당할 수, 9부터 1씩 낮아짐 
		int v = 9;
		// 결과값 
		int result = 0;
		
		for(int i = 0; i < n; i++) {
			char[] ch = br.readLine().toCharArray();
			
			// 문자열 길이만큼에 해당하는 가중치 값 
			int p = (int) Math.pow(10, ch.length - 1);
			for(int j = 0; j < ch.length; j++) {
				// 해당하는 문자 위치에 가중치 더해줌 
				nums[ch[j] - 'A'] += p;
				p /= 10;
			}
		}
		
		// 가중치 값대로 정렬 
		Arrays.sort(nums);
		
		// 가중치가 큰 값부터 9를 곱하고 1씩 낮은 값을 곱하여 결과값에 더해줌 
		for(int i = nums.length - 1; i >= 0; i--) {
			if(v == 0)
				break;
			
			result += nums[i] * v;
			v--;
		}
		
		System.out.println(result);
	}

}
