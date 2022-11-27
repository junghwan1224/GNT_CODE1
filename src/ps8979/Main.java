package ps8979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/8979
 * 올림픽
 * */
class Node implements Comparable<Node> {
    int num;
    int gold;
    int silver;
    int bronze;

    public Node(int num , int gold, int silver, int bronze) {
        this.num = num;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    public int compareTo(Node node) {
        if(this.gold == node.gold) {
            if(this.silver == node.silver)
                return node.bronze - this.bronze;
            return node.silver - this.silver;
        }
        // 금메달 많은 순으로 정렬
        return node.gold - this.gold;
    }
}

public class Main {
    static int N, K;
    static ArrayList<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new Node(n, g, s, b));
        }

        Collections.sort(list);

        int cnt = 0;
        Node knode = null;

        for (int i = 0; i < N; i++) {
            if(list.get(i).num == K) {
                knode = list.get(i);
                break;
            }
        }

        for (int i = 0; i < N; i++) {
            Node cur = list.get(i);
            //System.out.println(cur.num + " " + knode.num + " " + (cur.num == K));

            if(cur.num == K) {
                //System.out.println(cur.num + " / " + K);
                break;
            }

            if (cur.gold == knode.gold
                    && cur.silver == knode.silver
                    && cur.bronze == knode.bronze)
                continue;

            cnt++;
        }

        System.out.println(cnt + 1);
    }
}

/*
* Test Case
in:
4 1
1 1 2 0
2 0 1 0
3 0 1 0
4 0 0 1
out: 1

in:
4 4
1 1 0 0
2 1 0 0
3 0 1 0
4 0 1 0
out: 3


in:
2 1
1 39 8 22
2 39 91 8
out: 2
* */