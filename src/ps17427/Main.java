package ps17427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/17427
 * 약수의 합 2
 * */
public class Main {
	static int n;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		long sum = 0;
		
		/*
			 N = 10일 때)
			 [1] [1, 2] [1, 3] [1, 2, 4] [1, 5] [1, 2, 3, 6] [1, 7] [1, 2, 4, 8] [1, 3, 9] [1, 2, 5, 10]
			 잘 살펴보면,
			 [1이 10번, 2가 5번, 3이 3번, 4가 2번 5가 2번, 6이 1번, ... ,10이 1번] 이렇게 들어가는 규칙을 볼 수 있다.
			
			 10 / 2 = 5 니깐 5번..
			 10 / 3 = 3. 이니 3번..
		 * */
		for(int i = 1; i <= n; i++)
			sum += (n / i) * i;
		
		System.out.println(sum);
 	}

}
