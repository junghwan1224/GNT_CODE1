package ps9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/9205
 * 맥주 마시면서 걸어가기
 * */
class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int t;
    static int n;
    static int MAX_DISTANCE = 1000;
    static Node home;
    static Node target;
    static Node[] convStore;
    static Deque<Node> deq;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while(t > 0) {
            n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            home = new Node(x, y); // 집

            convStore = new Node[n]; // 편의점
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                convStore[i] = new Node(x, y);
            }

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            target = new Node(x, y); // 페스티벌 장소

            visit = new boolean[n];
            deq = new LinkedList<>();
            deq.add(home);

            System.out.println(bfs() ? "happy" : "sad");

            t--;
        }
    }

    public static int getDist(Node n1, Node n2) {
        return Math.abs(n1.y - n2.y) + Math.abs(n1.x - n2.x);
    }

    public static boolean bfs() {
        while(! deq.isEmpty()) {
            Node cur = deq.poll();

            if(getDist(cur, target) <= 1000)
                return true;

            for (int i = 0; i < n; i++) {
                if(visit[i])
                    continue;

                if(getDist(cur, convStore[i]) <= MAX_DISTANCE) {
                    visit[i] = true;
                    deq.add(convStore[i]);
                }
            }
        }
        return false;
    }
}
