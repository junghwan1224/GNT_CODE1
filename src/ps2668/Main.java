package ps2668;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * https://www.acmicpc.net/problem/2668
 * */
public class Main {
    static int N;
    static Map<Integer, Integer> map;
    static Set<Integer> set;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new HashMap<>();
        set = new HashSet<>();
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            int a = Integer.parseInt(br.readLine());
            map.put(i, a);
        }

        // 인덱스 1부터 n까지 dfs를 돌린다.
        for (int i = 1; i <= N; i++) {
            visit[i] = true;
            dfs(i, map.get(i));
            visit = new boolean[N + 1];
        }

        // 싸이클을 형성할 수 있는 숫자들의 집합의 수가 정답이다
        System.out.println(set.size());

        ArrayList<Integer> list = new ArrayList<>();
        for(Integer i: set)
            list.add(i);

        Collections.sort(list);

        for (Integer i: list)
            System.out.println(i);
    }

    public static void dfs(int start, int num) {
        // 인덱스 i에서 dfs로 탐색하여 방문했던 숫자에 다시 방문했을 때, 다시 i로 돌아왔는지 검사한다.
        if(visit[num]) {
            // 다시 i로 돌아왔다면, 재귀로 방문한 숫자들을 set에 삽입한다
            if(start == num) {
                set.add(num);
            }

            // 다시 i로 돌아오지 않았다면 아무것도 하지 않고 return한다.
            return;
        }

        visit[num] = true;
        dfs(start, map.get(num));
    }
}
