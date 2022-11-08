package ps20058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int x;
	int y;
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	} 
}

/*
 * https://www.acmicpc.net/problem/20058
 * 마법사 상어와 파이어스톰
 * */
public class Main {
	static int n;
	static int q;
	static int[][] ice; // 얼음판. 얼음의 양 입력값 저장.
	static int[] l; // 시전 단계.
	static int mapSize; // 얼음판 크기.
	static int largestIceArea; // 가장 큰 얼음 덩어리 크기.
	static int iceArea; // 얼음 덩어리 크기 저장하는 임시 변수.
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static Queue<Integer> queue; // 격자를 회전하기 위해 임시로 얼음양 값을 저장하기 위해 사용하는 큐.
	static Queue<Pos> posQ; // 얼음 덩어리 크기를 구하기 위해 BFS 사용시 이용되는 큐.
	
	static boolean[][] visit; // 방문 여부. 얼음 덩어리 크기 구하는 BFS 사용시 이용.
	static boolean[][] isPossibleMelt; // 얼음이 녹을 수 있는지 저장하는 배열. 얼음 녹일 때 이용.
	static boolean[][] meltTemp; // 해당 위치에서 얼음이 녹을 수 있는지 사용하는 임시 배열. 바로 녹이면 결과값 이상하기 때문에 임시 배열 사용.

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		mapSize = (int) Math.pow(2, n);
		ice = new int[mapSize][mapSize];
		
		for(int i = 0; i < mapSize; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < mapSize; j++) {
				ice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		l = new int[q];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < q; i++)
			l[i] = Integer.parseInt(st.nextToken());
		
		// 입력받은 순서대로 시전 단계 수행.
		for(int k = 0; k < q; k++) {
			// 시전 단계별로 2**l[k] 크기로 격자를 나누기 때문에 별도의 변수에 저장하여 사용.
			int splitSize = (int) Math.pow(2, l[k]);
			
			// 2 ** l[k] 격자로 쪼개기 위해 해당 좌표 찾기.
			// 2 ** l[k] 를 현재 좌표로 나누어지면 격자로 쪼개어지는 위치.
			for(int i = 0; i < mapSize; i+= splitSize) {
				for(int j = 0; j < mapSize; j+= splitSize) {
					queue = new LinkedList<Integer>();
					// 격자별로 회전.
					rotate(splitSize, i, j);
				}
			}
			
			// 시전할 때마다 사용되는 변수들 초기화.
			posQ = new LinkedList<Pos>();
			visit = new boolean[mapSize][mapSize];
			isPossibleMelt = new boolean[mapSize][mapSize];
			meltTemp = new boolean[mapSize][mapSize];
			
			// 해당 위치 (i, j)에서 얼음이 녹을 수 있는지 확인 후 임시 배열에 녹을 수 있는지 여부 저장.
			// 녹을 수 있다고 바로 값을 -1 해버리면, 이후 연산이 꼬이기 때문에 해당 단계에서는 확인만 함.
			for(int i = 0; i < mapSize; i++) {
				for(int j = 0; j < mapSize; j++) {
					if(ice[i][j] == 0)
						continue;
					meltTemp[i][j] = isMelt(i, j);
				}
			}
			
			// 얼음량이 남아있고, 윗단계에서 확인했을 때 녹을 수 있는 위치면 얼음량 -1.
			for(int i = 0; i < mapSize; i++) {
				for(int j = 0; j < mapSize; j++) {
					if(ice[i][j] != 0 && meltTemp[i][j])
						ice[i][j]--;
				}
			}
		}
		
		// BFS로 Flood Filling 수행 후 가장 큰 얼음 덩어리 값 구하기.
		for(int i = 0; i < mapSize; i++) {
			for(int j = 0; j < mapSize; j++) {
				if(ice[i][j] != 0) {
					iceArea = 0;
					findLargeIce(i, j);
					largestIceArea = Math.max(largestIceArea, iceArea);
				}
			}
		}
		
		System.out.println(sumIce());
		System.out.println(largestIceArea);
	}
	
	// 격자를 시계방향 90도로 회전하는 함수.
	public static void rotate(int size, int y, int x) {
		// 우선 순차적으로 값을 큐에 저장한다.
		for(int i = y; i < y + size; i++) {
			for(int j = x; j < x + size; j++) {
				queue.add(ice[i][j]);
			}
		}
		
		// 시계 방향으로 90도 회전이므로, 가장 끝 열부터 차례대로 큐에 입력한 값을 넣는다.
		// 순서: 가장 끝 열 -> 첫 번째 열.
		//      동시에 행은 위에서 아래로.
		for(int i = size + x - 1; i >= x; i--) {
			for(int j = y; j < y + size; j++) {
				ice[j][i] = queue.poll();
			}
		}
	}
	
	// 현재 위치의 얼음이 녹을 수 있는지 확인하는 함수.
	public static boolean isMelt(int y, int x) {
		// 인접한 곳(상하좌우)에 얼음이 없는 경우의 수.
		int cnt = 0;
		
		// 상하좌우 체크.
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 현재 얼음이 가장자리에 있거나, 인접한 얼음이 이미 다 녹았을 경우(ice[ny][nx] == 0)
			if( ! (0 <= nx && nx < mapSize && 0 <= ny && ny < mapSize) || ice[ny][nx] == 0 ) {
				// cnt 값 1 증가.
				cnt++;
			}
		}
		
		// 3칸 또는 이상이 인접해있어야 얼음이 녹지 않는다.
		// cnt 값이 1보다 큰 경우, 즉 인접한 곳에 얼음이 없는 경우가 2가지 이상인 경우에는 녹을 수 밖에 없으므로 true 반환.
		if(cnt > 1)
			return true;
		// 그 외에는 녹지 않으므로 false 반환.
		else
			return false;
	}
	
	// 얼음 덩어리 구하기.
	// BFS를 활용한 Flood Filling
	public static void findLargeIce(int y, int x) {
		posQ.add(new Pos(x, y));
		visit[y][x] = true;
		iceArea++;
		while(! posQ.isEmpty()) {
			Pos curPos = posQ.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = curPos.x + dx[i];
				int ny = curPos.y + dy[i];
				
				if(0 <= nx && nx < mapSize && 0 <= ny && ny < mapSize && ! visit[ny][nx] && ice[ny][nx] != 0) {
					visit[ny][nx] = true;
					posQ.add(new Pos(nx, ny));
					iceArea++;
				}
			}
		}
	}
	
	// 얼음 총량 구하기.
	public static int sumIce() {
		int cnt = 0;
		for(int i = 0; i < mapSize; i++)
			for(int j = 0; j < mapSize; j++)
				cnt += ice[i][j];
		return cnt;
	}
	
	// 값 확인용 테스트 함수.
	public static void print() {
		for(int i = 0; i < mapSize; i++) {
			for(int j = 0; j < mapSize; j++) {
				System.out.print(ice[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
