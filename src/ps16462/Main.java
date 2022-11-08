package ps16462;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int sum = 0;
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			String s2 = s.replaceAll("0", "9");
			String s3 = s2.replaceAll("6", "9");
			
			s3 = Integer.parseInt(s3) > 100 ? "100" : s3;
			
			System.out.println(s3);
			sum += Integer.parseInt(s3);
		}
		
		System.out.println(Math.round(sum / (double)n));
	}

}
