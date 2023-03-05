package ps7490;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * https://www.acmicpc.net/problem/7490
 * */
public class Main {
    static ArrayList<String> list;
    static String calc;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        while(t > 0) {
            n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            calc = "1";

            dfs(2, 1, 1, "");

            //Collections.sort(list);
            for(String s: list)
                sb.append(s).append("\n");
            sb.append("\n");
            t--;
        }

        System.out.println(sb);
    }

    public static void dfs(int num, int sum, int bfNum, String bfOp) {
        //System.out.println(calc + ", " + sum + ", " + bfNum + ", " + bfOp);
        if(num == n + 1) {
            if(sum == 0)
                list.add(calc);
            return;
        }
        calc += " " + num;
        int nn = bfNum * 10;
        if(bfOp.equals("+") || bfOp.equals(""))
            nn += num;
        else if(bfOp.equals("-"))
            nn += (num * -1);
        dfs(num + 1, sum + nn - bfNum, nn, bfOp);
        calc = calc.substring(0, calc.length() - 2);

        calc += "+" + num;
        dfs(num + 1, sum + num, num, "+");
        calc = calc.substring(0, calc.length() - 2);

        calc += "-" + num;
        dfs(num + 1, sum - num, (num * -1), "-");
        calc = calc.substring(0, calc.length() - 2);

    }
}


/*
1+2-3+4-5-6+7
1+2-3-4+5+6-7
1-2 3+4+5+6+7
1-2 3-4 5+6 7
1-2+3+4-5+6-7
1-2-3-4-5+6+7

1 2-3-4-5
 * */