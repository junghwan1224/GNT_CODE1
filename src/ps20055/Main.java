package ps20055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/20055
 * 컨베이어 벨트 위의 로봇
 * */
public class Main {
	static int N;
	static int K;
	static int[] A;
	static boolean[] robot; // 로봇 유무 true: 있음 / false: 없음
	static Queue<Integer> que; // 로봇 저장 큐, 먼저 벨트에 올라간 로봇부터 이동해야 하므로 큐에 로봇 위치 저장
	static int up; // 올리는 위치 
	static int down; // 내리는 위치 
	static int cnt; // 내구도가 0인 칸의 갯수 
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		robot = new boolean[N + N];
		que = new LinkedList<Integer>();
		
		up = 0; // 올리는 위치 초기 위치는 첫 번째 인덱스 
		down = N - 1; // 내리는 위치 초기 위치는 길이가 2N인 벨트의 가운데 위치가 되는 인덱스 
		
		while(cnt < K) {
			result++;
			moveBelt(); // 벨트 이동 
			moveRobot(); // 로봇 이동 
			putRobot(); // 로봇 배치 
		}
		
		System.out.println(result);
	}
	
	// 로봇 이동
	public static void moveRobot() {
		int size = que.size();
		
		for(int i = 0; i < size; i++) {
			// 제일 먼저 벨트에 올라온 로봇 위치 
			int cur = que.peek();
			// 이동 예정이므로 현재 위치의 로봇 없다고 처리 
			robot[cur] = false;
			que.poll();
			
			// 현재 로봇의 위치가 내리는 위치라면, 로봇을 내려야 하므로 해당 로봇은 내리고 다음 로봇부터 다시 탐색 
			if(cur == down)
				continue;
			
			// 로봇이 이동할 다음 위치 
			int next = cur + 1;
			
			// 다음 위치의 인덱스가 2N을 넘어가면 0으로 바꿔준다 
			if(next >= 2 * N)
				next = 0;
			
			// 다음 위치의 벨트 내구도가 0보다 크고 로봇이 없으면 
			if(A[next] > 0 && ! robot[next]) {
				
				// 로봇 배치, 내구도 감소 
				A[next]--;
				// 내구도가 0인 칸에 대해 갯수 세기 
				if(A[next] == 0)
					cnt++;
				// 다음 칸이 내리는 위치라면 로봇 배치 후 바로 내려줘야 하기 때문에, 로봇 배치 없이 내구도 카운트만 해주고 넘어간다 
				if(next == down)
					continue;
				robot[next] = true;
				que.add(next);
				
			}
			// 로봇을 이동시킬 수 없으면 현재 위치 그대로 둔다 
			else {
				robot[cur] = true;
				que.add(cur);
			}
		}
	}
	
	// 컨베이어 벨트 한 칸 이동, 인덱스 1씩 감소(오른쪽으로 이동하기 때문)
	public static void moveBelt() {
		up--;
		down--;
		
		if(up < 0)
			up = 2 * N - 1;
		if(down < 0)
			down = 2 * N - 1;
	}
	
	// 올리는 위치에 로봇 배치 
	public static void putRobot() {
		if(A[up] > 0 && ! robot[up]) {
			A[up]--;
			robot[up] = true;
			que.add(up);
			
			// 올리는 위치에 로봇을 배치한 후 내구도가 0이 되면, cnt 1 더해줌 
			if(A[up] == 0)
				cnt++;
		}
	}
}
