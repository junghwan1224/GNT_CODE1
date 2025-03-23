package ps3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/3055
 * 탈출
 * */
class Node {
    int y;
    int x;
    int time;

    public Node(int y, int x, int time) {
        this.y = y;
        this.x = x;
        this.time = time;
    }
}

public class Main {
    static int R, C;
    static char[][] arr;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static Node start, destination;
    static Deque<Node> deq;
    static Deque<Node> waterDeq;
    static int[][] water;
    static boolean[][] visit;
    static int result;
    static int MAX = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        result = MAX;
        water = new int[R][C];
        visit = new boolean[R][C];
        waterDeq = new LinkedList<>();
        deq = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            Arrays.fill(water[i], MAX);
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(arr[i][j] == 'S') {
                    start = new Node(i, j, 0);
                }
                else if (arr[i][j] == 'D') {
                    destination = new Node(i, j, 0);
                }
                else if (arr[i][j] == '*') {
                    // 물이 차있는 지역이 2군데 이상일 수 있으므로 확인되는 대로 큐에 저장(예제 입력 4 참고)
                    waterDeq.add(new Node(i, j, 0));
                    water[i][j] = 0;
                }
            }
        }

        fillWater();
        escape();

        System.out.println(result == MAX ? "KAKTUS" : Integer.toString(result));
    }

    public static void fillWater() {
        while(! waterDeq.isEmpty()) {
            Node cur = waterDeq.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if(0 <= ny && ny < R && 0 <= nx && nx < C) {
                    // 아래 두 경우에 인접한 곳에 물을 채운다.
                    // 1. 인접한 곳이 돌과 비버의 굴이 아닐 경우
                    // 2. 인접한 곳에 물이 안채워져 있거나(MAX 값 초기화 상태), 이번에 물을 채울 때, 기존보다 더 빨리 채울 수 있는 경우
                    if(arr[ny][nx] != 'X' && arr[ny][nx] != 'D' && water[ny][nx] > water[cur.y][cur.x] + 1) {
                        water[ny][nx] = water[cur.y][cur.x] + 1;
                        waterDeq.add(new Node(ny, nx, 0));
                    }
                }
            }
        }
    }

    public static void escape() {
        deq.add(start);
        visit[start.y][start.x] = true;

        while(! deq.isEmpty()) {
            Node cur = deq.poll();

            if(cur.y == destination.y && cur.x == destination.x) {
                result = cur.time;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if(0 <= ny && ny < R && 0 <= nx && nx < C) {
                    if(! visit[ny][nx] && arr[ny][nx] != 'X' && arr[ny][nx] != '*' && water[ny][nx] > cur.time + 1) {
                        visit[ny][nx] = true;
                        deq.add(new Node(ny, nx, cur.time + 1));
                    }
                }
            }
        }
    }
}
