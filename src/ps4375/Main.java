package ps4375;

import java.io.IOException;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/4375
 * 1
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		/*
		 예를들어 n = 3 이 주어지고 K = 11 이 나누어지지 않아 K = 111을 보는 경우를 생각하면
		 , 11 = 9 + 2 = 2 (mod 3) 이므로 111 = 110 + 1 = 20 + 1 = 21 (mod 3) 입니다.
		 * */
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			int num = 1;
			int digit = 1;
			
			while(num % n != 0)  {
				num %= n;
				num = num * 10 + 1;
				digit++;
			}
			
			System.out.println(digit);
		}
	}

}
