package ps3048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/3048
 * 개미
 * */
class Ant {
    char nm;
    int dir;

    public Ant(char nm, int dir) {
        this.nm = nm;
        this.dir = dir;
    }
}

public class Main {
    static int n1, n2, t;
    static char[] ant1, ant2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n1 = Integer.parseInt(st.nextToken());
        n2 = Integer.parseInt(st.nextToken());
        ant1 = br.readLine().toCharArray();
        ant2 = br.readLine().toCharArray();
        t = Integer.parseInt(br.readLine());

        Ant[] arr = new Ant[n1 + n2];
        for (int i = 0; i < n1; i++) {
            arr[n1 - i - 1] = new Ant(ant1[i], 1);
        }
        for (int i = 0; i < n2; i++) {
            arr[n1 + i] = new Ant(ant2[i], 2);
        }

        while(t > 0) {
            for (int i = 0; i < n1 + n2 - 1; i++) {
                if(arr[i].dir != 2 && arr[i].dir != arr[i + 1].dir) {
                    Ant tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;

                    // i++;
                    if(arr[i + 1].nm == ant1[0])
                        break;
                }
            }

            t--;
        }

        for (int i = 0; i < n1 + n2; i++) {
            System.out.print(arr[i].nm);
        }
    }
}
