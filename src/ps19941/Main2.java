package ps19941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/19941
 * 햄버거 분배
 * */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        boolean[] flag = new boolean[N];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if(arr[i] == 'P') {
                for (int j = i - K; j <= i + K; j++) {
                    if(0 <= j && j < N) {
                        if(arr[j] == 'H' && ! flag[j]) {
                            flag[j] = true;
                            cnt++;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
