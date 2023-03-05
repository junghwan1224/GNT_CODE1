package ps1205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1205
 * */
public class Main {
    static int N, T, P;
    static ArrayList<Integer> list;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        result = -1;

        if(N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
        }

        if(N == 0) { // 리스트에 점수가 없으면 1등이다
            System.out.println(1);
        }

        else {
            // 리스트에 점수가 꽉 찼고, 마지막 점수보다 작거나 같으면 들어갈 수 없으므로 -1 출력
            if(N == P && list.get(N - 1) >= T) {
                System.out.println(-1);
                return;
            }

            // 리스트에 들어갈 수 있는 경우 등수 구하기
            result = N + 1; // 초기값은 가장 끝에 들어오는 경우에 해당하는 등수
            for (int i = 0; i < N; i++) {
                int score = list.get(i);
                if(score <= T) {
                    result = i + 1;
                    break;
                }
            }

            System.out.println(result);
        }
    }
}
