package ps18429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/18429
 * 근손실
 * */
public class Main {
    static int N;
    static int K;
    static int[] arr;
    static boolean[] flag;
    static int W = 500;
    static int dayCnt;
    static int weight = 500;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        flag = new boolean[N];

        dfs();

        System.out.println(cnt);
    }

    static public void dfs() {
        if(weight < W)
            return;

        if(dayCnt == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(! flag[i]) {
                weight += (arr[i] - K);
                dayCnt++;
                flag[i] = true;

                dfs();

                weight -= (arr[i] - K);
                dayCnt--;
                flag[i] = false;
            }
        }
    }
}
