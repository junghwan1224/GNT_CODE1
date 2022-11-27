package ps2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2110
 * 공유기 설치
 * */
public class Main {
    static int n;
    static int c;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 1; // 공유기를 설치할 수 있는 최소 거리
        int right = arr[n - 1] - arr[0]; // 주어진 입력에 대해, 공유기를 설치할 수 있는 최대 거리
        int result = 0;

        while(left <= right) {
            int mid = (left + right) / 2;

            int cnt = 1; // 공유기 설치 갯수, 첫 번째 집에 공유기 설치하고 탐색 진행
            int start = arr[0];
            for (int i = 1; i < n; i++) {
                // 공유기가 설치된 집(start)으로부터 현재 탐색중인 집까지의 거리가 mid 이상이면 공유기 설치
                if(arr[i] - start >= mid) {
                    cnt++;
                    start = arr[i]; // 공유기를 설치하고나면 거리를 측정하는 집(공유기가 설치된 집)의 기준 갱신
                }
            }

            // 공유기가 c보다 적게 설치됐다면 거리를 줄인다
            if(cnt < c) {
                right = mid - 1;
            }
            // 공유기가 c이상 설치됐다면 거리를 늘린다
            else {
                result = mid;
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}

/*
1. 공유기 설치 좌표들을 오름차순으로 정렬합니다.
2. 공유기를 설치할 수 있는 최소 간격과 최대 간격을 구한 뒤, 공유기를 가장 공평하게 설치할 수 있는 간격(mid)을 구합니다.
3. 첫 번째 집에 공유기를 설치한 뒤, 첫 번째 집에서 나머지 집들 간의 간격을 확인하며, mid 이상으로 떨어져 있는 집을 탐색합니다.
4. 첫 번째 집으로부터 mid 이상 떨어진 집을 찾은 경우, 해당 집에 공유기를 설치한 뒤, 해당 집 기준으로 다시 mid 만큼 떨어져있는 집을 탐색합니다.
5. 모든 집을 탐색했다면, 공유기 설치 간격을 이분법을 사용해 갱신합니다.
6. 현재까지 설치한 공유기의 개수가 아직 C개 이하라면, 기존 간격이 너무 크다는 의미이므로, 기존 간격보다 더 작은 간격으로 갱신합니다.
7. 현재까지 설치한 공유기의 개수가 C개 이상이라면, 기존 간격이 너무 작다는 의미이므로, 기존 간격보다 더 큰 간격으로 갱신합니다.
8. 가능한 모든 간격들을 탐색할 때까지 이분법 과정을 3번~5번 반복합니다.
9. 탐색된 최대 간격을 반환합니다.
ref by. https://wooono.tistory.com/404
* */