package ps17199;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/17199
 * Milk Factory
 * */
public class Main {
    static int N;
    static int[][] arr;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a - 1][b - 1] = 1;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 다른 지점을 통해서 i부터 j까지 갈 수 있으면 i와 j를 직접 갈 수 있다는 것으로 간주한다.
                    if(arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            // 각 노드에서 i까지 갈 수 있는지 확인
            for (int j = 0; j < N; j++) {
                if(arr[j][i] == 1)
                    cnt++;
            }

            // 본인 제외 나머지 노드에서 갈 수 있으면 노드 번호 저장
            if(cnt == N - 1) {
                result = i + 1;
                break;
            }
        }


        System.out.println(result);
    }
}
