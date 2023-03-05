package ps1863;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * https://www.acmicpc.net/problem/1863
 * */
class Node {
    int pos;
    int height;

    public Node(int pos, int height) {
        this.pos = pos;
        this.height = height;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        Stack<Node> stack = new Stack<>();
        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Node node = new Node(a, b);

            // 입력받은 건물 높이가 스택 최상단에 있는 높이 값보다 작으면 건물 높이가 정해지므로 카운트 늘려준다
            while(! stack.isEmpty() && stack.peek().height > node.height) {
                stack.pop();
                cnt++;
            }

            // 높이가 같은 경우는 넘어간다
            if(! stack.isEmpty() && stack.peek().height == node.height)
                continue;

            stack.push(node);
        }

        // 마지막에 남아있는 건물 수 체크
        while(! stack.isEmpty()) {
            Node cur = stack.pop();

            if(! stack.isEmpty() && stack.peek().height == cur.height)
                continue;

            if(cur.height == 0)
                continue;

            cnt++;
        }

        System.out.println(cnt);
    }
}


/*
*
4
1 4
2 3
3 5
4 4

5
1 3
2 5
3 4
4 6
5 5

* */