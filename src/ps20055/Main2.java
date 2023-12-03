package ps20055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/20055
 * 컨베이어 벨트 위의 로봇
 * 시즌10_2회차_221008
 * */
public class Main2 {
    static int N;
    static int K;
    static int[] arr;
    static int step;
    static Queue<Integer> robotQue;
    static boolean[] isRobot;
    static int up;
    static int down;
    static int zeroCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        robotQue = new LinkedList<>();
        isRobot = new boolean[2 * N];
        up = 0;
        down = N - 1;

        while(countZero() < K) {
            step++;
            moveBelt();
            moveRobot();
            putRobot();
        }

        System.out.println(step);
    }

    // 벨트 이동
    public static void moveBelt() {
        up = (up - 1 < 0) ? 2 * N - 1 : up - 1;
        down = (down - 1 < 0) ? 2 * N - 1 : down - 1;
    }

    // 로봇 이동
    public static void moveRobot() {
        int size = robotQue.size();

        for (int i = 0; i < size; i++) {
            int cur = robotQue.poll();
            isRobot[cur] = false;
            int next = (cur + 1 == 2 * N) ? 0 : cur + 1;

            if(cur == down)
                continue;

            if(! isRobot[next] && arr[next] > 0) {
                arr[next]--;
                if(arr[next] == 0)
                    zeroCnt++;

                if(next == down) {
                    continue;
                }
                robotQue.add(next);
                isRobot[next] = true;
            }
            else {
                isRobot[cur] = true;
                robotQue.add(cur);
            }
        }
    }

    // 올리는 위치에 로봇 올리기
    public static void putRobot() {
        if(! isRobot[up] && arr[up] > 0) {
            robotQue.add(up);
            arr[up]--;
            isRobot[up] = true;

            if(arr[up] == 0)
                zeroCnt++;
        }
    }

    public static int countZero() {
        int cnt = 0;
        for (int i = 0; i < 2 * N; i++) {
            if(arr[i] <= 0)
                cnt++;
        }

        return cnt;
    }
}
