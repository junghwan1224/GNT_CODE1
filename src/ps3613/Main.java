package ps3613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferOverflowException;
import java.util.ArrayList;

/*
 * https://www.acmicpc.net/problem/3613
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] chars = str.toCharArray();
        int len = chars.length;
        String result = null;

        // c++ 변수명
        if(str.indexOf("_") != -1) {
            // 첫 자리 또는 끝 자리에 _ 가 있다면 오류
            if(chars[0] == '_' || chars[len - 1] == '_') {
                System.out.println("Error!");
                return;
            }

            for(int i = 0; i < len; i++) {
                // 대문자가 있다면 오류
                if(Character.isUpperCase(chars[i])) {
                    System.out.println("Error!");
                    return;
                }
                // _ 가 연달아 붙어있다면 오류
                else if(i + 1 < len && (chars[i] == '_' && chars[i + 1] == '_')) {
                    System.out.println("Error!");
                    return;
                }
            }

            for(int i = 0; i < len; i++) {
                // _ 뒤에 있는 문자를 대문자로 변환
                if(chars[i] == '_') {
                    if(i + 1 < len) {
                        chars[i + 1] = Character.toUpperCase(chars[i + 1]);
                    }
                }
            }

            // 변환 작업이 끝난 후 _ 문자 제거
            result = String.valueOf(chars);
            result = result.replaceAll("_", "");
        }

        // java 변수명
        else {
            // 첫 번째 문자가 대문자면 오류
            if(Character.isUpperCase(chars[0])) {
                System.out.println("Error!");
                return;
            }

            for(int i = 0; i < len; i++) {
                // _ 가 있다면 오류
                if(chars[i] == '_') {
                    System.out.println("Error!");
                    return;
                }
            }

            // c++ 변수명으로 바꿔주기 위해 _ 문자를 넣어줄 위치를 저장하는 리스트
            ArrayList<Integer> upperPos = new ArrayList<>();
            for(int i = 0; i < len; i++) {
                // 탐색중인 문자가 대문자면 해당 위치값 저장
                if(Character.isUpperCase(chars[i])) {
                    upperPos.add(i);
                }
            }

            // _ 문자를 넣고 소문자 변환 작업이 필요한 경우
            // 해당 위치에 _ 문자 추가 및 대문자를 소문자로 변환
            if(upperPos.size() > 0) {
                // 대문자 이전까지의 문자열에 _ 를 더해주고, 대문자는 소문자로 변환하여 _ 뒤에 추가
                result = str.substring(0, upperPos.get(0)) + "_"
                        + str.substring(upperPos.get(0), upperPos.get(0) + 1).toLowerCase();

                for (int i = 1; i < upperPos.size(); i++) {
                    result += str.substring(upperPos.get(i - 1) + 1, upperPos.get(i)) + "_"
                            + str.substring(upperPos.get(i), upperPos.get(i) + 1).toLowerCase();
                }

                // 위 변환 작업이 끝나고 마지막 대문자 뒤에 남아있는 문자열을 붙여주면 변환 작업 끝
                result += str.substring(upperPos.get(upperPos.size() - 1) + 1, str.length());
            }
            // 대문자가 없다면 문자 그대로 출력
            else
                result = str;
        }

        System.out.println(result);
    }
}
