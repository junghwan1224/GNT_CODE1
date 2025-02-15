package ps1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1759
 * 암호 만들기
 * */
public class Main {
    static int L, C;
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    static char[] arr;
    static boolean[] visit;
    static ArrayList<String> result;
    static ArrayList<Character> word;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        arr = new char[C];
        int idx = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ')
                continue;
            arr[idx++] = str.charAt(i);
            if(idx == C)
                break;
        }
        Arrays.sort(arr);

        result = new ArrayList<>();
        word = new ArrayList<>();
        visit = new boolean[C];

        dfs(0);

        Collections.sort(result);
        StringBuffer sb = new StringBuffer();
        for(String s: result) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int idx) {
        if(word.size() == L) {
            StringBuilder sb = new StringBuilder();
            for (char c: word)
                sb.append(c);
            String convWord = sb.toString();
            if(isPossible(convWord))
                result.add(convWord);
            return;
        }

        for (int i = idx; i < C; i++) {
            if(! visit[i]) {
                visit[i] = true;
                word.add(arr[i]);
                dfs(i + 1);
                word.remove(word.size() - 1);
                visit[i] = false;
            }
        }
    }

    public static boolean isPossible(String str) {
        int vCnt = 0;
        int cCnt = 0;
        for (int i = 0; i < str.length(); i++) {
            for(char v: vowels) {
                if(v == str.charAt(i))
                    vCnt++;
            }
        }
        cCnt = str.length() - vCnt;

        return cCnt >= 2 && vCnt >= 1;
    }
}
