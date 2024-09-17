package ps4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/4485
 * 녹색 옷 입은 애가 젤다지?
 * */
class Node2 {
    int y;
    int x;

    public Node2(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main2 {
    static int N;
    static int[][] arr;
    static int[] dy = {0 , 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static StringBuffer sb;
    static int MAX = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb = new StringBuffer();
        int cnt = 1;

        while(N != 0) {
            arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] d = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(d[i], MAX);
            }
            d[0][0] = arr[0][0];

            Queue<Node2> que = new LinkedList<>();
            que.add(new Node2(0, 0));

            while(! que.isEmpty()) {
                Node2 cur = que.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];

                    if(0 <= ny && ny < N && 0 <= nx && nx < N) {
                        if(d[ny][nx] > d[cur.y][cur.x] + arr[ny][nx]) {
                            d[ny][nx] = d[cur.y][cur.x] + arr[ny][nx];
                            que.add(new Node2(ny, nx));
                        }
                    }
                }
            }

            sb.append("Problem ").append(cnt++).append(": ").append(d[N - 1][N - 1]).append("\n");

            N = Integer.parseInt(br.readLine());
        }

        System.out.println(sb);
    }
}
