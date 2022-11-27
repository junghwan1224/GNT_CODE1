package ps20437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* https://www.acmicpc.net/problem/20437
* 문자열 게임 2
* */
public class Main {
    static int T;
    static int MAX = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        for(int t = 0; t < T; t++ ) {
            char[] arr = br.readLine().toCharArray();
            int k = Integer.parseInt(br.readLine());
            int[] alphabet = new int[26];

            int min = MAX;
            int max = 0;

            // 문자열에 있는 알파벳 갯수 카운트
            for(int i = 0; i < arr.length; i++)
                alphabet[arr[i] - 'a']++;

            /*
            * 가장 짧은 문자열이던, 가장 긴 문자열이던 시작과 끝이 해당 문자로 된다(문제에 말장난이 있음)
            * */
            for(int i = 0; i < arr.length; i++) {
                // 현재 위치의 문자의 갯수가 k보다 적다면 안봐도 되므로 넘어간다
                if(alphabet[arr[i] - 'a'] < k)
                    continue;

                int cnt = 0;

                // i번째 부터 연속 구간 탐색
                for (int j = i; j < arr.length; j++) {
                    // j번째 문자가 i번째 문자와 같다면 갯수 증가
                    if(arr[i] == arr[j])
                        cnt++;

                    // 어떤 문자가 k개가 되는 순간 최댓값, 최솟값 갱신
                    if(cnt == k) {
                        max = Math.max(max, Math.abs(j - i + 1));
                        min = Math.min(min, Math.abs(j - i + 1));
                        break;
                    }
                }
            }

            if(min != MAX) {
                sb.append(min).append(" ").append(max).append("\n");
            }
            else
                sb.append(-1).append("\n");
        }

        System.out.println(sb);
    }
}
