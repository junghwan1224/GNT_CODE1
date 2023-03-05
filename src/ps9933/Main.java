package ps9933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/9933
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        boolean flag = false;
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(arr[i]);
            sb.reverse();
            String reverseStr = sb.toString();
            //System.out.println(reverseStr);

            for (int j = 0; j < N; j++) {
                if(arr[j].equals(reverseStr)) {
                    flag = true;
                    System.out.println(arr[j].length() + " " +  arr[j].substring(arr[j].length() / 2, arr[j].length() / 2 + 1));
                    break;
                }
            }

            if(flag)
                break;
        }
    }
}
