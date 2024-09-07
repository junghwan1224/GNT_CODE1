package ps17086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/17086
 * 아기 상어 2
 * */
class Node {
    int y;
    int x;
    int cnt;

    public Node(int y, int x, int cnt) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
    }
}

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
    static Deque<Node> deq;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 0) {
                    visit = new boolean[N][M];
                    deq = new LinkedList<>();
                    visit[i][j] = true;
                    deq.add(new Node(i, j, 0));
                    bfs();
                }
            }
        }

        System.out.println(result);
    }

    public static void bfs() {
        while(! deq.isEmpty()) {
            Node cur = deq.pollFirst();

            if(arr[cur.y][cur.x] == 1) {
                result = Math.max(result, cur.cnt);
                return;
            }

            for (int i = 0; i < 8; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];


                if(0 <= ny && ny < N && 0 <= nx && nx < M && ! visit[ny][nx]) {
                    visit[ny][nx] = true;
                    deq.add(new Node(ny, nx, cur.cnt + 1));
                }
            }
        }
    }
}
