package ps16945;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/16945
 * 매직 스퀘어로 변경하기
 * */
public class Main {
    static int[] arr;
    static int N = 9;
    static int MAX = 987654321;
    static int SUM = 15;
    static int result = MAX;
    static ArrayList<Integer> list;
    static boolean[] flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[N];
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }
        }

        list = new ArrayList<>();
        flag = new boolean[N + 1];

        dfs(0);

        System.out.println(result);
    }

    // 1 ~ 9 까지 모든 경우에 대해 배치 후 입력받은 배열과 비용 계산 및 최솟값 갱신
    public static void dfs(int n) {
        if(n == N) {
            if(isMagicSquare(list)) {
                int[] a = list.stream().mapToInt(i -> i).toArray();
                int sum = 0;
                for (int i = 0; i < N; i++) {
                    sum += Math.abs(a[i] - arr[i]);
                }
                result = Math.min(result, sum);
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (flag[i])
                continue;

            flag[i] = true;
            list.add(i);
            dfs(n + 1);
            list.remove(list.size() - 1);
            flag[i] = false;
        }
    }

    public static boolean isMagicSquare(ArrayList<Integer> l) {
        int[] tmp = l.stream().mapToInt(i->i).toArray();
        if(tmp[0] + tmp[1] + tmp[2] != SUM)
            return false;
        if(tmp[3] + tmp[4] + tmp[5] != SUM)
            return false;
        if(tmp[6] + tmp[7] + tmp[8] != SUM)
            return false;

        if(tmp[0] + tmp[3] + tmp[6] != SUM)
            return false;
        if(tmp[1] + tmp[4] + tmp[7] != SUM)
            return false;
        if(tmp[2] + tmp[5] + tmp[8] != SUM)
            return false;

        if(tmp[0] + tmp[4] + tmp[8] != SUM)
            return false;
        if(tmp[2] + tmp[4] + tmp[6] != SUM)
            return false;
        
        return true;
    }
}
