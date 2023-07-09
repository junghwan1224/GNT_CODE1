package ps2668;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * https://www.acmicpc.net/problem/2668
 * 숫자고르기
 * */
public class Main2 {
    static int N;
    static int[] arr;
    static boolean[] visit;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visit = new boolean[N + 1];
        list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            visit[i] = true;
            dfs(i, arr[i]);
            visit = new boolean[N + 1];
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (Integer i: list) {
            System.out.println(i);
        }
    }

    public static void dfs(int start, int n) {
        if(visit[n]) {
            if(start == n) {
                list.add(n);
            }
            return;
        }

        visit[n] = true;
        dfs(start, arr[n]);
    }
}
