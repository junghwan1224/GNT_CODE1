package ps25338;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/25338
 * 바지 구매
 * */
public class Main {
	static int a, b, c, d;
	static int N;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			double len = getLen(a, b, c, d, u);
			double size = getSize(a, b, c, d, v);
			
			
			if((int)size <= u && (int)len >= v) {
			//if(isHipRange(a, b, c, d, v) && size > d) {
				System.out.println(u + ", " + v + ", " + len + ", " + size);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	public static double getSize(int a, int b, int c, int d, int x) {
		double size = 0.0;
		size = a * Math.pow((x - b), 2) + c;
		size = Math.max(size, d);
		return size;
	}
	
	public static double getLen(int a, int b, int c, int d, int y) {
		double len = 0.0;
		len = Math.sqrt((y - c) / a) + b;
		return len;
	}
	
	public static boolean isHipRange(int a, int b, int c, int d, int x) {
		boolean flag = false;
		double left = (c - d) / a;
		left = -1 * Math.sqrt(left) + b;
		
		double right = (c - d) / a;
		right = Math.sqrt(right) + b;
		
		if(b <= x && x <= right)
			flag = true;
		
		return flag;
	}
}
