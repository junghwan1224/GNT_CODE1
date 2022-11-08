package ps1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* https://www.acmicpc.net/problem/1522
* 문자열 교환
* */
public class Main {
	static char[] arr;
	static int aCnt;
	static int result = 987654321;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = br.readLine().toCharArray();
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 'a')
				aCnt++;
		}
		
		for(int i = 0; i < arr.length; i++) {
			int cnt = aCnt; // 한 곳으로 몰아야 하는 a의 갯수 
			int temp = 0; // 자리를 바꿔야 할 b의 갯수 
			for(int j = i; j < arr.length + i; j++) {
				// 더이상 한곳으로 몰아야 할 a가 없다면 해당 구간 탐색 종료
				if(cnt == 0)
					break;
				// 원형이므로 인덱스는 j % arr.length로 지정해준다 
				// 현재 탐색중인 문자가 a라면, 이미 모여져있는 문자라는 뜻이므로 몰아야 하는 a의 수를 하나 차감한다 
				if(arr[j % arr.length] == 'a') {
					cnt--;
				}
				// 현재 탐색중인 문자가 b이면 temp값 1 올려준다 
				// cnt 값을 줄이는 것은 b를 만났을 때 자리를 바꾼 것으로 생각하기 때문에, 한곳으로 몰아야 하는 a의 갯수가 줄어드는 것
				else {
					temp++;
					cnt--;
				}
			}
			// 최솟값 갱신 
			result = Math.min(result, temp);
		}
		
		System.out.println(result);
	}

}
