package ps1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1931
 * */
class Node implements Comparable<Node> {
    int start;
    int end;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Node node) {
        if(this.end == node.end)
            return this.start - node.start;
        return this.end - node.end;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] arr = new Node[n];
        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 종료 시간이 빠른 순으로 정렬, 종료 시간 같으면 시작시간 빠른 순으로 정렬
        Arrays.sort(arr);

        int time = arr[0].end;
        int result = 1;
        for (int i = 1; i < n; i++) {
            // 다음 회의의 시작 시간이 현재 진행 중인 회의의 종료 시간보다 크거나 같으면, 다음 회의 종료 시간으로 변경 및 카운트 증가
            if(time <= arr[i].start) {
                time = arr[i].end;
                result++;
            }
        }

        System.out.println(result);
    }
}
