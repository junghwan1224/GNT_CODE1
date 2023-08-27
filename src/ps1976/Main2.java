package ps1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1976
 * 여행 가자
 * */
public class Main2 {
    static int N, M;
    static int[] target;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int isConnected = Integer.parseInt(st.nextToken());
                if(i != j && isConnected == 1) {
                    union(i, j);
                }
            }
        }

        target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean flag = true;
        int par = parent[target[0]];
        for (int i = 1; i < M; i++) {
            if(par != parent[target[i]]) {
                flag = false;
                break;
            }
        }

        System.out.println(flag ? "YES" : "NO");
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }

    public static int find(int n) {
        if(n == parent[n])
            return n;
        else {
            int x = find(parent[n]);
            parent[n] = x;
            return x;
        }
    }
}
