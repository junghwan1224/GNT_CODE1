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
            if(chars[0] == '_' || chars[len - 1] == '_') {
                System.out.println("Error!");
                return;
            }

            for(int i = 0; i < len; i++) {
                if(Character.isUpperCase(chars[i])) {
                    System.out.println("Error!");
                    return;
                }
                else if(i + 1 < len && (chars[i] == '_' && chars[i + 1] == '_')) {
                    System.out.println("Error!");
                    return;
                }
            }

            for(int i = 0; i < len; i++) {
                if(chars[i] == '_') {
                    if(i + 1 < len) {
                        chars[i + 1] = Character.toUpperCase(chars[i + 1]);
                    }
                }
            }

            result = String.valueOf(chars);
            result = result.replaceAll("_", "");
        }

        // java 변수명
        else {
            if(Character.isUpperCase(chars[0])) {
                System.out.println("Error!");
                return;
            }

            for(int i = 0; i < len; i++) {
                if(chars[i] == '_') {
                    System.out.println("Error!");
                    return;
                }
            }

            ArrayList<Integer> upperPos = new ArrayList<>();
            for(int i = 0; i < len; i++) {
                if(Character.isUpperCase(chars[i])) {
                    upperPos.add(i);
                }
            }

            if(upperPos.size() > 0) {
                result = str.substring(0, upperPos.get(0)) + "_"
                        + str.substring(upperPos.get(0), upperPos.get(0) + 1).toLowerCase();

                for (int i = 1; i < upperPos.size(); i++) {
                    result += str.substring(upperPos.get(i - 1) + 1, upperPos.get(i)) + "_"
                            + str.substring(upperPos.get(i), upperPos.get(i) + 1).toLowerCase();
                }

                result += str.substring(upperPos.get(upperPos.size() - 1) + 1, str.length());
            }
            else
                result = str;
        }

        System.out.println(result);
    }
}
