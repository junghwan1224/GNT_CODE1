package ps2138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/2138
 * 전구와 스위치
 * ref: https://astrid-dm.tistory.com/429
 * */
public class Main {
	static int n;
	static char[] origin;
	static char[] target;
	static int MAX = 987654321;
	static int result = MAX;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		origin = new char[n];
		target = new char[n];
		origin = br.readLine().toCharArray();
		target = br.readLine().toCharArray();
		
		turnOnOff(0); // 첫 번째 전구의 스위치를 누르고 시작하는 경우 
		turnOnOff(1); // 두 번째 전구의 스위치를 누르고 시작하는 경우 
		
		result = (result != MAX) ? result : -1;
		
		System.out.println(result);
	}

	public static boolean isSame(char[] arr) {
		for(int i = 0; i < n; i++)
			if(arr[i] != target[i])
				return false;
		return true;
	}
	
	public static void print(char[] a) {
		for(int i = 0; i < n; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	
	public static void turnOnOff(int start) {
		int cnt = 0;
		// 임시 배열에 저장해서 비교용으로 사용 
		char[] temp = new char[n];
		for(int i = 0; i < n; i++)
			temp[i] = origin[i];
		
		/* System.out.println();
		System.out.println("start: " + start);
		System.out.println("----- before -----");
		print(temp);
		System.out.println("------------------");
		System.out.println(); */
		
		// 첫 번째 스위치를 눌렀을 때 전구 상태 바꿔준다 
		if(start == 0) {
			temp[0] = (temp[0] == '0') ? '1' : '0';
			temp[1] = (temp[1] == '0') ? '1' : '0';
			cnt++;
		}
		
		// 두 번째 스위치부터 확인 
		for(int i = 1; i < n; i++) {
			int prev = i - 1;
			int cur = i;
			int next = i + 1;
			boolean flag = false;
			// (i - 1)번째 전구를 비교하여 스위치를 누를 것인지 판단 
			// i 번째 스위치를 누르면 (i - 1)번째가 변경되니까 
			flag = (temp[prev] == target[prev]) ? false : true;
			
			// 스위치 눌러서 전구 상태 바꿔줌 
			if(flag) {
				temp[cur] = (temp[cur] == '0') ? '1' : '0';
				
				if(prev >= 0)
					temp[prev] = (temp[prev] == '0') ? '1' : '0';
				
				if(next < n)
					temp[next] = (temp[next] == '0') ? '1' : '0';				
				
				cnt++;
			}
		}
		
		/* System.out.println();
		System.out.println("start: " + start);
		System.out.println("----- after -----");
		print(temp);
		System.out.println("-----------------");
		System.out.println(); */
		
		// 작업이 끝난 후 만들고자 하는 상태와 같으면 최솟값 갱신 
		if(isSame(temp)) {
			result = Math.min(result, cnt);
		}
		
		return;
	}
}
