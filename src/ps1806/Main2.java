package ps1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1806
 * 부분합
 * */
public class Main2 {
    static int N, S;
    static int MAX = 987654321;
    static int result = MAX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        int s = 0;
        int e = 0;

        while(s <= e) {

            if(sum >= S) {
                //System.out.println(e + ", " + s + ", " + sum);
                result = Math.min(result, e - s);
                sum -= arr[s++];
            }
            else if(e >= N)
                break;
            else if(sum < S) {
                sum += arr[e++];
            }

        }

        System.out.println(result == MAX ? 0 : result);
    }
}
