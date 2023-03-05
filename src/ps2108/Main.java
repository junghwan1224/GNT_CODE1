package ps2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * https://www.acmicpc.net/problem/2108
 * */

public class Main {
    static int N;
    static Map<Integer, Integer> map;
    static int[] arr;
    static int max, min;
    static double avg;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        arr = new int[N];
        max = -987654321;
        min = 987654321;

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            map.put(a, map.getOrDefault(a, 0) + 1);
            arr[i] = a;
            max = Math.max(max, a);
            min = Math.min(min, a);
            avg += (double)a;
        }

        int key = -987654321;
        int val = -987654321;
        for(int i: map.keySet()) {
            if(map.get(i) > val) {
                val = map.get(i);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i: map.keySet()) {
            if(map.get(i) == val) {
                list.add(i);
            }
        }

        Collections.sort(list);
        key = list.size() > 1 ? list.get(1) : list.get(0);

        Arrays.sort(arr);
        avg = Math.round(avg / N);

        StringBuffer sb = new StringBuffer();
        sb.append((int)avg).append("\n");
        sb.append(arr[N / 2]).append("\n");
        sb.append(key).append("\n");
        sb.append(max - min).append("\n");

        System.out.println(sb);
    }
}
