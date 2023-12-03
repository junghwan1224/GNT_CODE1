package ps12919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/12919
 * A와 B 2
 * */
public class Main2 {
    static String S, T;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        dfs(T);

        System.out.println(result);
    }

    public static void dfs(String target) {
        if(S.length() == target.length()) {
            if (S.equals(target))
                result = 1;
            return;
        }

        // 문자열의 뒤에 A를 추가한다.
        if(target.charAt(target.length() - 1) == 'A') {
            dfs(target.substring(0, target.length() - 1));
        }

        // 문자열의 뒤에 B를 추가하고 문자열을 뒤집는다.
        StringBuffer sb = new StringBuffer();
        sb.append(target);
        String t = sb.reverse().toString();
        if(t.charAt(t.length() - 1) == 'B') {
            dfs(t.substring(0, t.length() - 1));
        }
    }
}
