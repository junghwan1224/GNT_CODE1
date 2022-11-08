package ps16461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/16461
 * 듀얼 채널 VHF 무전기
 * */
public class Main {
	static int n;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			String channel = st.nextToken();
			double target = Double.parseDouble(st.nextToken());
			//System.out.println(a + " " + b + " " + channel + " " + target);
			
			int result = 6;
			
			int case2A = clickUp(a, target);
			int case2B = clickUp(b, target);
			case2A = channel.equals("B") ? case2A + 1 : case2A;
			case2B = channel.equals("A") ? case2B + 1 : case2B;
			result = Math.min(result, case2A);
			result = Math.min(result, case2B);
			
			int case3A = clickDown(a, target);
			int case3B = clickDown(b, target);
			case3A = channel.equals("B") ? case3A + 1 : case3A;
			case3B = channel.equals("A") ? case3B + 1 : case3B;
			result = Math.min(result, case3A);
			result = Math.min(result, case3B);
			
			System.out.println(result);
		}
	}

	public static int clickUp(double a, double target) {
		int cnt = 0;
		int aa = (int)(a * 1000);
		int targetI = (int)(target * 1000);
		
		while(true) {
			if(aa == targetI)
				break;
			aa += 20;
			if(aa > 146000)
				aa = 144000;
			cnt++;
		}
		
		return cnt;
	}
	
	public static int clickDown(double a, double target) {
		int cnt = 0;
		int aa = (int)(a * 1000);
		int targetI = (int)(target * 1000);
		
		while(true) {
			if(aa == targetI)
				break;
			aa -= 20;
			if(aa < 144000)
				aa = 146000;
			cnt++;
		}
		return cnt;
	}
}
