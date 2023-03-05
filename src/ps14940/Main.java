package ps14940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/14940
 * */
class Node {
    int y;
    int x;
    int d;

    public Node(int y, int x, int d) {
        this.y = y;
        this.x = x;
        this.d = d;
    }
}

public class Main {
    static int n, m;
    static int[][] arr;
    static int[][] result;
    static Queue<Node> que;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        result = new int[n][m];
        que = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], -1);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) {
                    que.add(new Node(i, j, 0));
                    result[i][j] = 0;
                }
                else if(arr[i][j] == 0) {
                    result[i][j] = 0;
                }
            }
        }

        while(! que.isEmpty()) {
            Node cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if(0 <= ny && ny < n && 0 <= nx && nx < m) {
                    if(arr[ny][nx] == 1 && result[ny][nx] == -1) {
                        result[ny][nx] = cur.d + 1;
                        que.add(new Node(ny, nx, cur.d + 1));
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
