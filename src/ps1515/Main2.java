package ps1515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/1515
 * 수 이어 쓰기
 * */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int n = 1;
        int idx = 0;

        while(idx < arr.length) {
            char[] tmp = Integer.toString(n).toCharArray();

            for (int i = 0; i < tmp.length; i++) {
                if(tmp[i] == arr[idx]) {
                    idx++;
                    if(idx == arr.length)
                        break;
                }
            }
            n++;
        }

        System.out.println(n - 1);
    }
}
