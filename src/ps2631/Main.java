package ps2631;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.acmicpc.net/problem/2631
 * */
public class Main {
    static int N;
    static int[] arr;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        d = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 가장 큰 증가하는 부분 수열 구하기
        Arrays.fill(d, 1); // 초기값은 1

        int max = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    if(d[i] < d[j] + 1)
                        d[i] = d[j] + 1;
                }
            }

            max = Math.max(max, d[i]);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(d[i] + " ");
            //max = Math.max(max, d[i]);
        }

        //System.out.println(N - max);
    }
}
