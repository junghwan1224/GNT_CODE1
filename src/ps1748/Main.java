package ps1748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * https://www.acmicpc.net/problem/1748
 * 수 이어 쓰기 1
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int nLen = Integer.toString(n).length();
		int result = 0;
		
		// 자릿수, 각 자릿수별 총 갯수 
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("1", 9);
		map.put("2", 90);
		map.put("3", 900);
		map.put("4", 9000);
		map.put("5", 90000);
		map.put("6", 900000);
		map.put("7", 9000000);
		map.put("8", 90000000);
		
		// 입력 받은 자릿수보다 1 작은 자릿수까지의 총 길이수 더해준다.
		// ex) n = 120 이면 
		// 자릿수가 1인 경우의 총 길이수, 자릿수가 2인 경우의 총 길이수 구해준다.
		// 자릿수별 총 갯수 * 자릿수 
		for(int i = nLen - 1; i >= 1; i--)
			result += map.get(Integer.toString(i)) * i;
		
		// 입력받은 자릿수보다 1 작은 자릿수까지 구했으니, 입력받은 자릿수에 대해 총 길이 구하기 
		// 예외적으로 입력값이 최댓값인 1억이면 그냥 9만 더해준다.
		if(n == 100000000)
			result += 9;
		// (입력받은 수 - 입력받은 수와 같은 자릿수 값 중 최솟값 + 1) * 자릿수
		// (120 - 100 + 1) * 3
		else {
			result += (n - Math.pow(10, (nLen - 1)) + 1) * nLen;
		}
		
		System.out.println(result);
	}

}
