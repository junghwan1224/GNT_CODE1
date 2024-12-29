package ps1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/*
 * https://www.acmicpc.net/problem/1026
 * 보물
 * */
public class Main {
    static int N;
    static int[] A;
    static int[] B;
    static int S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Integer[] tmpA = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Integer[] tmpB = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(tmpA, Collections.reverseOrder());
        Arrays.sort(tmpB);

        for (int i = 0; i < N; i++) {
            S += tmpA[i] * tmpB[i];
        }

        System.out.println(S);
    }
}
