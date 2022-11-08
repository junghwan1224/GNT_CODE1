package ps20006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/20006
 * 랭킹전 대기열
 * */
class Player {
	int level;
	String nickname;
	
	public Player(int level, String nickname) {
		this.level = level;
		this.nickname = nickname;
	}
}

public class Main {
	static int p, l, m;
	static String n;
	static ArrayList<ArrayList<Player>> room;
	static StringBuffer sb;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		room = new ArrayList<ArrayList<Player>>(); 
		sb = new StringBuffer();
		
		for(int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			n = st.nextToken();
			
			Player newPlayer = new Player(l, n);
			
			int roomIdx = enterRoomIdx(l);
			
			// 매칭 가능한 방이 없으면 방 새로 생성 
			if(roomIdx == -1) {
				ArrayList<Player> newRoom = new ArrayList<Player>();
				newRoom.add(newPlayer);
				room.add(newRoom);
			}
			
			// 매칭 가능한 방이면 해당 방에 입장 
			else {
				room.get(roomIdx).add(newPlayer);
			}
		}
		
		for(int i = 0; i < room.size(); i++) {
			if(room.get(i).size() == m)
				sb.append("Started!").append("\n");
			else
				sb.append("Waiting!").append("\n");
			
			room.get(i).sort((a, b) -> a.nickname.compareTo(b.nickname));
			
			for(Player p: room.get(i))
				sb.append(p.level).append(" ").append(p.nickname).append("\n");
		}
		
		System.out.println(sb);
	}

	// 입장 가능한 방의 인덱스 반환, 입장 가능한 방이 없다면 -1 반환 
	public static int enterRoomIdx(int level) {
		// 생성된 방이 없으면
		if(room.size() == 0)
			return -1;
		
		// 방마다 입장 가능한지 체크
		for(int i = 0; i < room.size(); i++) {
			ArrayList<Player> r = room.get(i);
			int curRoomSize = r.size(); // 현재 탐색중인 방에 있는 플레이어 수 
			
			// 해당 방에 가장 먼저 입장한 플레이어의 레벨
			int leaderLevel = r.get(0).level;
			
			// 현재 탐색중인 방에 정원이 꽉 차지 않고, 처음 입장한 플레이어의 레벨을 기준으로 -10부터 +10인 경우
			// 입장 가능하다는 뜻이므로 해당 방의 인덱스 반환 
			if(curRoomSize < m && (leaderLevel - 10 <= level && level <= leaderLevel + 10)) {
				return i;
			}
		}
		
		return -1;
	}
}
