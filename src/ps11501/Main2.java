package ps11501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.acmicpc.net/problem/11501
 * 주식
 * */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        while(T > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int m = arr[N - 1];
            long val = 0;
            for (int i = N - 2; i >= 0; i--) {
                if(m > arr[i]) {
                    val += (m - arr[i]);
                }
                else
                    m = arr[i];
            }

            sb.append(val).append("\n");
            T--;
        }

        System.out.println(sb);
    }
}
