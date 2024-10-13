package ps16918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/16918
 * 봄버맨
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
    static int R, C, N;
    static char[][] arr; // 폭탄 위치 저장
    static int[][] tmp; // 폭탄이 설치된 시점 저장
    static Deque<Node> deq;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        tmp = new int[R][C];
        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        // 폭탄 시점 저장 배열 초기화
        for (int i = 0; i < R; i++) {
            Arrays.fill(tmp[i], -1);
        }

        // 입력시 설치한 폭탄의 경우에는 설치 시점을 0으로 초기화 
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(arr[i][j] == 'O')
                    tmp[i][j] = 0;
            }
        }

        int time = 1;
        while(time < N) {

            if(time % 2 == 1) {
                fillBomb(time);
            }
            else if(time % 2 == 0) {
                deq = new LinkedList<>();

                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        // 폭발할 시점이 된 폭탄 폭발시킴
                        if(arr[i][j] == 'O' && tmp[i][j] > -1 && tmp[i][j] <= (time - 2)) {
                            deq.add(new Node(i, j));
                        }
                    }
                }

                bfs();
            }

            time++;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++)
                System.out.print(arr[i][j]);
            System.out.println();
        }
    }

    public static void fillBomb(int time) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(arr[i][j] == '.') {
                    arr[i][j] = 'O';
                    tmp[i][j] = time;
                }
            }
        }
    }

    public static void bfs() {
        while(! deq.isEmpty()) {
            Node cur = deq.poll();

            // 폭탄이 폭발했을 때, 인접한 칸에 폭탄이 있는 경우에는 인접한 폭탄은 폭발 없이 파괴된다. 따라서, 연쇄 반응은 없다.
            // 폭탄이 설치된 위치가 이미 폭발('.' 값으로 되어있음)했다는 건 인접한 칸에 폭탄이 이미 터졌단 뜻이므로,
            // 연쇄반응이 생기면 안되기 때문에 건너뛴다.
//            if(arr[cur.y][cur.x] == '.')
//                continue;

            // 폭탄이 설치된 위치 폭발 'O' => '.'으로 변경
            arr[cur.y][cur.x] = '.';
            tmp[cur.y][cur.x] = -1;

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if(0 <= ny && ny < R && 0 <= nx && nx < C) {
                    arr[ny][nx] = '.';
                    tmp[ny][nx] = -1;
                }
            }
        }
    }
}
