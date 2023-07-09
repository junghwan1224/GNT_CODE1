package ps3190_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/3190
 * 뱀
 * */
class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Lotation {
    int x;
    char c;

    public Lotation(int x, char c) {
        this.x = x;
        this.c = c;
    }
}

public class Main {
    static int N;
    static int K;
    static int L;
    static int[][] arr;
    static boolean[][] visit;

    // 0 - 하, 1 - 상, 2 - 우, 3 - 좌
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static Deque<Node> deq;
    static Queue<Lotation> lotQue;
    static int dir;
    static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visit = new boolean[N][N];
        deq = new LinkedList<>();
        lotQue = new LinkedList<>();

        StringTokenizer st = null;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[r - 1][c - 1] = 1;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().toCharArray()[0];
            lotQue.add(new Lotation(x, c));
        }

        deq.add(new Node(0, 0));
        visit[0][0] = true;
        dir = 2; // 뱀은 처음에 오른쪽을 향한다.

        while(! deq.isEmpty()) {
            Node cur = deq.peekFirst();

            int ny = cur.y + dy[dir];
            int nx = cur.x + dx[dir];

            time++;

            // 벽에 도달하면 종료
            if(! (0 <= ny && ny < N && 0 <= nx && nx < N))
                break;
            // 다음 방향이 이미 방문한 지점(몸통)이면 종료
            if(visit[ny][nx])
                break;

            // 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
            if(arr[ny][nx] == 0) {
                Node tail = deq.pollLast();
                visit[tail.y][tail.x] = false;
            }
            // 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
            else {
                arr[ny][nx] = 0;
            }

            visit[ny][nx] = true;
            deq.addFirst(new Node(ny, nx));

            // 게임 시작 시간으로부터 X초가 끝난 뒤
            if(! lotQue.isEmpty() && time == lotQue.peek().x) {
                dir = turn(lotQue.peek().c, dir);
                lotQue.poll();
            }
        }

        System.out.println(time);
    }

    public static int turn(char c, int dir) {
        // 0 - 하, 1 - 상, 2 - 우, 3 - 좌
        if(c == 'L') {
            if(dir == 0)
                return 2;
            else if(dir == 1)
                return 3;
            else if(dir == 2)
                return 1;
            else
                return 0;
        }
        else {
            if(dir == 0)
                return 3;
            else if(dir == 1)
                return 2;
            else if(dir == 2)
                return 0;
            else
                return 1;
        }
    }
}
