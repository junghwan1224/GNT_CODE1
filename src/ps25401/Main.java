package ps25401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.acmicpc.net/problem/25401
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int result = 987654321;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if((arr[j] - arr[i]) % (j - i) != 0)
                    continue;
                int d = (arr[j] - arr[i]) / (j - i); // 공차
                int firstVal = arr[i] - (i * d); // 첫 항

                int cnt = 0;
                for (int k = 0; k < n; k++) {
                    if(arr[k] != firstVal)
                        cnt++;
                    firstVal += d;
                }

                result = Math.min(result, cnt);
            }
        }

        System.out.println(result);
    }
}

/*
입력되는 N개의 숫자는 최대 500개입니다. 따라서, 우리는 두 숫자를 기준으로 설정하는 중첩 반복문을 활용할 수 있습니다.
그리고 2개의 숫자를 기준으로 설정하면 다음은 간단합니다. 공차가 정수로 만들어질 수 있는지 확인한 다음,
만들 수 있다면 첫 항을 구한 다음, 현재 수열과 비교해서 다른 숫자의 개수를 세면 됩니다.
두 수를 사용해 만들 수 있는 모든 수열을 확인하고 그 중 최솟값을 구하면 우리가 원하는 결괏값을 얻게 됩니다.
* */