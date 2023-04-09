package ps1943;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1943
 * */
class Coin {
    int price;
    int cnt;

    public Coin(int price, int cnt) {
        this.price = price;
        this.cnt = cnt;
    }
}

public class Main {
    static int MAX = 50001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 0; t < 3; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] d = new int[MAX];
            Coin[] arr = new Coin[n];
            int sum = 0;

            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int price = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                arr[i] = new Coin(price, cnt);
                sum += (price * cnt);
            }

            if(sum % 2 == 1) {
                System.out.println(0);
                continue;
            }

            d[0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = MAX - 1; j >= 0; j--) {
                    if(j - arr[i].price >= 0 && d[j - arr[i].price] == 1) {
                        for (int k = 0; k < arr[i].cnt; k++) {
                            if(j + arr[i].price * k < MAX)
                                d[j + arr[i].price * k] = 1;
                        }
                    }
                }
            }

            System.out.println(d[sum / 2]);
        }
    }
}
