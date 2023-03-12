package ps5972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/5972
 * 택배 배송
 * 2차원 배열로 각 노드간 거리를 저장할 경우 메모리 초과 발생 => ArrayList로 처리
 * */
class Node implements Comparable<Node> {
    int distance;
    int node;

    public Node(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }

    public int compareTo(Node n) {
        return this.distance - n.distance;
    }
}

public class Main {

    static int N, M;
    static int[][] arr;
    static int MAX = 987654321;
    static ArrayList<Node>[] list;
    static int[] dist;
    static PriorityQueue<Node> pque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        dist = new int[N + 1];

//        for (int i = 0; i <= N; i++) {
//            Arrays.fill(arr[i], MAX);
//        }
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<Node>();
        }
        Arrays.fill(dist, MAX);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

//            arr[a][b] = c;
//            arr[b][a] = c;
            list[a].add(new Node(c, b));
            list[b].add(new Node(c, a));
        }

        pque = new PriorityQueue<>();
        pque.add(new Node(0, 1));
        dist[1] = 0;

        while(! pque.isEmpty()) {
            Node cur = pque.poll();

            for(Node next: list[cur.node]) {
                if(dist[next.node] > cur.distance + next.distance) {
                    dist[next.node] = cur.distance + next.distance;
                    pque.add(new Node(dist[next.node], next.node));
                }
            }

//            for (int i = 1; i <= N; i++) {
//                if(i == cur.node)
//                    continue;
//
//                if(arr[cur.node][i] != MAX && dist[i] > cur.distance + arr[cur.node][i]) {
//                    dist[i] = cur.distance + arr[cur.node][i];
//                    pque.add(new Node(dist[i], i));
//                }
//            }
        }

        System.out.println(dist[N]);
    }
}
