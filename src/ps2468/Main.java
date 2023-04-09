package ps2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2468
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
    static int N;
    static int[][] arr;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static boolean[][] flag;
    static Queue<Node> que;
    static int maxHeight;
    static int area;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        result = 1; // 모든 지역이 잠기지 않았을 때, 안전한 영역의 갯수는 1이다
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, arr[i][j]);
            }
        }

        // 입력받은 지점의 높이가 가장 높은 값까지 비가 내린다고 가정
        for (int h = 1; h <= maxHeight; h++) {
            que = new LinkedList<>();
            flag = new boolean[N][N];
            area = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(arr[i][j] > h && ! flag[i][j]) {
                        que.add(new Node(i, j));
                        flag[i][j] = true;
                        bfs(h);
                        area++;
                    }
                }
            }

            result = Math.max(result, area);
        }

        System.out.println(result);
    }

    public static void bfs(int height) {
        while(! que.isEmpty()) {
            Node cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if(0 <= ny && ny < N && 0 <= nx && nx < N && ! flag[ny][nx] && arr[ny][nx] > height) {
                    flag[ny][nx] = true;
                    que.add(new Node(ny, nx));
                }
            }
        }
    }
}
