package ps9372;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/9372
 * 상근이의 여행
 * */

class Node {
    int e;

    public Node(int e) {
        this.e = e;
    }
}
public class Main {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        while(T-- > 0) {
            int n, m;

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];
            boolean[] visit = new boolean[n];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a - 1][b - 1] = 1;
                arr[b - 1][a - 1] = 1;
            }

            Deque<Node> deq = new LinkedList<>();
            visit[0] = true;
            deq.add(new Node(0));
            int cnt = 0;

            while(! deq.isEmpty()) {
                Node cur = deq.poll();
                cnt++;

                for (int i = 0; i < n; i++) {
                    if(arr[cur.e][i] == 1 && ! visit[i]) {
                        visit[i] = true;
                        deq.add(new Node(i));
                    }
                }
            }
            sb.append(cnt - 1).append("\n");
        }

        System.out.println(sb);
    }
}
