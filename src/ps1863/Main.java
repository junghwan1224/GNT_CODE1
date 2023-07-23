package ps1863;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1863
 * 스카이라인 쉬운거
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
    static int n;
    static Stack<Node> stack;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while(! stack.isEmpty() && stack.peek().y > y) {
                stack.pop();
                result++;
            }

            if(! stack.isEmpty() && stack.peek().y == y)
                continue;

            stack.add(new Node(x, y));
        }

        while(! stack.isEmpty()) {
            Node cur = stack.pop();

            if(! stack.isEmpty() && stack.peek().y == cur.y)
                continue;

            if(cur.y == 0)
                continue;

            result++;
        }

        System.out.println(result);
    }
}
