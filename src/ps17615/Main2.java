package ps17615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/17615
 * 볼 모으기
 * */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int cntR = 0;
        int cntB = 0;
        int result1 = 0;
        int result2 = 0;
        boolean flagR = false;
        boolean flagB = false;

        // 첫R 끝B
        /*
        * RBBBRBRRR
        * R을 앞으로 몰아줄 경우
        * 첫 번째 R은 아직 B가 나오지 않았으므로 카운트X
        * 2 ~ 4 번째 B는 카운트X
        * 이후 R들은 카운트
        * */
        for (int i = 0; i < n; i++) {
            if(! flagB && arr[i] == 'B')
                flagB = true;

            if(flagB) {
                if(arr[i] == 'R')
                    cntR++;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if(! flagR && arr[i] == 'R')
                flagR = true;

            if(flagR) {
                if(arr[i] == 'B')
                    cntB++;
            }
        }
        result1 = (cntR < cntB) ? cntR : cntB;

        // 첫B 끝R
        cntR = 0;
        cntB = 0;
        flagR = false;
        flagB = false;
        for (int i = 0; i < n; i++) {
            if(! flagR && arr[i] == 'R')
                flagR = true;

            if(flagR) {
                if(arr[i] == 'B')
                    cntB++;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if(! flagB && arr[i] == 'B')
                flagB = true;

            if(flagB) {
                if(arr[i] == 'R')
                    cntR++;
            }
        }
        result2 = (cntR < cntB) ? cntR : cntB;

        System.out.println((result1 < result2) ? result1 : result2);
    }
}
