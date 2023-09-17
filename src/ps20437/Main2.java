package ps20437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/20437
 * 문자열 게임 2
 * */
public class Main2 {
    static int T;
    static int MAX = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        while(T > 0) {
            char[] arr = br.readLine().toCharArray();
            int k = Integer.parseInt(br.readLine());
            int[] alpha = new int[26];
            int min = MAX;
            int max = 0;
            boolean flag = false;

            for (int i = 0; i < arr.length; i++) {
                alpha[arr[i] - 'a']++;
            }

            for (int i = 0; i < arr.length; i++) {
                if(alpha[arr[i] - 'a'] >= k) {
                    flag = true;
                    int cnt = 0;
                    for (int j = i; j < arr.length; j++) {
                        if(arr[i] == arr[j])
                            cnt++;

                        if(cnt == k) {
                            int len = (j - i) + 1;
                            min = Math.min(min, len);
                            max = Math.max(max, len);
                            break;
                        }
                    }
                }
            }

            if(flag)
                sb.append(min).append(" ").append(max).append("\n");
            else
                sb.append(-1).append("\n");

            T--;
        }

        System.out.println(sb);
    }
}
