package ps9252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/9252
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        s1 = " " + s1;
        s2 = " " + s2;

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        int[][] d = new int[a.length][b.length];
        String lcs = "";

        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < b.length; j++) {
                if(a[i] == b[j]) {
                    d[i][j] = d[i - 1][j - 1] + 1;
                }
                else {
                    d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]);
                }
            }
        }

        int y = a.length - 1;
        int x = b.length - 1;
        while(y >= 1 && x >= 1 && d[y][x] != 0) {
            if(d[y][x] == d[y][x - 1]) {
                x--;
            }
            else if(d[y][x] == d[y - 1][x]) {
                y--;
            }
            else {
                lcs += Character.toString(a[y]);
                y--;
                x--;
            }
        }

        StringBuffer sb = new StringBuffer(lcs);
        sb.reverse();
        lcs = sb.toString();
        System.out.println(d[a.length - 1][b.length - 1]);
        System.out.println(lcs);
    }
}
