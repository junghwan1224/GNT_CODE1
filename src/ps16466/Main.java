package ps16466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		//int[] tickets = new int[1000001];
		
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			long num = Long.parseLong(st.nextToken());
			//tickets[num] = 1;
			map.put(num, 1);
		}
		
		long result = 1;
		while(true) {
			if(! map.containsKey(result))
				break;
			result++;
		}
		
		System.out.println(result);
	}

}
