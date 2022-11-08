package ps1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1043
 * 거짓말
 * */
public class Main {
	static int N;
	static int M;
	
	static int trueNum;
	static int[] trueMember;
	static boolean[] isPartyTrue;
	static boolean[] isMemberTrue;
	
	static ArrayList<Integer>[] parties;
	static int[] partyNums;
	
	static Queue<Integer> que;
	
	static int result;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		que = new LinkedList<Integer>(); // 진실 아는 사람들 담을 큐 true: 안다. false: 모른다.
		isMemberTrue = new boolean[N + 1]; // 진실을 아는지 여부 true: 안다. false: 모른다.
		isPartyTrue = new boolean[M];
		partyNums = new int[M]; // 파티별 참석 인원 
		
		parties = new ArrayList[M];
		for(int i = 0; i < M; i++)
			parties[i] = new ArrayList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		trueNum = Integer.parseInt(st.nextToken());
		if(trueNum != 0) {
			trueMember = new int[trueNum];
			for(int i = 0; i < trueNum; i++) {
				trueMember[i] = Integer.parseInt(st.nextToken());
				que.add(trueMember[i]); // 큐 저장 
				isMemberTrue[trueMember[i]] = true; // 진실 아는 사람은 미리 true로 체크
			}
		}
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			partyNums[i] = Integer.parseInt(st.nextToken());
			for(int j = 0; j < partyNums[i]; j++)
				parties[i].add(Integer.parseInt(st.nextToken()));
		}
		
		while(! que.isEmpty()) {
			int cur = que.poll();
			
			for(int i = 0; i < M; i++) {
				// 진실을 알고 있는 사람이 있으면 해당 파티는 거짓말 못한다고 표시 
				if(parties[i].contains(cur)) {
					isPartyTrue[i] = true;
				}
				
				// 거짓말 못하는 파티가 있으면 해당 파티의 참석자는 모두 진실을 알고 있다고 표시 
				if(isPartyTrue[i]) {
					for(Integer n: parties[i]) {
						// 거짓말 못하는 파티 구성원 중, 진실을 원래 알고 있던 사람이 아닌 경우,
						if(! isMemberTrue[n]) {							
							// 진실을 알고 있는 멤버로 처리 
							isMemberTrue[n] = true;
							// 해당 멤버 큐에 추가, 해당 멤버가 속해있는 다른 파티도 진실을 알고 있다고 표시해야 하기 때문에, 해당 값으로 while문 로직 수행 
							que.add(n);
						}
					}
				}
			}
		}
		
		for(int i = 0; i < M; i++) {
			
			// 처음부터 진실을 알고 있던 사람이 없는 파티에서, 진실을 알게 된 사람과 같이 있던 사람들 존재하면 해당 파티도 거짓말 못하므로 체크 
			if(! isPartyTrue[i]) {
				for(Integer n: parties[i]) {
					if(isMemberTrue[n]) {
						isPartyTrue[i] = true;
						break;
					}
				}
			}
		}
		
		for(int i = 0; i < M; i++) {
			if(! isPartyTrue[i])
				result++;
		}
		
		System.out.println(result);
	}

}
