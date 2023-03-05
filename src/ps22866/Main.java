package ps22866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/*
 * https://www.acmicpc.net/problem/22866
 * */
class Node {
    int idx;
    int height;

    public Node(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }
}

public class Main {
    static int n;
    static int[] arr;
    static Stack<Node> stack;
    static int[] cnt;
    static int[][] near;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        stack = new Stack<>();
        cnt = new int[n]; // 건물의 합
        near = new int[n][2]; // near[n][0] = 가까운 건물의 번호, near[n][1] = 건물간 거리의 차이

        // 현재 위치에 있는 건물에서 좌측으로 보이는 건물 갯수
        for (int i = 0; i < n; i++) {
            while(! stack.isEmpty()) {
                if(stack.peek().height <= arr[i]) {
                    stack.pop();
                }
                else {
                    break;
                }
            }

            if(! stack.isEmpty()) {
                cnt[i] += stack.size();
                near[i][0] = stack.peek().idx;
                near[i][1] = Math.abs(stack.peek().idx - i);
            }
            stack.push(new Node(i, arr[i]));
        }

        stack.clear();

        for (int i = n - 1; i >= 0 ; i--) {
            while(! stack.isEmpty()) {
                if(stack.peek().height <= arr[i]) {
                    stack.pop();
                }
                else {
                    break;
                }
            }

            if(! stack.isEmpty()) {
                cnt[i] += stack.size();
                int diff = Math.abs(stack.peek().idx - i);
                // 좌측 탐색했을 때 보이는 건물이 있고 우측에서 보이는 건물과의 거리 차이보다 크면 최솟값 갱신
                if(near[i][1] > 0 && near[i][1] > diff) {
                    near[i][0] = stack.peek().idx;
                    near[i][1] = diff;
                }
                // 거리가 같으면 건물 번호 최솟값 갱신
                else if(near[i][1] == diff) {
                    near[i][0] = Math.min(near[i][0], stack.peek().idx);
                }
                // 좌측 건물 탐색했을 때 보이는 건물이 없으면 새로 등록
                else if(near[i][1] == 0) {
                    near[i][0] = stack.peek().idx;
                    near[i][1] = diff;
                }
            }

            stack.push(new Node(i, arr[i]));
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if(cnt[i] == 0)
                sb.append(0).append("\n");
            else {
                sb.append(cnt[i]).append(" ").append(near[i][0] + 1).append("\n");
            }
        }

        System.out.println(sb);
    }
}
