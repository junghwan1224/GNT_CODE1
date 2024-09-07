package ps13335;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/13335
 * 트럭
 * */
public class Main {
    static int N; // 트럭의 수,
    static int W; // 다리 길이,
    static int L; // 다리 하중,
    static int[] arr;
    static Deque<Integer> deq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        deq = new LinkedList<>();

        int time = 0;
        int idx = 0;
        int sum = 0;

        for (int i = 0; i < W; i++) {
            deq.addLast(0);
        }

        while(idx < N) {
            if(! deq.isEmpty())
                sum -= deq.pollFirst();
            time++;

            if(sum + arr[idx] <= L) {
                sum += arr[idx];
                deq.addLast(arr[idx++]);
            }
            else {
                deq.addLast(0);
            }
        }

        while(! deq.isEmpty()) {
            deq.pollFirst();
            time++;
        }

        System.out.println(time);
    }
}
