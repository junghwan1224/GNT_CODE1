package ps1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
 * https://www.acmicpc.net/problem/1976
 * 여행 가자
 * */
public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static int[] plan;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[N + 1][N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        StringTokenizer st = null;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < N + 1; j++) {
                int isConnected = Integer.parseInt(st.nextToken());
                if(i != j && isConnected == 1) {
                    union(i, j);
                }
            }
        }
        plan = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean flag = true;
        int p = parent[plan[0]];
        /*
        * 유니온 파인드 진행 후, 계획에 있는 각 여행지마다 부모가 같은지 확인, 다르면 여행 불가
        * */
        for (int i = 1; i < M; i++) {
            if(p != parent[plan[i]]) {
                flag = false;
                break;
            }
        }

        System.out.println(flag ? "YES" : "NO");
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

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }
}
