package ps1347;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/1347
 * 미로 만들기
 * */
public class Main {
    static int n;
    static char[] command;
    static int[][] map;
    static int MAX = 101;
    // 0: 북, 1: 남, 2: 서, 3: 동
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int sy;
    static int sx;
    static int dir;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        command = br.readLine().toCharArray();
        map = new int[MAX][MAX];

        // 정중앙에서 시작
        sy = 50;
        sx = 50;
        map[sy][sx] = 1;
        // 최초 남쪽을 바라보며 시작
        dir = 1;

        for (int i = 0; i < n; i++) {
            // R 또는 L 일 경우, 방향 전환
            if(command[i] == 'R' || command[i] == 'L')
                dir = getDir(dir, command[i]);
            // F 일 경우 해당 방향으로 전진
            else {
                sy += dy[dir];
                sx += dx[dir];
                map[sy][sx] = 1;
            }
        }

        // 미로 시작 지점, 종료 지점 찾기
        int startY, startX, endY, endX;
        startY = startX = MAX;
        endY = endX = 0;
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if(map[i][j] == 1) {
                    if(startY > i)
                        startY = i;
                    if(startX > j)
                        startX = j;
                    if (endY < i)
                        endY = i;
                    if(endX < j)
                        endX = j;
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = startY; i <= endY; i++) {
            for (int j = startX; j <= endX; j++) {
                if(map[i][j] == 1)
                    sb.append(".");
                else
                    sb.append("#");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    // 0: 북, 1: 남, 2: 서, 3: 동
    static public int getDir(int dir, char cmd) {
        if(cmd == 'R') {
            if(dir == 0)
                return 3;
            else if(dir == 1)
                return 2;
            else if(dir == 2)
                return 0;
            else
                return 1;
        }
        else {
            if(dir == 0)
                return 2;
            else if(dir == 1)
                return 3;
            else if(dir == 2)
                return 1;
            else
                return 0;
        }
    }
}
