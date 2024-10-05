package ps1189;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1189
 * 컴백홈
 * */
public class Main {
    static int R;
    static int C;
    static int K;
    static char[][] arr;
    static boolean[][] visit;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        visit[R - 1][0] = true;
        dfs(R - 1, 0, 1); // 출발하면서 거리가 1이 된다

        System.out.println(result);
    }

    public static void dfs(int y, int x, int cnt) {
        if(y == 0 && x == C - 1) {
            if(cnt == K)
                result++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(0 <= ny && ny < R && 0 <= nx && nx < C) {
                if(arr[ny][nx] != 'T' && ! visit[ny][nx]) {
                    visit[ny][nx] = true;
                    dfs(ny, nx, cnt + 1);
                    visit[ny][nx] = false;
                }
            }
        }
    }
}
