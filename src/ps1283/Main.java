package ps1283;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * https://www.acmicpc.net/problem/1283
 * 단축키 지정
 * */
public class Main {
    static int N;
    static Map<Character, String> shortcut; // 단축키 저장
    static String[] options;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        shortcut = new HashMap<>();
        options = new String[N];
        for (int i = 0; i < N; i++)
            options[i] = br.readLine();

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < N; i++) {
            String[] words = options[i].split(" ");
            String str = "";
            boolean flag = false;

            for (int j = 0; j < words.length; j++) {
                char chr = words[j].charAt(0);

                // 각 단어의 첫 번째 글자가 단축키 지정이 안되어있다면
                // 해당 키를 옵션의 단축키로 지정하고 다음 옵션 탐색을 실시한다.
                if(! (shortcut.containsKey(Character.toLowerCase(chr))
                        || shortcut.containsKey(Character.toUpperCase(chr))
                    ) && ! flag
                ) {
                    shortcut.put(chr, options[i]);
                    str += "[" + words[j].charAt(0) + "]" + words[j].substring(1) + " ";
                    flag = true;
                }
                else {
                    str += words[j] + " ";
                }
            }

            if(flag) {
                sb.append(str).append("\n");
                continue;
            }

            // 각 단어의 첫 번째 글자가 이미 등록이 되어 있다면,
            // 해당 옵션의 스펠링을 순차적으로 탐색하면서 옵션을 등록한다.
            str = "";
            boolean check = false;
            for (int j = 0; j < options[i].length(); j++) {
                char chr = options[i].charAt(j);

                if(! (shortcut.containsKey(Character.toLowerCase(chr))
                        || shortcut.containsKey(Character.toUpperCase(chr))
                    ) && chr != ' ' &&  ! check
                ) {
                    shortcut.put(chr, options[i]);
                    str += "[" + chr + "]";
                    check = true;
                }
                else {
                    str += chr;
                }
            }

            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }
}
