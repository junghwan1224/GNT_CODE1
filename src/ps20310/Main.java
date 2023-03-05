package ps20310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.acmicpc.net/problem/20310
 * */
public class Main {
    static char[] str;
    static int zeroCnt;
    static int oneCnt;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine().toCharArray();

        for (int i = 0; i < str.length; i++) {
            if(str[i] == '0') zeroCnt++;
            else oneCnt++;
        }
        zeroCnt /= 2;
        oneCnt /= 2;

        check = new boolean[str.length];
        Arrays.fill(check, true);

        /*
        * 1은 앞에서 순회하면서 최대한 제거
        * 0은 뒤에서 순회하면서 최대한 제거
        * */

        for (int i = 0; i < str.length; i++) {
            if(oneCnt > 0 && str[i] == '1') {
                oneCnt--;
                check[i] = false;
            }
        }

        for (int i = str.length - 1; i >= 0; i--) {
            if(zeroCnt > 0 && str[i] == '0') {
                zeroCnt--;
                check[i] = false;
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            if(check[i])
                sb.append(str[i]);
        }

        System.out.println(sb);
    }
}
