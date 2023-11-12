package ps2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
* https://www.acmicpc.net/problem/2075
* N번째 큰 수
* */
class Node2 implements Comparable<Node2> {
    int num;

    public Node2(int num) {
        this.num = num;
    }

    @Override
    public int compareTo(Node2 n) {
        return n.num - this.num;
    }
}

public class Main2 {
    static int N;
    static PriorityQueue<Node2> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                pq.add(new Node2(a));
            }
        }

        int result = 0;
        while(N > 0) {
            result = pq.poll().num;
            N--;
        }
        System.out.println(result);
    }
}
