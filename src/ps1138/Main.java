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
				if(flag[j] == -1) { // j ��°�� ���� �� ����� ������
					if(arr[i] == cnt) { // ���ʿ� ū ��� ���� cnt ���� �������� �ش� ��ġ�� Ű�� i�� ����� �ټ����
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
