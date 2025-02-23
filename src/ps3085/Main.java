package ps3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/3085
 * 사탕 게임
 * */

/*
3
ZCY
ZCP
PYZ
ans: 2

4
CPZY
ZYPC
PCZY
PZCY
ans: 3

* */

public class Main {
    static int n;
    static char[][] arr;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, getCandyCnt(i, j));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j < n - 1 && arr[i][j] != arr[i][j + 1]) {
                    char tmp = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = tmp;

                    result = Math.max(result, getCandyCnt(i, j));
                    result = Math.max(result, getCandyCnt(i, j + 1));

                    tmp = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = tmp;
                }
                if (i < n - 1 && arr[i][j] != arr[i + 1][j]) {
                    char tmp = arr[i][j];
                    arr[i][j] = arr[i + 1][j];
                    arr[i + 1][j] = tmp;

                    result = Math.max(result, getCandyCnt(i, j));
                    result = Math.max(result, getCandyCnt(i + 1, j));

                    tmp = arr[i][j];
                    arr[i][j] = arr[i + 1][j];
                    arr[i + 1][j] = tmp;
                }
            }
        }

        System.out.println(result);
    }

    public static int getCandyCnt(int y, int x) {
        int rowCnt = 0;
        int colCnt = 0;

        for (int i = y - 1; i >= 0; i--) {
            if(arr[i][x] != arr[y][x])
                break;
            rowCnt++;
        }

        for (int i = y + 1; i < n; i++) {
            if(arr[i][x] != arr[y][x])
                break;
            rowCnt++;
        }

        for (int i = x - 1; i >= 0; i--) {
            if(arr[y][i] != arr[y][x])
                break;
            colCnt++;
        }

        for (int i = x + 1; i < n; i++) {
            if(arr[y][i] != arr[y][x])
                break;
            colCnt++;
        }

        return Math.max(rowCnt, colCnt) + 1;
    }
}
