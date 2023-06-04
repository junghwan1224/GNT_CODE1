package ps11501;

import java.lang.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.acmicpc.net/problem/11501
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        while(T > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int m = 0;
            long sum = 0;
            for (int i = N - 1; i >= 0; i--) {
                if(arr[i] > m)
                    m = arr[i];
                else
                    sum += (m - arr[i]);
            }

            sb.append(sum).append("\n");
            T--;
        }

        System.out.println(sb);
    }
}
