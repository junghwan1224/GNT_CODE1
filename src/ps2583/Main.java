package ps2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * https://www.acmicpc.net/problem/2583
 * 영역 구하기
 * */
class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int M, N, K;
    static int[][] arr;
    static boolean[][] visit;
    static ArrayList<Integer> list;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 입력받은 직사각형 표시
            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    arr[j][k] = 1;
                }
            }
        }

        visit = new boolean[M][N];
        list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == 0) {
                    if(! visit[i][j]) {
                        list.add(bfs(i, j));
                    }
                }
            }
        }

        /*for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }*/

        Collections.sort(list);
        System.out.println(list.size());
        for(Integer i: list)
            System.out.print(i + " ");
    }

    public static int bfs(int y, int x) {
        int cnt = 0;
        Deque<Node> deq = new LinkedList<>();
        deq.add(new Node(y, x));
        visit[y][x] = true;

        while(! deq.isEmpty()) {
            Node cur = deq.poll();
            cnt++;

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if(0 <= ny && ny < M && 0 <= nx && nx < N) {
                    if(arr[ny][nx] == 0 && ! visit[ny][nx]) {
                        visit[ny][nx] = true;
                        deq.add(new Node(ny, nx));
                    }
                }
            }
        }

        return cnt;
    }
}
