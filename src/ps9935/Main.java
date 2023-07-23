package ps9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/9935
 * 문자열 폭발
 * */
public class Main {
    static String target;
    static String bomb;
    static int targetLen;
    static int bombLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = br.readLine();
        bomb = br.readLine();
        targetLen = target.length();
        bombLen = bomb.length();
        StringBuilder tmp = new StringBuilder();

        for (int i = 0; i < targetLen; i++) {
            // 임시 문자열이 폭발 문자열 길이 이상으로 채워져 있을 경우
            if(tmp.length() >= bombLen) {
                // 임시 문자열의 끝에서부터 폭발 문자열 길이만큼 비교 후, 같으면 해당 부분 제거
                String compStr = tmp.substring(tmp.length() - bombLen, tmp.length());
                if(compStr.equals(bomb)) {
                    tmp.delete(tmp.length() - bombLen, tmp.length());
                }
            }

            tmp.append(target.substring(i, i + 1));
        }

        // 탐색이 끝난 후 마지막에 남아있는 폭발 문자열 제거
        if(tmp.length() >= bombLen) {
            String compStr = tmp.substring(tmp.length() - bombLen, tmp.length());
            if(compStr.equals(bomb)) {
                tmp.delete(tmp.length() - bombLen, tmp.length());
            }
        }

        System.out.println(tmp.length() == 0 ? "FRULA" : tmp);
    }
}
