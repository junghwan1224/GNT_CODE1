package ps2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/2156
 * 포도주 시식
 * */
public class Main {
	static int n;
	static int[] arr;
	static int[] d;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		d = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());;
		}
		
		d[1] = arr[1];
		if(n >= 2) {
			d[2] = arr[1] + arr[2];
		}
		
		// d[i] = i번째까지 포도주를 마셨을 때 마실 수 있는 최대 양 
		
		for(int i = 3; i <= n; i++) {
			// i번째 포도주를 먹지 않았을 때 
			d[i] = d[i - 1];
			// i번째 포도주부터 연속으로 마신다고 할 경우, (i - 1) 번째 포도주는 마시지 않으므로 d[i - 2]에 i번째 포도주 양 더해준다 
			d[i] = Math.max(d[i], d[i - 2] + arr[i]);
			// i번째 포도주를 (i - 1)번째 포도주부터 연속으로 마시는 경우, 세 번 연속으로 마시면 안되므로 (i - 2)번째 포도주는 마시지 않는다 
			d[i] = Math.max(d[i], d[i - 3] + arr[i - 1] + arr[i]);
		}
		
		System.out.println(d[n]);
	}

}
