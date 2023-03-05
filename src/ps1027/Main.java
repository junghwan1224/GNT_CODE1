package ps1027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.acmicpc.net/problem/1027
 * */
public class Main {
    static int n;
    static long[] arr;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        result = new int[n];

        for (int i = 0; i < n; i++) {
            double maxVal = -999999999;

            // 현재 탐색중인 건물에서 오른쪽을 바라볼 때, 기울기가 현재 저장된 max값보다 큰 위치의 건물 확인
            long y = arr[i];
            int x = i;
            for (int j = i + 1; j < n; j++) {
                double curVal = getVal(i, arr[i], j, arr[j]);
                System.out.println(curVal);
                if(maxVal < curVal) {
                    result[i]++;
                    maxVal = curVal;
                }
            }

            // 현재 탐색중인 건물에서 왼쪽을 바라볼 때, 기울기가 현재 저장된 min값보다 작은 위치의 건물 확인
            double minVal = 999999999;
            for (int j = i - 1; j >= 0; j--) {
                double curVal = getVal(i, arr[i], j, arr[j]);
                if(minVal > curVal) {
                    result[i]++;
                    minVal = curVal;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, result[i]);
            System.out.print(result[i] + " ");
        }

        //System.out.println(max);

        /*
        * in:
            7
            1 1000000000 1000000000 1 1000000000 1000000000 1

          out:
            3
        * */
    }

    // 두 점의 좌표를 이용하여 기울기 구하기
    public static double getVal(int x1, long y1, int x2, long y2) {
        return ((double)y1 - y2) / (x1 - x2);
    }
}
