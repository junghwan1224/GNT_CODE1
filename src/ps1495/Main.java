package ps1495;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1495
 * 기타리스트
 * 소요시간: 1시간 20분.
 * BFS 메모리 초과
 * https://mygumi.tistory.com/145
 * */

class Volume {
	int vol;
	int step;
	
	public Volume(int vol, int step) {
		this.vol = vol;
		this.step = step;
	}
}

public class Main {
	static int n;
	static int s;
	static int m;
	static int[] vol;
	// d[n][s] = n번째 곡일 때, 볼륨 s 가능 여부. 
	static boolean[][] d;
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		vol = new int[n + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			vol[i] = Integer.parseInt(st.nextToken());
		}
		
		d = new boolean[51][1001];
		
		// 첫 번째 곡을 연주하기 전에 바꿀 수 있는 볼륨으로 연주할 수 있는지 체크.
		if(0 <= s + vol[1] && s + vol[1] <= m)
			d[1][s + vol[1]] = true;
		
		if(0 <= s - vol[1] && s - vol[1] <= m)
			d[1][s - vol[1]] = true;
		
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j <= m; j++) {
				// 이전 연주곡의 볼륨 j로 연주할 수 없다면 밑의 로직을 확인할 필요 없이 바로 다음 볼륨 확인.
				if(! d[i - 1][j])
					continue;
				
				// j + vol[i] 볼륨이 연주할 수 있는 볼륨의 범위 내에 있다면 true로 체크.
				if(0 <= j + vol[i] && j + vol[i] <= m)
					d[i][j + vol[i]] = true;
				
				// j - vol[i] 볼륨이 연주할 수 있는 볼륨의 범위 내에 있다면 true로 체크.
				if(0 <= j - vol[i] && j  - vol[i] <= m)
					d[i][j - vol[i]] = true;
			}
		}
		
		result = -1;
		// m부터 순회하면서 true인 볼륨값이 있다면 결과값에 저장 후 반복문 종료.
		for(int i = m; i >= 0; i--) {
			if(d[n][i]) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
	}

}
