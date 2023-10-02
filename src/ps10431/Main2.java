package ps10431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.acmicpc.net/problem/10431
 * 줄세우기
 * */
public class Main2 {
    static int MAX = 987654321;
    static int LENGTH = 21;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        while(P > 0) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int cnt = 0;

            // 1 ~ i-1번째 사람들 중에서 i번째 사람보다 키가 큰 사람들 중 제일 작은 사람의 위치를 찾아야 한다.
            for (int i = 1; i < LENGTH; i++) {
                int idx = i;
                int m = MAX;

                for (int j = 1; j < i; j++) {
                    if(arr[i] < arr[j] && m > arr[j]) {
                        m = arr[j];
                        idx = j;
                    }
                }

                if(idx != i) {
                    int tmp = arr[i];
                    for (int j = i - 1; j >= idx; j--) {
                        arr[j + 1] = arr[j];
                        cnt++;
                    }
                    arr[idx] = tmp;
                }
            }

            sb.append(arr[0]).append(" ").append(cnt).append("\n");

            P--;
        }

        System.out.println(sb);
    }

}
