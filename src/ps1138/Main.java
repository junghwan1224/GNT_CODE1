package ps1138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.acmicpc.net/problem/1138
 * */
public class Main {
	
	static int n;
	static int[] arr;
	static int[] flag;
	static StringBuffer sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		sb = new StringBuffer();
		flag = new int[n];
		Arrays.fill(flag, -1);
		
		for(int i = 0; i < n; i++) {
			int cnt = 0;
			for(int j = 0; j < n; j++) {
				if(flag[j] == -1) { // j 번째에 줄을 선 사람이 없으면
					if(arr[i] == cnt) { // 왼쪽에 큰 사람 수와 cnt 값이 같아지면 해당 위치에 키가 i인 사람을 줄세운다
						flag[j] = i + 1;
						break;
					}
					cnt++;
				}
			}
		}
		
		for(int i = 0; i < n; i++)
			sb.append(flag[i]).append(" ");
		
		System.out.println(sb);
	}

}
