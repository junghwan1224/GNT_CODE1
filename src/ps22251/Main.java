package ps22251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/22251
 * 빌런 호석
 * */
public class Main {
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
    static int[][] arr = {
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
        N = Integer.parseInt(st.nextToken()); // 층수 1 ~ N층
        K = Integer.parseInt(st.nextToken()); // 디스플레이에 표시되는 자릿수
        P = Integer.parseInt(st.nextToken()); // 반전시킬 수 있는 최대 수. 1 ~ P
        X = Integer.parseInt(st.nextToken()); // 현재 멈춰있는 층

        for (int i = 1; i <= N; i++) {
            if(i == X)
                continue;

            int target = i; // 바꾸어야 할 층
            int start = X; // 시작점 (X)
            int cnt = 0; // 반전시킨 LED 수

            for(int j = 1; j <= K; j++) {
                for(int n = 0; n < 7; n++) {
                    // 각 자릿수별로 상태가 다른 LED 칸의 갯수 카운트
                    if(arr[start % 10][n] != arr[target % 10][n]) {
                        cnt++;
                    }
                }

                target /= 10;
                start /= 10;
            }

            if(cnt <= P)
                result++;
        }

        System.out.println(result);
    }
}
