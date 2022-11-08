package no15961;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/15961
 * 회전 초밥
 * */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 0; // 회전 초밥 벨트에 놓인 접시의 수
		int d = 0; // 초밥의 가짓수
		int k = 0; // 연속해서 먹는 접시의 수
		int c = 0; // 쿠폰 번호
		int[] sushi = {0, }; // 초밥 번호
		int[] visit = new int[3001]; // 연속된 k개의 구간에서의 몇번 초밥이 속해있는지에 대한 정보, ex) 3번 초밥 1개면, visit[3] = 1
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			k =  Integer.parseInt(st.nextToken());
			c =  Integer.parseInt(st.nextToken());
			
			sushi = new int[N + (k - 1)];
			
			for(int i = 0; i < N; i++) {
				sushi[i] = Integer.parseInt(br.readLine());
			}
			
			// 원형처럼 반복문을 돌리기 위해,맨 앞에서부터 k-1개의 초밥을 뒤에 붙인다.
			for(int i = N; i < N + k - 1; i++) {
				sushi[i] = sushi[i - N];
			}
			
			br.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		int start = 0; // 연속된 k개의 시작
		int end = k - 1; // 연속된 k개의 끝
		int result = -1; // 최종 결과 값
		int cnt = 1; // 먹을 수 있는 초밥의 가짓수, 쿠폰으로 제공하는 초밥은 조건없이 먹을 수 있으므로 초기값 1로 설정
		
		visit[c] = 1; // 쿠폰으로 제공하는 초밥은 초기에 1로 설정한다.
		
		// 처음 k개의 초밥에 대해 몇번 초밥을 몇개 먹었는지 체크.
		for(int i = 0; i < k; i++) {
			visit[sushi[i]]++;
			// k개의 구간에서 한 종류의 초밥을 한개만 먹었다면 cnt++
			if(visit[sushi[i]] == 1)
				cnt++;
		}
		
		while(start < N - 1) {
			
			// 최댓값 갱신
			result = Math.max(result, cnt);
			
			// 시작점이 옆으로 한칸 이동함에 따라 기존 시작점에서 먹었던 번호의 초밥 갯수를 하나 빼준다.
			visit[sushi[start]]--;
			// 기존 시작점에서 먹었던 초밥이 한개였을 경우, 즉 바로 윗줄에서 카운트를 하나 뺐는데 0인 경우 초밥 가짓수 한개 차감.
			if(visit[sushi[start++]] == 0) cnt--;
			// 끝점 역시 한칸 옆으로 이동하므로 이동했을 때의 초밥 갯수 1 증가.
			visit[sushi[++end]]++;
			// 옆으로 이동하여 먹은 초밥이 새로운 종류일 경우 초밥의 가짓수 1 증가.
			if(visit[sushi[end]] == 1) cnt++;
		}
		
		System.out.println(result);
	}

}
