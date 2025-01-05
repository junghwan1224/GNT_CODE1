package ps2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2644
 * 촌수계산
 * */
class Node {
    int famNo;
    int cnt;

    public Node(int famNo, int cnt) {
        this.famNo = famNo;
        this.cnt = cnt;
    }
}

public class Main {
    static int n;
    static int[] target;
    static int relation;
    static int[][] family;
    static boolean[] visit;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        target = new int[2];
        target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        relation = Integer.parseInt(br.readLine());
        family = new int[n + 1][n + 1];
        visit = new boolean[n + 1];
        for (int i = 0; i < relation; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            family[a][b] = 1;
            family[b][a] = 1;
        }

        Deque<Node> deq = new LinkedList<>();
        deq.add(new Node(target[0], 0));
        result = -1;
        visit[target[0]] = true;

        while(! deq.isEmpty()) {
            Node cur = deq.poll();

            if(cur.famNo == target[1]) {
                result = cur.cnt;
                break;
            }

            for (int i = 1; i < n + 1; i++) {
                if(family[cur.famNo][i] == 1 && ! visit[i]) {
                    visit[i] = true;
                    deq.add(new Node(i, cur.cnt + 1));
                }
            }
        }

        System.out.println(result);
    }
}
