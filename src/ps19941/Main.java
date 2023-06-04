package ps19941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/19941
 * 햄버거 분배
 * */
public class Main {
    static int N, K;
    static char[] arr;
    static boolean[] check;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = br.readLine().toCharArray();
        check = new boolean[N];

        for (int i = 0; i < N; i++) {
            if(arr[i] == 'H')
                continue;

            for (int j = i - K; j <= i + K; j++) {
                if(j < 0)
                    continue;
                if(j >= N)
                    break;
                if(arr[j] == 'P')
                    continue;
                if(! check[j]) {
                    check[j] = true;
                    result++;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
