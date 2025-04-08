package ps2170;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2170
 * 선 긋기
 * */
class Node2 implements Comparable<Node2> {
    int x;
    int y;

    public Node2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node2 node) {
        if(this.x == node.x)
            return this.y - node.y;
        return this.x - node.x;
    }
}

public class Main2 {
    public static int N;
    public static Node2[] arr;
    public static int start, end, idx;
    public static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new Node2[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Node2(x, y);
        }

        Arrays.sort(arr);

        start = arr[0].x;
        end = arr[0].y;
        idx = 1;

        while(start < end && idx < N) {
            if(arr[idx].x <= end) {
                System.out.println("idx = " + idx);
                System.out.println("start = " + start);
                System.out.println("end = " + end);
                System.out.println("arr[idx].x = " + arr[idx].x);
                System.out.println("arr[idx].y = " + arr[idx].y);
                System.out.println();

                if(arr[idx].y > end)
                    end = arr[idx].y;
                System.out.println("start = " + start);
                System.out.println("end = " + end);
                System.out.println();
            }
            else {
                System.out.println("idx = " + idx);
                System.out.println();
                result += (end - start);
                start = arr[idx].x;
                end = arr[idx].y;
            }

            idx++;
        }

        result += (end - start);

        System.out.println(result);
    }
}
