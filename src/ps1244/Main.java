package ps1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1244
 * */
public class Main {
	static int N;
	static int[] swch;
	static int stNum;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		swch = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++)
			swch[i] = Integer.parseInt(st.nextToken());
		stNum = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < stNum; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(gender == 1) {
				for(int j = num; j <= N; j += num) {
					swch[j] = (swch[j] == 1) ? 0 : 1;
				}
				
//				System.out.print("Test gender1: ");
//				for(int j = 1; j <= N; j++)
//					System.out.print(swch[j] + " ");
//				System.out.println();
			}
			else {
				int left = num;
				int right = num;
				
				while(left - 1 > 0 && right + 1 <= N) {
					if(swch[left - 1] == swch[right + 1]) {						
						left--;
						right++;
					}
					else
						break;
				}
				
				for(int j = left; j <= right; j++)
					swch[j] = (swch[j] == 1) ? 0 : 1;
				
//				System.out.println("left: " + left + " right: " + right);
//				System.out.print("Test gender2: ");
//				for(int j = 1; j <= N; j++)
//					System.out.print(swch[j] + " ");
//				System.out.println();
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i = 1; i <= N; i++) {
			if(i == 20 || i == 40 || i == 60 || i == 80)
				sb.append(swch[i]).append("\n");
			else
				sb.append(swch[i]).append(" ");
		}
		
		System.out.println(sb);
	}

}
