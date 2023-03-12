package ps25757;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/25757
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		String game = st.nextToken();
		int limit = 0;
		
		if(game.equals("Y"))
			limit = 2;
		else if(game.equals("F"))
			limit = 3;
		else
			limit = 4;
		
		Set<String> gameSet = new HashSet<>(); // 현재 진행중인 게임 플레이어 저장
		Set<String> finishSet = new HashSet<>(); // 지금까지 게임했던 플레이어 저장
		
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			String name = br.readLine();
			
			// 현재 진행중인 플레이어 명단과 지금까지 게임했던 플레이어 명단 모두에 없으면 추가
			if(! gameSet.contains(name) && ! finishSet.contains(name)) {
				gameSet.add(name);
				finishSet.add(name);
			}
			
			// 현재 진행중인 플레이어 수가 주인공을 제외한 수만큼 채워졌으면 플레이 횟수 증가 및 현재 진행중인 명단 초기화
			if(gameSet.size() == limit - 1) {
				cnt++;
				gameSet = new HashSet<>();
			}
		}
		
		System.out.println(cnt);
	}

}
