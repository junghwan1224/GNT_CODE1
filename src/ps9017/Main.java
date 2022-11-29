package ps9017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* https://www.acmicpc.net/problem/9017
* 크로스 컨트리
* */
class Node implements Comparable<Node> {
    int team; // 팀 번호
    int sum; // 4등 까지 등수 합
    int fifth; // 5등 점수

    public Node(int team, int sum, int fifth) {
        this.team = team;
        this.sum = sum;
        this.fifth = fifth;
    }

    public int compareTo(Node node) {
        if(this.sum == node.sum)
            return this.fifth - node.fifth;
        return this.sum - node.sum;
    }
}

public class Main {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        while(T > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            // 팀의 참가 선수 저장
            Map<Integer, Integer> map = new HashMap<>();
            // 팀별 등수 저장
            ArrayList[] list = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<Integer>();
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            int idx = 0;
            int rank = 1;

            while(idx < N) {
                if(map.get(arr[idx]) < 6) {
                    idx++;
                    continue;
                }

                list[arr[idx]].add(rank);
                rank++;
                idx++;
            }

            ArrayList<Node> result = new ArrayList<Node>();
            for (int i = 1; i <= N; i++) {
                // 점수 계산에서 제외된 팀은 건너뛴다
                if(list[i].size() == 0)
                    continue;

                int sum = 0;
                for(int j = 0; j < 4; j++)
                    sum += (int)list[i].get(j);

                result.add(new Node(i, sum, (int)list[i].get(4)));
            }

            Collections.sort(result);

            sb.append(result.get(0).team).append("\n");

            T--;
        }

        System.out.println(sb);
    }
}
