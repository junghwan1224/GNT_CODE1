package ps11758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/11758
 * CCW
 * ref. https://www.acmicpc.net/blog/view/27
 * */
class Pos {
    int y;
    int x;

    public Pos(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    public static Pos[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new Pos[3];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Pos(y, x);
        }

        long res = ccw(arr[0], arr[1], arr[2]);

        if (res > 0) {
            System.out.println(1);
        } else if (res < 0) {
            System.out.println(-1);
        } else {
            System.out.println(0);
        }
    }

    public static long ccw(Pos p1, Pos p2, Pos p3) {
        return p1.x * p2.y + p2.x * p3.y + p3.x * p1.y - p1.y * p2.x - p2.y * p3.x - p3.y * p1.x;
    }
}
