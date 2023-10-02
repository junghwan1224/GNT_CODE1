package ps1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/1522
 * 문자열 교환
 * */
public class Main2 {
    static int MAX = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int result = MAX;
        int cntA = 0;

        /*
        * a 갯수만큼 슬라이딩 윈도우 진행
        * 해당 범위 안에 있는 b의 갯수가 교환 대상의 수
        * 범위를 옮겨가며 교환 대상 수를 구한 뒤 최솟값 갱신
        * */
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 'a')
                cntA++;
        }

        for (int i = 0; i < arr.length; i++) {
            int cnt = 0;
            for (int j = i; j < i + cntA; j++) {
                if(arr[j % arr.length] == 'b')
                    cnt++;
            }

            result = Math.min(result, cnt);
        }

        System.out.println(result);
    }
}
