package ps3758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/3758
 * */
class Node implements Comparable<Node> {
    int id;
    int totalScore; // ���� ����
    int submitCnt; // ���� Ƚ��
    int submitTime; // ���� �ð�

    public Node(int id, int t, int sc, int st) {
        this.id = id;
        this.totalScore = t;
        this.submitCnt = sc;
        this.submitTime = st;
    }

    @Override
    public int compareTo(Node n) {
        if(this.totalScore == n.totalScore) {
            if(this.submitCnt == n.submitCnt) {
                return this.submitTime - n.submitTime;
            }
            return this.submitCnt - n.submitCnt;
        }
        return n.totalScore - this.totalScore;
    }
}

public class Main {
    static int T;
    static StringBuffer sb;
    static Map<Integer, Node> map;
    static ArrayList<Node> list;
    static int[][] problem;
    static int[] last;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        sb = new StringBuffer();

        while(T > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // ���� ����
            int k = Integer.parseInt(st.nextToken()); // ������ ����
            int t = Integer.parseInt(st.nextToken()); // �Ҽ���  ID
            int m = Integer.parseInt(st.nextToken()); // �α� ��Ʈ�� ��

            map = new HashMap<>();
            list = new ArrayList<>();
            problem = new int[n + 1][k + 1];
            last = new int[n + 1];
            cnt = new int[n + 1];

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken()); // ���� ID
                int pnum = Integer.parseInt(st.nextToken()); // ���� ��ȣ
                int score = Integer.parseInt(st.nextToken()); // ȹ���� ����

                problem[id][pnum] = problem[id][pnum] < score ? score : problem[id][pnum];
                last[id] = i;
                cnt[id]++;
            }

            for (int i = 1; i <= n; i++) {
                int totalScore = 0;
                for (int j = 0; j <= k ; j++) {
                    totalScore += problem[i][j];
                }

                list.add(new Node(i, totalScore, cnt[i], last[i]));
            }

            Collections.sort(list);

            for(int i = 0; i < n; i++) {
                if(list.get(i).id == t) {
                    sb.append(i + 1).append("\n");
                    break;
                }
            }

            T--;
        }

        System.out.println(sb);
    }

}

