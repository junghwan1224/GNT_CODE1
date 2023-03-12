package ps24337;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/24337
 * */
public class Main {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int idx = 0; //  높이가 가장 높은 건물의 위치
        int[] arr = new int[n];
        Arrays.fill(arr, 1);

        if(n + 1 < a + b) {
            System.out.println(-1);
        }
        else {
            /*
                가희(왼쪽)가 볼 수 있는 건물의 수가 1개라면, 가장 왼쪽에 있는 건물의 높이가 가장 높다는 뜻이므로
                인덱스 값은 0으로 설정
             */
            if(a == 1)
                idx = 0;
            // 가희가 볼 수 있는 건물의 수가 2개 이상이라면 가장 높은 건물의 위치는 (n - b)
            // (n - b) => 사전순으로 가장 앞선 순으로 배치해야 하기 때문에 가장 높은 건물은 최대한 뒷쪽에 배치
            else
                idx = n - b;

            // 가장 높은 건물의 높이 구함
            arr[idx] = Math.max(a, b);
            // 가장 높은 건물을 배치하였으므로, 배치할 건물의 수는 하나씩 줄어든다
            a--;
            b--;

            // 가희(왼쪽)가 볼 수 있는 건물 배치
            // 사전순으로 가장 앞선 순으로 건물 배치해야 하기 때문에, 가장 높은 건물 바로 왼쪽부터 높이 1씩 감소하면서 배치
            for(int i = idx - 1; i >= 0; i--) {
                if(a == 0)
                    break;
                arr[i] = a--;
            }

            // 단비(오른쪽)가 볼 수 있는 건물 배치
            // 사전순으로 가장 앞선 순으로 배치하기 위해서는 건물은 최대한 오른쪽부터 배치해야 한다
            // 가장 마지막 인덱스로부터 (b - 1)개의 건물 배치
            for(int i = n - b; i < n; i++) {
                if(b == 0)
                    break;
                arr[i] = b--;
            }


            for(int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
        }

    }

}
