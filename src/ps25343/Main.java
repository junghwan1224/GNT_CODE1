package ps25343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.acmicpc.net/problem/25343
 * */
public class Main {
    static int N;
    static int[][] arr;
    static int[][] d;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        d = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(d[i], 1);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k <= i; k++) {
                    for (int l = 0; l <= j; l++) {
                        if(arr[i][j] > arr[k][l]) {
                            d[i][j] = Math.max(d[i][j], d[k][l] + 1);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result = Math.max(result, d[i][j]);
                //System.out.print(d[i][j] + " ");
            }
            //System.out.println();
        }

        System.out.println(result);
    }
}
