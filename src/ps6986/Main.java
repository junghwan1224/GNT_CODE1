package ps6986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/6986
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        Arrays.sort(arr);

        double result = 0;
        for (int i = k; i < n - k; i++) {
            result += arr[i];
        }
        String res = String.format("%.2f", Math.round((result / (n - k - k)) * 100) / 100.0);
        System.out.println(res);

        for (int i = 0; i < k; i++) {
            arr[i] = arr[k];
            arr[n - k + i] = arr[n - k - 1];
        }

        result = 0;
        for (int i = 0; i < n; i++) {
            result += arr[i];
        }

        res = String.format("%.2f", Math.round((result / n) * 100) / 100.0);
        System.out.println(res);
    }
}
