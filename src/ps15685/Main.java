package ps15685;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/15685
 * */
public class Main {
    static int N;
    static int[][] arr;
    static int MAX = 101;
    // 문제에서 주어진 방향에 맞게 세팅
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    static ArrayList<Integer> list;
    static ArrayList<Integer> tmp;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[MAX][MAX];

        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            tmp = new ArrayList<>();
            tmp.add(d); // 초기 방향정보 저장
            arr[y][x] = 1; // 0세대 드래곤 커브 좌표 방문 처리(시작점)
            y = y + dy[d];
            x = x + dx[d];
            arr[y][x] = 1; // 0세대 드래곤 커브 좌표 방문 처리(끝 점)
            while(g > 0) {
                list = tmp; // 각 세대별 방향정보 세팅

                // 역방향으로 탐색 진행
                for (int i = list.size() - 1; i >= 0 ; i--) {
                    // 다음 방향
                    int next = (list.get(i) + 1) % 4;
                    int ny = y + dy[next];
                    int nx = x + dx[next];

                    if(ny < 0 || ny >= MAX || nx < 0 || nx >= MAX)
                        break;

                    // 다음 방향에 대한 좌표 방문 처리 및 리스트에 방향 추가
                    arr[ny][nx] = 1;
                    y = ny;
                    x = nx;
                    tmp.add(next);
                }
                g--;
            }
        }

        // 사각형 구하기
        for (int i = 1; i < MAX; i++) {
            for (int j = 1; j < MAX; j++) {
                if(arr[i][j] == 1 && arr[i - 1][j] == 1 && arr[i][j - 1] == 1 && arr[i - 1][j - 1] == 1)
                    result++;
            }
        }

        System.out.println(result);
    }
}
