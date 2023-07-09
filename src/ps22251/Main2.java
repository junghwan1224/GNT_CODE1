package ps22251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/22251
 * 빌런 호석
 * */
public class Main2 {
    static int N, K, P, X;
    /*
         2
         ㅡ
      1 |  | 3
         ㅡ 4
      5 |  |7
         ㅡ
         6
    * */
    static int[][] dial = {
            {1, 1, 1, 0, 1, 1, 1},
            {0, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 1, 1},
            {1, 0, 1, 1, 0, 0, 1},
            {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 1},
            {0, 1, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1}
    };
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            if(i == X)
                continue;

            int tmp = i;
            int xx = X;
            int cnt = 0;

            for (int j = 0; j < K; j++) {
                for (int k = 0; k < 7; k++) {
                    if(dial[tmp % 10][k] != dial[xx % 10][k])
                        cnt++;
                }

                tmp /= 10;
                xx /= 10;
            }

            if(cnt <= P)
                result++;
        }

        /*for (int i = 0; i < K; i++) {
            int num = X % 10;
            for (int j = 0; j < 9; j++) {
                int cnt = 0;
                for (int k = 0; k < 7; k++) {
                    if(dial[num][k] != dial[j][k])
                        cnt++;
                }

                if(1 <= cnt && cnt <= P)
                    result++;
            }
            X /= 10;
        }*/

        System.out.println(result);
    }
}
