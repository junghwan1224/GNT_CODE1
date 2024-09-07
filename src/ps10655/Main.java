package ps10655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/10655
 * 마라톤 1
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
    static Node[] arr;
    static int result = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Node[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Node(y, x);
        }

        int total = 0;
        /*for (int i = 0; i < N - 1; i++) {
            total += getDistance(arr[i].x, arr[i].y, arr[i + 1].x, arr[i + 1].y);
        }

        for (int i = 0; i < N - 2; i++) {
            int tmp = getDistance(arr[i].x, arr[i].y, arr[i + 1].x, arr[i + 1].y)
                    - getDistance(arr[i + 1].x, arr[i + 1].y, arr[i + 2].x, arr[i + 2].y)
                    + getDistance(arr[i].x, arr[i].y, arr[i + 2].x, arr[i + 2].y)
                    ;
            result = Math.min(result, total - tmp);
        }*/

        for (int i = 1; i < N; i++) {
            total += getDistance(arr[i].x, arr[i].y, arr[i - 1].x, arr[i - 1].y);
        }

        for (int i = 1; i < N - 1; i++) {
            int tmp = getDistance(arr[i - 1].x, arr[i - 1].y, arr[i + 1].x, arr[i + 1].y)
                    - getDistance(arr[i].x, arr[i].y, arr[i + 1].x, arr[i + 1].y)
                    - getDistance(arr[i].x, arr[i].y, arr[i - 1].x, arr[i - 1].y)
                    ;
            result = Math.min(result, total + tmp);
        }

        System.out.println(result);
    }

    public static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
