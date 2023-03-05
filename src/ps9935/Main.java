package ps9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

/*
 * https://www.acmicpc.net/problem/9935
 * */
public class Main {
    static String str;
    static String bombStr;
    static StringBuilder tmp;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        bombStr = br.readLine();
        int bombLen = bombStr.length();
        tmp = new StringBuilder(); // 스택처럼 사용하기 위한 문자열

        for (int i = 0; i < str.length(); i++) {
            tmp.append(str.charAt(i)); // 순차적으로 탐색하면서 하나씩 추가
            flag = true;

            // 스택(tmp)의 끝 문자와 폭발 문자열의 끝이 같을 경우
            if(tmp.charAt(tmp.length() - 1) == bombStr.charAt(bombLen - 1)) {
                // 폭발 문자열 길이가 더 크면 탐색 불가
                if(tmp.length() < bombLen)
                    continue;
                else {
                    // 스택의 끝 부분을 폭발 문자열과 비교
                    for (int j = 0; j < bombLen; j++) {
                        // 다르면 flag 값 false로 세팅
                        if(tmp.charAt(tmp.length() - bombLen + j) != bombStr.charAt(j)) {
                            flag = false;
                            break;
                        }
                    }
                }

                // 스택의 끝이 폭발 문자열과 같다면 해당 부분 제거
                if (flag) {
                    tmp = tmp.delete(tmp.length() - bombLen, tmp.length());
                }
            }
        }

        System.out.println(tmp.length() > 0 ? tmp : "FRULA");
    }
}
