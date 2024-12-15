package ps14923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/14923
 * 미로 탈출
 * */
class Node {
    int y;
    int x;
    int cnt; // 이동 거리
    boolean isChange; // 벽을 길로 만들었는지 여부

    public Node(int y, int x, int cnt, boolean isChange) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
        this.isChange = isChange;
    }
}

public class Main {
    static int N, M;
    static Node startNode;
    static Node endNode;
    static int[][] arr;
    static boolean[][][] visit;
    static Deque<Node> deq;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visit = new boolean[N][M][2];

        st = new StringTokenizer(br.readLine());
        startNode = new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0, false);

        st = new StringTokenizer(br.readLine());
        endNode = new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0, false);

        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        deq = new LinkedList<>();
        deq.add(startNode);
        visit[startNode.y][startNode.x][0] = true;

        while(! deq.isEmpty()) {
            Node cur = deq.poll();

            if(cur.y == endNode.y && cur.x == endNode.x) {
                result = cur.cnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if(0 <= ny && ny < N && 0 <= nx && nx < M) {
                    // 빈칸일 경우 이동거리 + 1, 지팡이 사용 여부는 현재 값(cur.isChange) 그대로 큐에 저장
                    int isChangeIdx = cur.isChange ? 1 : 0;
                    if(arr[ny][nx] == 0 && ! visit[ny][nx][isChangeIdx]) {
                        visit[ny][nx][isChangeIdx] = true;
                        deq.add(new Node(ny, nx, cur.cnt + 1, cur.isChange));
                    }
                    // 벽일 경우, 지팡이를 사용하지 않았다면 벽을 길로 바꾸어 이동 및 사용 여부 true로 변경
                    else if(arr[ny][nx] == 1 && ! cur.isChange) {
                        visit[ny][nx][1] = true;
                        deq.add(new Node(ny, nx, cur.cnt + 1, true));
                    }
                }
            }
        }

        System.out.println(result);
    }
}
