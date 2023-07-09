package ps16987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/16987
 * 계란으로 계란치기
 * */
class Egg {
    int s;
    int w;

    public Egg(int s, int w) {
        this.s = s;
        this.w = w;
    }
}

public class Main {
    static int N;
    static Egg[] arr;
    static boolean[] visit;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Egg[N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[i] = new Egg(s, w);
        }

        dfs(0);

        System.out.println(result);
    }

    public static void dfs(int idx) {
        // 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란일 경우 계란을 치는 과정을 종료한다.
        if(idx == N) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if(arr[i].s <= 0)
                    cnt++;
            }
            result = Math.max(result, cnt);
            return;
        }

        // 손에 든 계란이 깨졌거나 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다.
        if(arr[idx].s <= 0)
            dfs(idx + 1);

        else {
            // 계란을 내려쳤는지 확인
            boolean isAttack = false;
            for (int i = 0; i < N; i++) {
                if(i == idx)
                    continue;

                // 손에 들고 있는 계란으로 깨지지 않은 다른 계란 중에서 하나를 친다
                if(arr[i].s > 0) {
                    arr[i].s -= arr[idx].w;
                    arr[idx].s -= arr[i].w;

                    // 손에 든 계란을 원래 자리에 내려놓고 3번 과정을 진행한다.
                    // 가장 최근에 든 계란의 한 칸 오른쪽 계란을 손에 들고 2번 과정을 다시 진행한다.
                    isAttack = true;
                    dfs(idx + 1);

                    arr[i].s += arr[idx].w;
                    arr[idx].s += arr[i].w;
                }
            }

            // 순회하면서 내려친 계란이 없다면(== 모든 계란이 깨져있는 경우) N 값으로 dfs 호출하여 갯수 갱신하도록 처리
            if(! isAttack)
                dfs(N);
        }
    }
}
