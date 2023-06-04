package ps15558;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/15558
 * 점프 게임
 * */
class Point1 {
    int y;
    int x;
    int time;

    public Point1(int y, int x, int time) {
        this.y = y;
        this.x = x;
        this.time = time;
    }
}

public class Main2 {
    static int N, K;
    static char[][] line;
    static boolean[][] visit;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static Queue<Point1> que;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        line = new char[2][N];
        for (int i = 0; i < 2; i++) {
            line[i] = br.readLine().toCharArray();
        }

        visit = new boolean[2][N];

        que = new LinkedList<>();
        que.add(new Point1(0, 0, 0));
        visit[0][0] = true;

        while(! que.isEmpty()) {
            Point1 cur = que.poll();

            if(cur.time >= N)
                break;

            // 앞, 뒤
            for (int i = 0; i < 2; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if(nx >= N)
                    result = 1;

                if(0 <= ny && ny < 2 && cur.time < nx && nx < N && ! visit[ny][nx] && line[ny][nx] == '1') {
                    visit[ny][nx] = true;
                    que.add(new Point1(ny, nx, cur.time + 1));
                }
            }

            // 점프
            for (int i = 2; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + K;

                if(nx >= N)
                    result = 1;

                if(0 <= ny && ny < 2 && cur.time < nx && nx < N && ! visit[ny][nx] && line[ny][nx] == '1') {
                    visit[ny][nx] = true;
                    que.add(new Point1(ny, nx, cur.time + 1));
                }
            }
        }

        System.out.println(result);
    }
}
