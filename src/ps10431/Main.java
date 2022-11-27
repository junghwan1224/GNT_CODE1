package ps10431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.acmicpc.net/problem/10431
 * 줄세우기
 * */

/*
1
1 20 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 1
* */
public class Main {
    static int P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        P = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        for (int p = 0; p < P; p++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int cnt = 0;
            int max = getMax(arr) + 1;

            for (int i = 2; i <= 20; i++) {
                int m = max;
                int idx = i;

                //for(int j = i - 1; j >= 1; j--) {
                for(int j = 1; j < i; j++) {
                    // 1 ~ i-1번째 사람들 중에서 i번째 사람보다 키가 큰 사람들 중 제일 작은 사람의 위치를 찾아야 한다.
                    //if(arr[j] > arr[i]) {
                    if(arr[j] > arr[i] && arr[j] < m) {
                        idx = j;
                        m = arr[j];
                    }
                }

                if(idx != i) {
                    int tmp = arr[i];
                    for(int k = i - 1; k >= idx; k--) {
                        arr[k + 1] = arr[k];
                        cnt++;
                    }
                    arr[idx] = tmp;
                    //cnt += i - idx;
                }
            }

            sb.append(arr[0]).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    public static int getMax(int[] arr) {
        int max = 0;
        for (int i = 1; i <= 20; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
