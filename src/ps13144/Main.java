package ps13144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.acmicpc.net/problem/13144
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] flag = new boolean[100001];
        int right = 0;
        long cnt = 0;

        for (int left = 0; left < n; left++) {
            while(right < n && ! flag[arr[right]]) {
                flag[arr[right]] = true;
                right++;
            }

            cnt += (right - left);
            flag[arr[left]] = false;
        }

        System.out.println(cnt);

        /*
        * n = 3
        * 1 2 2
        * 위: 4
        * 아래: 6
        * */

//        int left = 0;
//        while(left <= right && right < n) {
//            if((left != right) && (arr[left] == arr[right])) {
//                left++;
//            }
//            else if((arr[left] != arr[right]) || ((left == right) && (arr[left] == arr[right]))) {
//                cnt += (right - left + 1);
//                right++;
//            }
//        }
//
//        System.out.println(cnt);
    }
}
