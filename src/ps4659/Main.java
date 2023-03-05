package ps4659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/4659
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuffer sb = new StringBuffer();

        while(! str.equals("end")) {
            boolean flag = true;
            char[] ch = str.toCharArray();

            // 모음 없으면 안됨
            if(str.indexOf("a") == -1 && str.indexOf("e") == -1 && str.indexOf("i") == -1
                && str.indexOf("o") == -1 && str.indexOf("u") == -1
            )
                flag = false;

            for (int i = 0; i < ch.length - 1; i++) {
                // 현재 탐색중인 문자가 모음이면
                if(ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u') {
                    // 연달아 세개 모음이면 안됨
                    if(ch[i + 1] == 'a' || ch[i + 1] == 'e' || ch[i + 1] == 'i' || ch[i + 1] == 'o' || ch[i + 1] == 'u') {

                        if(i + 2 < ch.length &&
                                (ch[i + 2] == 'a' || ch[i + 2] == 'e' || ch[i + 2] == 'i' || ch[i + 2] == 'o' || ch[i + 2] == 'u')
                        )
                            flag = false;
                    }
                }

                // 자음이면
                else {
                    // 연달아 세개 자음이면 안됨
                    if(! (ch[i + 1] == 'a' || ch[i + 1] == 'e' || ch[i + 1] == 'i' || ch[i + 1] == 'o' || ch[i + 1] == 'u')) {

                        if(i + 2 < ch.length &&
                            ! (ch[i + 2] == 'a' || ch[i + 2] == 'e' || ch[i + 2] == 'i' || ch[i + 2] == 'o' || ch[i + 2] == 'u')
                        )
                            flag = false;
                    }
                }

                if(ch[i] == 'o') {
                    if(ch[i + 1] == 'o' && (i + 2 < ch.length && ch[i + 2] != 'o'))
                        flag = true;
                }

                else if(ch[i] == 'e') {
                    if(ch[i + 1] == 'e' && (i + 2 < ch.length && ch[i + 2] != 'e'))
                        flag = true;
                }
                else {
                    if(ch[i] == ch[i + 1])
                        flag = false;
                }
            }

            sb.append("<")
                    .append(str)
                    .append(">")
                    .append(flag ? " is acceptable." : " is not acceptable.")
                    .append("\n")
                    ;

            str = br.readLine();
        }

        System.out.println(sb);
    }
}
