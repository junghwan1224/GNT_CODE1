package ps17089;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/17089
 * 세 친구
 * */
public class Main2 {
    static int N, M;
    static boolean[][] friend;
    static int[] friCnt;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        friend = new boolean[N + 1][N + 1];
        friCnt = new int[N + 1];
        result = -1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friend[a][b] = true;
            friend[b][a] = true;

            friCnt[a]++;
            friCnt[b]++;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(! friend[i][j])
                    continue;

                for (int k = 1; k <= N; k++) {
                    if(i == k && j == k)
                        continue;

                    if(friend[i][j] && friend[j][k] && friend[i][k]) {
                        int friSum = friCnt[i] + friCnt[j] + friCnt[k] - 6;
                        if(result == -1 || result > friSum)
                            result = friSum;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
