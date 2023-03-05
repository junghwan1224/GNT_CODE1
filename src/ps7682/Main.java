package ps7682;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/7682
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuffer sb = new StringBuffer();

        while(! str.equals("end")) {
            char[] game = str.toCharArray();
            boolean flag = false;
            int cntX = getCnt(game, 'X');
            int cntO = getCnt(game, 'O');
            boolean winX = getWin(game, 'X');
            boolean winO = getWin(game, 'O');

            // x가 이겼을 때
            if(winX) {
                // x가 이겼는데, o도 이긴 상태가 나오면 안된다
                if(winO)
                    flag = false;
                else {
                    // x가 이기면 x의 갯수는 o보다 1개 더 많다
                    if(cntX - cntO == 1)
                        flag = true;
                    else
                        flag = false;
                }
            }

            // o가 이겼을 때
            else if(winO) {
                // x, o의 갯수가 같아야 발생할 수 있는 상태
                if(cntX == cntO)
                    flag = true;
                else
                    flag = false;
            }

            // 그 외
            else {
                // x, o 문자의 합이 9이고, x가 o보다 1개 더 많아야 발생할 수 있는 상태
                if(cntX + cntO == 9 && cntX - cntO == 1)
                    flag = true;
                else
                    flag = false;
            }

            sb.append(flag ? "valid" : "invalid").append("\n");

            str = br.readLine();
        }

        System.out.println(sb);
    }

    public static boolean getWin(char[] arr, char chr) {
        boolean flag = false;
        if((arr[0] == chr && arr[1] == chr && arr[2] == chr)
                || (arr[3] == chr && arr[4] == chr && arr[5] == chr)
                || (arr[6] == chr && arr[7] == chr && arr[8] == chr)
                || (arr[0] == chr && arr[4] == chr && arr[8] == chr)
                || (arr[2] == chr && arr[4] == chr && arr[6] == chr)
        )
            flag = true;
        return flag;
    }

    public static int getCnt(char[] arr, char chr) {
        int cnt = 0;
        for(int i = 0; i < 9; i++)
            if(arr[i] == chr)
                cnt++;

        return cnt;
    }
}


/*
무승부 케이스
xoo
oxx
xxo
* */