package ps1515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/1515
 * 수 이어 쓰기
 * */
public class Main {

    static char[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nums = br.readLine().toCharArray();

        int n = 1; // 1부터 시작해서 하나씩 늘려가면서 입력값 하나씩 비교
        int idx = 0;
        boolean flag = false;

        while(idx < nums.length) {
            // n의 각 자릿수 비교를 위해 문자 배열로 변환
            char[] temp = String.valueOf(n).toCharArray();
            for (int i = 0; i < temp.length; i++) {
                // n의 각 자릿수와 비교하면서, 같으면 입력받은 값을 탐색하는 인덱스를 하나씩 늘린다.
                // 인덱스를 늘려가면서 다음 자릿수도 같은지 확인
                if(temp[i] == nums[idx]) {
                    idx++;
                    // 인덱스가 마지막에 도달하면 모든 루프를 종료
                    if(idx == nums.length) {
                        flag = true;
                        break;
                    }
                }
            }

            if(flag)
                break;
            n++;
        }

        System.out.println(n);
    }
}
