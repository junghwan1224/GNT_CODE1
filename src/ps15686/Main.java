package ps15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/15686
 * 치킨 배달
 * */
class Node {
    int r;
    int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[] visit;
    static ArrayList<Node> chickens;
    static ArrayList<Node> homes;
    static int MAX_DISTANCE = 987654321;
    static int closeChickenCnt;
    static int originChickenCnt;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 집, 치킨집 좌표 저장
        homes = new ArrayList<>();
        chickens = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == 1) {
                    homes.add(new Node(i, j));
                } else if (arr[i][j] == 2) {
                    chickens.add(new Node(i, j));
                }
            }
        }

        // 거리 MAX 값 초기화
        result = MAX_DISTANCE;

        // 치킨 가게의 수
        originChickenCnt = chickens.size();

        // 폐업해야 할 지점의 최소 갯수
        closeChickenCnt = originChickenCnt - M;

        visit = new boolean[originChickenCnt];

        dfs(0, 0);

        System.out.println(result);
    }

    public static void dfs(int idx, int count) {
        // 치킨집을 M개 골랐을 경우, 치킨 거리 계산하여 최솟값 갱신
        // 치킨 거리가 최소가 되려면 최대치(M개)까지 골라야 한다.
        if(count == M) {
            int chickenDist = 0;
            for(Node home: homes) {
                chickenDist += getChickenDistance(home.r, home.c);
            }
            result = Math.min(result, chickenDist);
        }

        for (int i = idx; i < originChickenCnt; i++) {
            if(! visit[i]) {
                visit[i] = true;
                dfs(i, count + 1);
                visit[i] = false;
            }
        }
    }

    // 현재 위치에서 치킨 거리 구하기
    public static int getChickenDistance(int r, int c) {
        int dist = MAX_DISTANCE;

        for(int i = 0; i < originChickenCnt; i++) {
            Node chicken = chickens.get(i);
            // visit 값이 false 인 것은 폐업을 했다는 의미이므로, 해당 치킨집은 건너뛰고 거리 계산
            if(! visit[i])
                continue;
            int chickenDist = Math.abs(r - chicken.r) + Math.abs(c - chicken.c);
            dist = Math.min(dist, chickenDist);
        }

        return dist;
    }
}
