package ps17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/17144
 * 미세먼지 안녕!
 * */

// 먼지 정보 
class Dust {
	int y; // 먼지 행 위치 
	int x; // 먼지 열 위치 
	int dust; // 먼지의 양 
	
	public Dust(int y, int x, int dust) {
		this.y = y;
		this.x = x;
		this.dust = dust;
	}
}

// 청소기 위치 
class Cleaner {
	int y; // 청소기 행 위치 
	int x; // 청소기 열 위
	
	public Cleaner(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static int R;
	static int T;
	static int C;
	static int[][] map;
	static int[][] copyMap; // 임시 저장 배
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[] clockwise = {0, 2, 1, 3}; // dx, dy 배열 선언값을 토대로 한 시계 방향 순서 인덱스 
	static int[] nonClockwise = {0, 3, 1, 2}; // dx, dy 배열 선언값을 토대로 한 반시계 방향 순서 인덱스 
	
	static ArrayList<Cleaner> cleaner; // 공기청정기 위치 저장 리스트 
	static Queue<Dust> dustQ; // 먼지 정보 저장 큐 

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		dustQ = new LinkedList<Dust>();
		cleaner = new ArrayList<Cleaner>();
		map = new int[R][C];
		copyMap = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1)
					cleaner.add(new Cleaner(i, j));
			}
		}
		
		while(T > 0) {
			// 확산 
			spread();
			
			// 확산 후 결과를 임시 배열에 저장 
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					copyMap[i][j] = map[i][j];
				}
			}
			
			// 공기청정기 작동 
			cleanDust(cleaner.get(0), nonClockwise);
			cleanDust(cleaner.get(1), clockwise);
			
			T--;
		}
		
//		print();
		
		System.out.println(getDustSum());
	}

	// 먼지 확산 
	public static void spread() {
		// 먼지의 양이 4이상인 먼지 정보를 큐에 저장 
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] > 4)
					dustQ.add(new Dust(i, j, map[i][j]));
			}
		}
		
		while(! dustQ.isEmpty()) {
			Dust cur = dustQ.poll();
			// 확산될 먼지의 양 
			int spreadDust = (int) Math.floor(cur.dust / 5);
			int cnt = 0;
			
			for(int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				// 인접한 칸에 먼지 확산 
				if(0 <= ny && ny < R && 0 <= nx && nx < C && map[ny][nx] != -1) {
					map[ny][nx] += spreadDust;
					cnt++;
				}
			}
			
			// 확산되고 남은 먼지의 양 계산 
			map[cur.y][cur.x] -= spreadDust * cnt;
		}
	}
	
	// 공기청정기 동작 
	/*
	 * 공기청정기 위치 
	 * 방향(시계 / 반시계)
	 * */
	public static void cleanDust(Cleaner c, int[] direction) {
		int y = c.y;
		int x = c.x + 1; // 방향 상관없이 공기청정기 오른쪽부터 한칸씩 이동하기 때문에 +1 해줌 
		map[y][x] = 0; // 공기청정기 바로 옆칸은 동작하자마자 한칸 밀리므로 0으로 초기화 
		
		for(int i = 0; i < 4; i++) {
			
			while(true) {
				// 입력받은 방향으로 순환 
				int ny = y + dy[direction[i]];
				int nx = x + dx[direction[i]];
				
				// 범위 벗어나거나 공기청정기 위치까지 도달하면 종료 
				if(! (0 <= ny && ny < R && 0 <= nx && nx < C) || (ny == c.y && nx == c.x))
					break;
				
				// 한칸씩 이동하므로 다음 위치에 이전 위치의 먼지 값 저장 
				map[ny][nx] = copyMap[y][x];
				
				y = ny;
				x = nx;
			}
			
		}
	}
	
	public static int getDustSum() {
		int totalDust = 0;
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] > 0)
					totalDust += map[i][j];
			}
		}
		
		return totalDust;
	}
	
	public static void print() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
